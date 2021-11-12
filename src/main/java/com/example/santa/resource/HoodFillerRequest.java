package com.example.santa.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HoodFillerRequest {

    @JsonProperty("hood_capacity")
    private int hoodCapacity;
    @JsonProperty("present_weights")
    private List<Integer> presentWeights;
}
