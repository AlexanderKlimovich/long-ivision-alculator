package com.klimovich.division;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VievTest {

    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenDivisionHaveMoreThanOneDivisionStage() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(7, 4, 2));
        steps.add(new Step(38, 36, 3));
        steps.add(new Step(29, 28, 4));
        steps.add(new Step(14, 12, 5));
        steps.add(new Step(25, 24, 6));
        ResultOfDivision result = new ResultOfDivision(78945, 4, steps);
        String expected = new StringJoiner(System.lineSeparator())
                .add("_78945|4")
                .add(" 4    |-----")
                .add(" -    |19736")
                .add("_38")
                .add(" 36")
                .add(" --")
                .add(" _29")
                .add("  28")
                .add("  --")
                .add("  _14")
                .add("   12")
                .add("   --")
                .add("   _25")
                .add("    24")
                .add("    --")
                .add("     1")
                .toString();
        Viev viev = new Viev();
        viev.showResult(result);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenDivisionHaveStagesWithZeroResult() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(10, 10, 3));
        steps.add(new Step(10, 10, 7));
        ResultOfDivision result = new ResultOfDivision(1000100, 10, steps);
        String expected = new StringJoiner(System.lineSeparator())
                .add("_1000100|10")
                .add(" 10     |------")
                .add(" --     |100010")
                .add("    _10")
                .add("     10")
                .add("     --")
                .add("      0")
                .toString();
        Viev viev = new Viev();
        viev.showResult(result);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenDividendIsZero() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(0, 1, 2));
        ResultOfDivision result = new ResultOfDivision(0, 1, steps);
        String expected = new StringJoiner(System.lineSeparator())
                .add("_0|1")
                .add(" 0|-")
                .add("  |0")
                .toString();
        Viev viev = new Viev();
        viev.showResult(result);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void showResult_ShouldPrintToConsole_WhenDivisorLongerThatDividend() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(12, 1234, 3));
        ResultOfDivision result = new ResultOfDivision(12, 1234, steps);
        String expected = new StringJoiner(System.lineSeparator())
                .add("_12|1234")
                .add(" 0 |----")
                .add(" - |0")
                .add(" 12")
                .toString();
        Viev viev = new Viev();
        viev.showResult(result);
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

}
