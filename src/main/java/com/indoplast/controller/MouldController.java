package com.indoplast.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.indoplast.model.Mould;
import com.indoplast.services.MouldService;



@Controller
@RequestMapping("/api/moulds")
public class MouldController {

    @Autowired
    private MouldService mouldService;

    @PostMapping("/insert")
    @ResponseBody
    public Mould insertMould(@RequestBody Mould mould) {
        return mouldService.saveMould(mould);
    }
}