package com.indoplast.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indoplast.model.Mould;
import com.indoplast.model.MouldUsageDTO;
import com.indoplast.services.MouldService;
import com.indoplast.services.MouldUsageService;

@RestController
@RequestMapping("/api/mouldUsages")

public class MouldUsageController {

    private final MouldUsageService mouldUsageService;
    private final MouldService mouldService;

    public MouldUsageController(MouldUsageService mouldUsageService, MouldService mouldService) {
        this.mouldUsageService = mouldUsageService;
        this.mouldService = mouldService;
    }

    @PostMapping("/issue/{mouldId}")
    public MouldUsageDTO issueMould(@PathVariable Long mouldId) {
        return mouldUsageService.issueMould(mouldId);
    }

    @PostMapping("/{logId}/return")
    public MouldUsageDTO returnMould(@PathVariable Long logId, @RequestParam int productionsMade) {
        return mouldUsageService.returnMould(logId, productionsMade);
    }

    @PostMapping("/insertMould")
    public Mould insertMould(@RequestBody Mould mould) {
        return mouldService.saveMould(mould);
    }
}
