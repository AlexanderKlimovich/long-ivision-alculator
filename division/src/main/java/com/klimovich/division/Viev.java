package com.klimovich.division;

import java.util.ArrayList;
import java.util.List;

public class Viev {

    public void showResult(ResultOfDivision dataForViev) {
        Integer dividend = dataForViev.getDividend();
        int divisor = dataForViev.getDivisor();
        List<Step> steps = dataForViev.getSteps();
        List<String> strings;
        if (dividend == 0) {
            strings = makeStringsWhenDividendIsZero(dividend, divisor);
            for (String string : strings) {
                System.out.println(string);
            }
        } else if (dividend < divisor) {
            strings = makeStringsWhendividendLeesThanDivisor(dividend, divisor);
            for (String string : strings) {
                System.out.println(string);
            }
        } else {
            strings = modifyStrings(dividend, divisor, makeStrings(steps, dividend, divisor));
            for (String string : strings) {
                System.out.println(string);
            }
        }
    }

    private List<String> makeStringsWhenDividendIsZero(int dividend, int divisor) {
        List<String> strings = new ArrayList<>();
        strings.add(String.format("_%d%s|%d", dividend, makeDivider(countLengthOfNumber(divisor) - 1, ' '), divisor));
        strings.add(String.format(" %d|%s", dividend % divisor, makeDivider(countLengthOfNumber(divisor),
                '-')));
        strings.add(String.format(" %s|%d", makeDivider(countLengthOfNumber(divisor), ' '), dividend));
        return strings;
    }

    private List<String> makeStringsWhendividendLeesThanDivisor(int dividend, int divisor) {
        List<String> strings = new ArrayList<>();
        strings.add(String.format("_%d|%d", dividend, divisor));
        strings.add(String.format(" %d%s|%s", 0, makeDivider(countLengthOfNumber(dividend) - 1, ' '), makeDivider(
                countLengthOfNumber(divisor), '-')));
        strings.add(String.format(" %s%s|%d", '-', makeDivider(countLengthOfNumber(dividend) - 1, ' '), 0));
        strings.add(String.format(" %d", dividend % divisor));
        return strings;
    }

    private List<String> makeStrings(List<Step> steps, int dividend, int divisor) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            int intermediateDividend = steps.get(i).getIntermediateDividend();
            int nearestInteger = steps.get(i).getNearestInteger();
            int lengthOfLine = steps.get(i).getlengthOfLine();
            if (intermediateDividend >= divisor) {
                strings.add(String.format("%" + lengthOfLine + "s", "_" + intermediateDividend));
                strings.add(String.format("%" + lengthOfLine + "d", nearestInteger));
                int tab = lengthOfLine - countLengthOfNumber(nearestInteger);
                int divider = countLengthOfNumber(nearestInteger);
                strings.add(makeDivider(tab, ' ') + makeDivider(divider, '-'));
            }
        }

        int lengthOfString = strings.get(strings.size() - 1).length();
        strings.add(String.format("%" + lengthOfString + "s", "" + dividend % divisor));

        return strings;
    }

    private List<String> modifyStrings(int dividend, int divisor, List<String> strings) {
        List<String> finalStrings = strings;
        finalStrings.set(0, String.format("_%d|%d", dividend, divisor));
        int tab1 = finalStrings.get(0).length() - strings.get(1).length() - 1 - countLengthOfNumber(divisor);
        finalStrings.set(1, strings.get(1) + makeDivider(tab1, ' ') + "|"
                + makeDivider(countLengthOfNumber(dividend / divisor), '-'));
        int tab2 = countLengthOfNumber(dividend) - strings.get(2).length() + 1;
        finalStrings.set(2, strings.get(2) + makeDivider(tab2, ' ') + "|" + dividend / divisor);

        return finalStrings;
    }

    private static int countLengthOfNumber(int i) {
        return (int) Math.log10(i) + 1;
    }

    private String makeDivider(int length, char ch) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < (length); i++)
            result.append(ch);
        return result.toString();
    }

}
