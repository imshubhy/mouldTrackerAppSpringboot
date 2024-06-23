package com.indoplast.controller;
import com.indoplast.DTO.MouldUsageDTO;
import com.indoplast.services.MouldUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mouldUsages")
public class MouldUsageController {

    private final MouldUsageService mouldUsageService;

    @Autowired
    public MouldUsageController(MouldUsageService mouldUsageService) {
        this.mouldUsageService = mouldUsageService;
    }

    @GetMapping
    public List<MouldUsageDTO> getAllMouldUsages() {
        return mouldUsageService.getAllMouldUsages();
    }

    @GetMapping("/{logId}")
    public MouldUsageDTO getMouldUsageById(@PathVariable Long logId) {
        return mouldUsageService.getMouldUsageById(logId);
    }
    
    @PostMapping("/issue/{mouldId}")
    public ResponseEntity<MouldUsageDTO> issueMould(@PathVariable Long mouldId, @RequestParam String receiverName) {
        MouldUsageDTO mouldUsageDTO = mouldUsageService.issueMould(mouldId, receiverName);
        return ResponseEntity.ok(mouldUsageDTO);
    }
    
    
 
    
    
    
    @PostMapping("/return/{logId}")
    public MouldUsageDTO returnMould(@PathVariable Long logId, @RequestParam int productionsMade) {
        return mouldUsageService.returnMould(logId, productionsMade);
    }
}
