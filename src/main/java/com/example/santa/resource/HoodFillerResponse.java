package com.example.santa.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HoodFillerResponse {

    @JsonProperty("weights")
    private List<Integer> weights;

}
