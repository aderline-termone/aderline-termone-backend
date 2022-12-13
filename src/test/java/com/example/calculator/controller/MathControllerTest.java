package com.example.calculator.controller;

import com.example.calculator.dto.DoMathRequest;
import com.example.calculator.service.MathOperator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebMvcTest(MathControllerTest.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
public class MathControllerTest {

    @MockBean
    private MathOperator mathOperator;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void doMath_success() throws Exception {
        DoMathRequest mathDTO = new DoMathRequest((double) 1, (double) 3, "*");
        double operand1 = mathDTO.getOperand1();
        double operand2 = mathDTO.getOperand2();
        String operation = mathDTO.getOperation();
        when(mathOperator.doMath(operand1, operand2, operation)).thenReturn((double) 0);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/doMath")
                .content(mapper.writeValueAsString(mathDTO))
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }


}
