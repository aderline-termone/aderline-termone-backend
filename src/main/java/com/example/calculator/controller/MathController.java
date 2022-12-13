package com.example.calculator.controller;

import com.example.calculator.dto.DoMathRequest;
import com.example.calculator.utils.ApiResponse;
import com.example.calculator.utils.InvalidOperationException;
import com.example.calculator.service.MathOperator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doMath")
public class MathController {

    private final MathOperator mathOperator;

    public MathController(MathOperator mathOperator) {
        this.mathOperator = mathOperator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> doMath(@Valid @RequestBody DoMathRequest doMathRequest) {
        try {
            return ResponseEntity.ok(ApiResponse.success(this.mathOperator.doMath(doMathRequest.getOperand1(), doMathRequest.getOperand2(), doMathRequest.getOperation())));
        }
        catch(InvalidOperationException e) {
            e.printStackTrace();
            return ResponseEntity.ok(ApiResponse.fail(e.toString()));
        }
    }
}
