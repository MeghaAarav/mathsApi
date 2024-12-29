package com.mathexample.mathapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(MathApiController.class)
class MathApiControllerTest {
   @Autowired
	private MockMvc mockMvc;
   @Test
   public void testFindMax() throws Exception {
       mockMvc.perform(get("/math/max?numList=1&numList=2&quantifier=2")
                       .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().string("[2,1]"));
   }
    @Test
    public void testFindMaxWithNULLList() throws Exception {
        mockMvc.perform(get("/math/max?numList=null &quantifier=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testFindMaxWithNULLQuantifier() throws Exception {
        mockMvc.perform(get("/math/max?numList=1 &quantifier=null")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCalculateAverage() throws Exception {
        mockMvc.perform(get("/math/avg?numList=1.0 &numList=2.0&numList=3.0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }
    @Test
    public void testCalculateAverageWithNull() throws Exception {
        mockMvc.perform(get("/math/avg?numList=null")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testCalculateAverageWithSingleValue() throws Exception {
        mockMvc.perform(get("/math/avg?numList=10.0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));
    }

    @Test
    public void testCalculateMedianValue() throws Exception {
        mockMvc.perform(get("/math/median?numList=3 &numList=1&numList=4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }
    @Test
    public void testCalculateMedianEvenSize() throws Exception {
        mockMvc.perform(get("/math/median?numList=3 &numList=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }
    @Test
    public void testCalculateMedianWithNull() throws Exception {
        mockMvc.perform(get("/math/median?numList=null")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testFindMin() throws Exception {
        mockMvc.perform(get("/math/min?numList=1&numList=2&quantifier=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[1,2]"));
    }
    @Test
    public void testFindMinWithNULLList() throws Exception {
        mockMvc.perform(get("/math/min?numList=null &quantifier=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testFindMinWithNULLQuantifier() throws Exception {
        mockMvc.perform(get("/math/min?numList=1 &quantifier=null")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testCalculatePercentile() throws Exception {
        mockMvc.perform(get("/math/percentile?numList=1.0 &numList=2.0&numList=3.0&quantifier=40")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("1.8"));
    }
    @Test
    public void testCalculatePercentileWithNull() throws Exception {
        mockMvc.perform(get("/math/percentile?numList=null &quantifier=40")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testCalculatePercentileWithSingleValue() throws Exception {
        mockMvc.perform(get("/math/percentile?numList=10.0 &quantifier=50")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));
    }


}
