package com.example.santa.service;

import com.example.santa.resource.HoodFillerRequest;
import com.example.santa.resource.HoodFillerResponse;

public interface SantaService {

   HoodFillerResponse generateHoodFiller(HoodFillerRequest hoodFillerRequest);
}
