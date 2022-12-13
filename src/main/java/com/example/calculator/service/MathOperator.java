package com.example.calculator.service;


import com.example.calculator.utils.InvalidOperationException;

public interface MathOperator{
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
