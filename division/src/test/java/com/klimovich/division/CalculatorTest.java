package com.klimovich.division;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void devider_ShouldThrowIllegalArgumentException_WhenInputDivisorIsZero() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.devider(78945, 0);
        });
        Assertions.assertEquals("Divisor cannot be 0, division by zero", exception.getMessage());
    }

    @Test
    void devider_ShouldThrowIllegalArgumentException_WhenInputOneOrTwoInputNambersAreNegative() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.devider(-78945, 3);
        });
        Assertions.assertEquals("Program don't work with negative numbers", exception.getMessage());
    }

    @Test
    void devider_ShouldMakeListOfSteps_WhenInputDataPositiveIntAndDivisorNotZero() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(7, 4, 2));
        steps.add(new Step(38, 36, 3));
        steps.add(new Step(29, 28, 4));
        steps.add(new Step(14, 12, 5));
        steps.add(new Step(25, 24, 6));
        ResultOfDivision expectedResult = new ResultOfDivision(78945, 4, steps);
        Assertions.assertEquals(expectedResult.getSteps(), calculator.devider(78945, 4).getSteps());
    }

    @Test
    void devider_ShouldReturnObjectResultOfDivision_WhenInputDataPositiveIntAndDivisorNotZero() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(10, 10, 3));
        ResultOfDivision expectedResult = new ResultOfDivision(100, 10, steps);
        Assertions.assertEquals(expectedResult, calculator.devider(100, 10));
    }

    @Test
    void devider_ShouldReturnResultOfDivisionWithObjectStepWithDataDividendAndDevisor_WhenDividendLessThatDivisor() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(12, 123, 3));
        ResultOfDivision expectedResult = new ResultOfDivision(12, 123, steps);
        Assertions.assertEquals(calculator.devider(12, 123).getSteps().get(0).getIntermediateDividend(),
                expectedResult.getSteps().get(0).getIntermediateDividend());
        Assertions.assertEquals(calculator.devider(12, 123).getSteps().get(0).getNearestInteger(),
                expectedResult.getDivisor());
    }

    @Test
    void devider_ShouldReturnResultOfDivisionWithObjectStepWithDataDividendAndDevisor_WhenDividendIsZero() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(0, 123, 2));
        ResultOfDivision expectedResult = new ResultOfDivision(0, 123, steps);
        Assertions.assertEquals(calculator.devider(0, 123).getSteps().get(0).getIntermediateDividend(),
                expectedResult.getSteps().get(0).getIntermediateDividend());
        Assertions.assertEquals(calculator.devider(0, 123).getSteps().get(0).getNearestInteger(),
                expectedResult.getDivisor());
    }

    @Test
    void devider_ShouldReturnResultOfDivision_WhenDivisionHaveStagesWithZeroResult() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(10, 10, 3));
        steps.add(new Step(10, 10, 7));
        ResultOfDivision expectedResult = new ResultOfDivision(1000100, 10, steps);
        Assertions.assertEquals(expectedResult, calculator.devider(1000100, 10));
    }

}
