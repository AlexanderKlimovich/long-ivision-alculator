package com.klimovich.division;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public ResultOfDivision devider(int dividend, int divisor) {
        List<Step> steps = searchStepsOfDivision(dividend, divisor);
        return new ResultOfDivision(dividend, divisor, steps);
    }

    private List<Step> searchStepsOfDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        if (dividend < 0 | divisor < 0) {
            throw new IllegalArgumentException("Program don't work with negative numbers");
        }
        List<Step> stepsOfDivision = new ArrayList<>();
        if (dividend == 0 | dividend < divisor) {
            Step step = new Step(dividend, divisor, Integer.toString(dividend).length() + 1);
            stepsOfDivision.add(step);
        } else {
            String[] digits = String.valueOf(dividend).split("");
            StringBuilder reminder = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                reminder.append(digits[i]);
                int intermediateDivident = Integer.parseInt(reminder.toString());
                if (intermediateDivident >= divisor) {
                    int lengthOfLine = i + 2;
                    int nearestInteger = intermediateDivident / divisor * divisor;
                    Step step = new Step(intermediateDivident, nearestInteger, lengthOfLine);
                    stepsOfDivision.add(step);
                    intermediateDivident = intermediateDivident % divisor;
                    reminder.replace(0, reminder.length(), Integer.toString(intermediateDivident % divisor));
                    intermediateDivident = Integer.parseInt(reminder.toString());
                }
            }
        }
        return stepsOfDivision;
    }
}
