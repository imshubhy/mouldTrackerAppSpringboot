package com.indoplast.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.indoplast.model.Mould;
import com.indoplast.model.MouldUsage;
import com.indoplast.model.MouldUsageDTO;
import com.indoplast.repository.MouldRepository;
import com.indoplast.repository.MouldUsageRepository;

@Service
public class MouldUsageService {

    private final MouldUsageRepository mouldUsageRepository;
    private final MouldRepository mouldRepository;

    public MouldUsageService(MouldUsageRepository mouldUsageRepository, MouldRepository mouldRepository) {
        this.mouldUsageRepository = mouldUsageRepository;
        this.mouldRepository = mouldRepository;
    }

    public MouldUsageDTO issueMould(Long mouldId) {
        Mould mould = mouldRepository.findById(mouldId)
                .orElseThrow(() -> new RuntimeException("Mould not found"));

        MouldUsage usage = new MouldUsage();
        usage.setMould(mould);
        usage.setTakenAt(LocalDateTime.now());

        MouldUsage savedUsage = mouldUsageRepository.save(usage);
        return new MouldUsageDTO(savedUsage);
    }

    public MouldUsageDTO returnMould(Long logId, int productionsMade) {
        java.util.Optional<MouldUsage> optionalUsage = mouldUsageRepository.findById(logId);
        if (!optionalUsage.isPresent()) {
            throw new RuntimeException("Mould usage log not found");
        }

        MouldUsage usage = optionalUsage.get();
        usage.setReturnedAt(LocalDateTime.now());
        usage.setProductions(productionsMade);

        // Update the total productions for the mould
        Mould mould = usage.getMould();
        mould.setTotalProductions(mould.getTotalProductions() + productionsMade);

        MouldUsage savedUsage = mouldUsageRepository.save(usage);
        return new MouldUsageDTO(savedUsage);
    }
}
