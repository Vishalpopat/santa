package com.example.santa.controller;

import com.example.santa.resource.HoodFillerRequest;
import com.example.santa.resource.HoodFillerResponse;
import com.example.santa.service.SantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SantaController {

    @Autowired
    SantaService santaService;

    @PostMapping("/hoodfiller")
    public HoodFillerResponse generateHoodFiller(@RequestBody HoodFillerRequest hoodFillerRequest){
        return  santaService.generateHoodFiller(hoodFillerRequest);
    }
}
