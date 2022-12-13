package com.example.calculator.dto;

import com.example.calculator.service.MathOperator;
import com.example.calculator.serviceImpl.MathOperatorImpl;
import com.example.calculator.utils.InvalidOperationException;
import lombok.SneakyThrows;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MathOperatorImplTest {
    private MathOperator mathOperator = new MathOperatorImpl();

    @SneakyThrows
    @Test
    public void multiplication_success() {
        double operand1 = 10;
        double operand2 = 4;
        String operation = "*";
        double result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(40, result);
    }

    @SneakyThrows
    @Test
    public void division_success() {
        double operand1 = 15;
        double operand2 = 3;
        String operation = "/";
        double expectedResult = 5;

        double result = mathOperator.doMath(operand1, operand2, operation);

        assertEquals(expectedResult, result);
    }
    @Test
    public void testDivisionByZero() {
        double operand1 = 15;
        double operand2 = 0;
        String operation = "/";

        assertThrows(InvalidOperationException.class, () -> {
            mathOperator.doMath(operand1, operand2, operation);
        });
    }

    @SneakyThrows
    @Test
    public void subtration_success() {
        double operand1 = 20.0;
        double operand2 = 5.0;
        String operation = "-";

        double result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(15.0, result);
    }

    @SneakyThrows
    @Test
    public void power_success() {
        double result = mathOperator.doMath(2, 2, "**");
        assertEquals(4, result);
    }

    @SneakyThrows
    @Test
    public void log_success() {
        MathOperatorImpl mathOperator = new MathOperatorImpl();
        double operand1 = 2;
        double operand2 = 8;
        String operation = "log";
        double expected = operand1 * Math.log10(operand2);

        double result = mathOperator.doMath(operand1, operand2, operation);

        assertEquals(expected, result);
    }

    @SneakyThrows
    @Test
    public void ln_success() {
        MathOperator mathOperator = new MathOperatorImpl();
        double operand1 = 9.0;
        double operand2 = 14.0;
        String operation = "ln";

        double expected = operand1 * Math.log(operand2);
        double actual = mathOperator.doMath(operand1, operand2, operation);

        assertEquals(expected, actual);
    }
}