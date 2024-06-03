package com.indoplast.services;

import org.springframework.stereotype.Service;

import com.indoplast.model.Mould;
import com.indoplast.repository.MouldRepository;

@Service
public class MouldService {

    private final MouldRepository mouldRepository;

    public MouldService(MouldRepository mouldRepository) {
        this.mouldRepository = mouldRepository;
    }

    public Mould saveMould(Mould mould) {
        return mouldRepository.save(mould);
    }
}
