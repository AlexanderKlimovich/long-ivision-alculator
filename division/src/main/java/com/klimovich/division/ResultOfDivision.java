package com.klimovich.division;

import java.util.List;
import java.util.Objects;

public class ResultOfDivision {
    private int dividend;
    private int divisor;
    private List<Step> steps;

    public ResultOfDivision(int dividend, int divisor, List<Step> steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.steps = steps;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, steps);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResultOfDivision other = (ResultOfDivision) obj;
        return dividend == other.dividend && divisor == other.divisor && Objects.equals(steps, other.steps);
    }

}
