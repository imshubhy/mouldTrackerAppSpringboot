package com.indoplast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indoplast.DTO.MouldUsageDTO;
import com.indoplast.model.Mould;
import com.indoplast.model.MouldUsage;
import com.indoplast.repository.MouldRepository;
import com.indoplast.repository.MouldUsageRepository;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MouldUsageService {

    private final MouldUsageRepository mouldUsageRepository;
    private final MouldRepository mouldRepository;

    @Autowired
    public MouldUsageService(MouldUsageRepository mouldUsageRepository, MouldRepository mouldRepository) {
        this.mouldUsageRepository = mouldUsageRepository;
        this.mouldRepository = mouldRepository;
    }

    public List<MouldUsageDTO> getAllMouldUsages() {
        List<MouldUsage> mouldUsages = mouldUsageRepository.findAll();
        return mouldUsages.stream()
                .map(this::mapMouldUsageToDTO)
                .collect(Collectors.toList());
    }

    public MouldUsageDTO getMouldUsageById(Long logId) {
        MouldUsage mouldUsage = mouldUsageRepository.findById(logId)
                .orElseThrow(() -> new EntityNotFoundException("Mould Usage not found with logId: " + logId));
        return mapMouldUsageToDTO(mouldUsage);
    }
    
    public MouldUsageDTO issueMould(Long mouldId, String receiverName) {
        Mould mould = mouldRepository.findById(mouldId).orElseThrow(() -> new RuntimeException("Mould not found"));
        
        MouldUsage mouldUsage = new MouldUsage();
        mouldUsage.setMould(mould);
        mouldUsage.setIssueDate(LocalDate.now());
        mouldUsage.setReceiverName(receiverName);
        mouldUsageRepository.save(mouldUsage);
        
        return mapMouldUsageToDTO(mouldUsage);
    }

    public MouldUsageDTO returnMould(Long logId, int productionsMade) {
        MouldUsage mouldUsage = mouldUsageRepository.findById(logId)
                .orElseThrow(() -> new EntityNotFoundException("Mould Usage not found with logId: " + logId));

        mouldUsage.setProductionsMade(productionsMade);
        mouldUsage.setReturnDate(LocalDate.now());

        Mould mould = mouldUsage.getMould();
        int updatedTotalProductions = mould.getTotalProductionsMade() + productionsMade; // Calculate new total
        mould.setTotalProductionsMade(updatedTotalProductions); // Set new total
        mouldRepository.save(mould); // Save the updated mould entity

        MouldUsage savedMouldUsage = mouldUsageRepository.save(mouldUsage);
        return mapMouldUsageToDTO(savedMouldUsage);
    }

    private MouldUsageDTO mapMouldUsageToDTO(MouldUsage mouldUsage) {
        MouldUsageDTO mouldUsageDTO = new MouldUsageDTO();
        mouldUsageDTO.setLogId(mouldUsage.getLogId());
        mouldUsageDTO.setMouldId(mouldUsage.getMould().getId());
        mouldUsageDTO.setProductionsMade(mouldUsage.getProductionsMade());
        mouldUsageDTO.setIssueDate(mouldUsage.getIssueDate());
        mouldUsageDTO.setReturnDate(mouldUsage.getReturnDate());
        mouldUsageDTO.setReceiverName(mouldUsage.getReceiverName());
        return mouldUsageDTO;
    }
}
