package com.mathexample.mathapi.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MathOperationService {
    public List<Integer>findMinValues(List<Integer> numbers,int quantifier);
    public List<Integer> findMaxNumber(List<Integer> numbers,int quantifier);
    public double calculateAverage(List<Double> numList);
    public double calculateMedian(List<Integer> numbers);
    public double calculatePercentile(List<Double> numList, double q);

}
