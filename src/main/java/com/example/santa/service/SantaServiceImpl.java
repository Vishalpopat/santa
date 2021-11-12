package com.example.santa.service;

import com.example.santa.resource.HoodFillerRequest;
import com.example.santa.resource.HoodFillerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SantaServiceImpl implements  SantaService{

    @Override
    public HoodFillerResponse generateHoodFiller(HoodFillerRequest hoodFillerRequest) {
        HoodFillerResponse hoodFillerResponse = new HoodFillerResponse();
        List<Integer> integers = minimumWeights(hoodFillerRequest);
        hoodFillerResponse.setWeights(integers);
        return hoodFillerResponse;
    }
    private List<Integer> minimumWeights(HoodFillerRequest hoodFillerRequest){
        int total = hoodFillerRequest.getHoodCapacity();
        List<Integer> presentWeights = hoodFillerRequest.getPresentWeights();
        int cap[] = new int[total + 1];
        int w[] = new int[total + 1];
        cap[0] = 0;
        for(int i=1; i <= total; i++){
            cap[i] = Integer.MAX_VALUE-1;
            w[i] = -1;
        }
        for(int j=0; j < presentWeights.size(); j++){
            for(int i=1; i <= total; i++){
                if(i >= presentWeights.get(j)){
                    if (cap[i - presentWeights.get(j)] + 1 < cap[i]) {
                        cap[i] = 1 + cap[i - presentWeights.get(j)];
                        w[i] = j;
                    }
                }
            }
        }
       return printCoinCombination(w, presentWeights);
    }

    private List<Integer> printCoinCombination(int cap[], List<Integer> presentWeights) {

        if (cap[cap.length - 1] == -1) {
            System.out.print("No solution is possible");
            return null;
        }
        List<Integer> op = new ArrayList<>();
        int start = cap.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = cap[start];
            op.add(presentWeights.get(j));
            start = start - presentWeights.get(j);
        }
        return op;
    }

}

