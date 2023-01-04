package com.klimovich.division;

import java.util.Objects;

public class Step {

    private int intermediateDividend;
    private int nearestInteger;
    private int lengthOfLine;

    public Step(int intermediateDividend, int nearestInteger, int lengthOfLine) {
        this.intermediateDividend = intermediateDividend;
        this.nearestInteger = nearestInteger;
        this.lengthOfLine = lengthOfLine;
    }

    public int getIntermediateDividend() {
        return intermediateDividend;
    }

    public int getNearestInteger() {
        return nearestInteger;
    }

    public int getlengthOfLine() {
        return lengthOfLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(intermediateDividend, lengthOfLine, nearestInteger);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Step other = (Step) obj;
        return intermediateDividend == other.intermediateDividend && lengthOfLine == other.lengthOfLine
                && nearestInteger == other.nearestInteger;
    }

}
