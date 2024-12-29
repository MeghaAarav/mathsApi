package com.mathexample.mathapi.controller;

import com.mathexample.mathapi.service.MathOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/math")
public class MathApiController {
    @Autowired
    MathOperationService mathOperationService;

    @GetMapping(value = "/min")
    public List<Integer>  minValue(@RequestParam List<Integer> numList,@RequestParam int  quantifier) throws IOException {
        return mathOperationService.findMinValues(numList,quantifier);
    }
        @GetMapping(value = "/max")
    public List<Integer> maxvalue(@RequestParam List<Integer> numList,@RequestParam int  quantifier) throws IOException {
        return mathOperationService.findMaxNumber(numList,quantifier);
    }
    @GetMapping(value = "/avg")
    public double avgValue(@RequestParam List<Double> numList) throws IOException {
        return mathOperationService.calculateAverage(numList);
    }
    @GetMapping(value = "/median")
    public double medianValue(@RequestParam List<Integer> numList) throws IOException {
        return mathOperationService.calculateMedian(numList);
    }
    @GetMapping(value = "/percentile")
    public double percentileValue(@RequestParam List<Double> numList, int quantifier) throws IOException {
        return mathOperationService.calculatePercentile(numList,quantifier);
    }

}
