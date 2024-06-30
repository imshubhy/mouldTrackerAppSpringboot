package com.indoplast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indoplast.DTO.MouldDTO;
import com.indoplast.model.Mould;
import com.indoplast.repository.MouldRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MouldService {

    private final MouldRepository mouldRepository;

    @Autowired
    public MouldService(MouldRepository mouldRepository) {
        this.mouldRepository = mouldRepository;
    }

    public List<MouldDTO> getAllMoulds() {
        List<Mould> moulds = mouldRepository.findAll();
        return moulds.stream()
                .map(this::mapMouldToDTO)
                .collect(Collectors.toList());
    }

    public MouldDTO saveMould(MouldDTO mouldDTO) {
        Mould mould = new Mould();
        mould.setName(mouldDTO.getName());
        mould.setManufacturer(mouldDTO.getManufacturer());
        mould.setLocation(mouldDTO.getLocation());
        mould.setLastMaintenanceDate(mouldDTO.getLastMaintenanceDate());
        mould.setTotalProductionsMade(mouldDTO.getTotalProductionsMade()); // Ensure this is set

        Mould savedMould = mouldRepository.save(mould);
        return mapMouldToDTO(savedMould);
    }

    public MouldDTO getMouldById(Long id) {
        Optional<Mould> optionalMould = mouldRepository.findById(id);
        if (optionalMould.isPresent()) {
            return mapMouldToDTO(optionalMould.get());
        } else {
            throw new RuntimeException("Mould not found with id " + id);
        }
    }

    private MouldDTO mapMouldToDTO(Mould mould) {
        MouldDTO dto = new MouldDTO();
        dto.setId(mould.getId());
        dto.setName(mould.getName());
        dto.setManufacturer(mould.getManufacturer());
        dto.setLocation(mould.getLocation());
        dto.setLastMaintenanceDate(mould.getLastMaintenanceDate());
        dto.setTotalProductionsMade(mould.getTotalProductionsMade()); // Ensure this is mapped
        return dto;
    }
}
