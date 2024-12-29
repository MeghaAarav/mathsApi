package com.mathexample.mathapi;

import com.mathexample.mathapi.service.MathOperationService;
import com.mathexample.mathapi.service.impl.MathOperationServiceImpl;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MathOperationServiceTest {

    MathOperationService  mathOperationService = new MathOperationServiceImpl();
    @Test
    public void testCalculateAverage(){
        // Testcase1: Average of positive numbers
        List<Double> numbers1= Arrays.asList(1.0,2.0,3.0,4.0,5.0);
        double result1 = mathOperationService.calculateAverage(numbers1);
        assertEquals(3.0,result1,"Average should be 3.0");

        // Testcase2: Average of negative numbers
        List<Double> numbers2=Arrays.asList(-1.0,-2.0,-3.0,-4.0,-5.0);
        double result2 = mathOperationService.calculateAverage(numbers2);
        assertEquals(-3.0,result2,"Average should be -3.0");

        // Testcase3: Average of mix positive and negative numbers
        List<Double> numbers3=Arrays.asList(-1.0,2.0,3.0,-4.0,5.0);
        double result3= mathOperationService.calculateAverage(numbers3);
        assertEquals(1.0,result3,"Average should be 1.0");

        // Testcase4: Average of one number
        List<Double> numbers4=Arrays.asList(10.0);
        double result4= mathOperationService.calculateAverage(numbers4);
        assertEquals(10.0,result4,"Average should be 10.0");

        // Testcase5: Average of an empty list(Throw error)
        List<Double> numbers5=Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> mathOperationService.calculateAverage(numbers5));

    }
    @Test
    public void testCalculateMedianOddSize(){
        List<Integer> numbers =Arrays.asList(3,1,4,1,5,9,2);
        double median =mathOperationService.calculateMedian(numbers);
        assertEquals(3.0,median,"The median should be 3.0");
    }

    @Test
    public void testCalculateMedianEvenSize(){
        List<Integer> numbers =Arrays.asList(3,1,4,1,5,9);
        double median =mathOperationService.calculateMedian(numbers);
        assertEquals(3.5,median,"The median should be 3.5");
    }
    @Test
    public void testCalculateMedianSingleElement(){
        List<Integer> numbers =Arrays.asList(3);
        double median =mathOperationService.calculateMedian(numbers);
        assertEquals(3.0,median,"The median should be 3.0");
    }

    @Test
    public void testCalculateMedianEmptyList(){
        List<Integer> numbers =Arrays.asList();
        assertThrows(IllegalArgumentException.class,()->mathOperationService.calculateMedian(numbers));
    }

    @Test
    public void testCalculateMedianNullList(){
        List<Integer> numbers =null;
        assertThrows(IllegalArgumentException.class,()->mathOperationService.calculateMedian(numbers));
    }

    @Test
    public void testCalculatePercentile(){
        List<Double> numbers1= Arrays.asList(1.0,2.0,3.0,4.0,5.0);
        // TestCase1 : Simple case with small list
        assertEquals(2.6,mathOperationService.calculatePercentile(numbers1,40),"The Percentile should be 2.6");

        // TestCase2 : Edge case with q=0(minimum percentile)
        assertEquals(1.0,mathOperationService.calculatePercentile(numbers1,0),"The Percentile should be 1.0");

        // TestCase3 : Edge case with q=100(Maximum percentile)
        assertEquals(5.0,mathOperationService.calculatePercentile(numbers1,100),"The Percentile should be 5.0");

        // TestCase4 :Percentile in the middle of the range
        assertEquals(3.0,mathOperationService.calculatePercentile(numbers1,50),"The Percentile should be 3.0");

        // TestCase5 :List with Duplicates
        List<Double> numbers2= Arrays.asList(5.0,1.0,3.0,5.0,5.0,2.0);
        assertEquals(5.0,mathOperationService.calculatePercentile(numbers2,60),"The Percentile should be 5.0");

        // TestCase6:Edge case with single element
        List<Double> numbers3= Arrays.asList(42.0);
        assertEquals(42.0,mathOperationService.calculatePercentile(numbers3,100),"The Percentile should be 42.0");
    }
    @Test
    public void testFindMinNumbers_ValidQuantifier(){
        List<Integer> numbers = Arrays.asList(10,5,3,8,6,1,9);
        int quantifier=3;
        assertEquals(Arrays.asList(1,3,5),mathOperationService.findMinValues(numbers,quantifier));
    }

    @Test
    public void testFindMinNumbers_InValidQuantifier() {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 8, 6, 1, 9);
        int quantifier = 10;
        assertThrows(IllegalArgumentException.class, () -> mathOperationService.findMinValues(numbers,quantifier));
        // Test invalid quantifier (negative value)
        assertThrows(IllegalArgumentException.class, () -> mathOperationService.findMinValues(numbers,-1));
        // Test invalid quantifier (Zero)
        assertThrows(IllegalArgumentException.class, () -> mathOperationService.findMinValues(numbers,0));
        // Test null of List
        assertThrows(IllegalArgumentException.class, () -> mathOperationService.findMinValues(null,2));
    }

    @Test
    public void testFindMaxNumber_AllElements(){
    List<Integer> numbers = Arrays.asList(1,3,2,8,5);
    int quantifier =numbers.size();
    // Testcase 1 : Quantifier is of list size
    assertEquals(Arrays.asList(8,5,3,2,1),mathOperationService.findMaxNumber(numbers,quantifier),"The maximum number should be 8,5,3,2,1.");
    // Testcase 2 : with Quantifier as 3
    assertEquals(Arrays.asList(8,5,3),mathOperationService.findMaxNumber(numbers,3),"The maximum number should be 8,5,3.");

}

}
