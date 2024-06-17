package com.indoplast.controller;


import com.indoplast.DTO.MouldDTO;
import com.indoplast.services.MouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moulds")
public class MouldController {

    private final MouldService mouldService;

    @Autowired
    public MouldController(MouldService mouldService) {
        this.mouldService = mouldService;
    }

    @GetMapping
    public List<MouldDTO> getAllMoulds() {
        return mouldService.getAllMoulds();
    }
    

    @PostMapping
    public MouldDTO createMould(@RequestBody MouldDTO mouldDTO) {
        return mouldService.saveMould(mouldDTO);
    }
    
    @GetMapping("/{id}")
    public MouldDTO getMouldById(@PathVariable Long id) {
        return mouldService.getMouldById(id);
    }
    
    
    
}
