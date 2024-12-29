package com.mathexample.mathapi.service.impl;

import com.mathexample.mathapi.service.MathOperationService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
@Service
public class MathOperationServiceImpl implements MathOperationService {
    @Override
    public List<Integer> findMinValues(List<Integer> numbers, int quantifier) {
        if(numbers ==null || quantifier<=0 || quantifier> numbers.size()){
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Min-heap to store the smallest 'quantifier'takes O(nlog k) k is the number of element return , while sorting takes O(nlogn)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numbers);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<quantifier;i++){
            result.add(minHeap.poll());
        }
        return result;
    }
    @Override
    public List<Integer> findMaxNumber(List<Integer> numbers, int quantifier) {
        if(numbers ==null || quantifier<0 || quantifier> numbers.size()){
            throw new IllegalArgumentException("Invalid input parameters");
        }
        // Min-heap to store the smallest 'quantifier'takes O(nlog k) k is the number of element return , while sorting takes O(nlogn)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: numbers){
            minHeap.offer(num);
            if(minHeap.size()>quantifier){
                minHeap.poll();
            }
        }
        List<Integer> maxValues = new ArrayList<>(minHeap);
        maxValues.sort(Collections.reverseOrder());
        return maxValues;
    }

    @Override
    public double calculateAverage(List<Double> numList) {
        if(numList==null || numList.isEmpty()){
            throw new IllegalArgumentException("List of numbers cannot be Null or empty");
        }
        double sum=0;
        for(double num:numList){
            sum+=num;
        }
        return sum/numList.size();
    }

    @Override
    public double calculateMedian(List<Integer> numbers) {
        if(numbers==null || numbers.isEmpty()){
            throw new IllegalArgumentException("List of numbers cannot be null or empty");
        }
        // sort the list
        Collections.sort(numbers);
        int size =numbers.size();
        if(size % 2 ==1){
            //If the list size is odd return the middle element
            return numbers.get(size/2);
        }else{
            //If the list size is even return the average of the two middle elements
            double middle1=numbers.get(size/2 -1);
            double middle2=numbers.get(size/2);
            return (middle1+middle2)/2;
        }
    }

    @Override
    public double calculatePercentile(List<Double> numbers, double q) {
        if(numbers==null || numbers.isEmpty()){
            throw new IllegalArgumentException("List of numbers cannot be null or empty");
        }
        if(q < 0|| q > 100){
            throw new IllegalArgumentException("Percentile q must be between 0 and 100.");
        }
        // Sort the numbers in ascending order
        Collections.sort(numbers);
        int n=numbers.size();
        // calculate the index of the percentile
        double index=(q/100.0)*(n-1);
        // Interpolate between numbers if the index is not an integer
        int lowerIndex=(int)Math.floor(index);
        int upperIndex=(int)Math.ceil(index);
        if(lowerIndex==upperIndex){
            return numbers.get(lowerIndex);
        }else{
            double lowerValue= numbers.get(lowerIndex);
            double upperValue=numbers.get(upperIndex);
            return lowerValue+(upperValue-lowerValue)*(index-lowerIndex);
        }
    }

}
