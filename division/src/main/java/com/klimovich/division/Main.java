package com.klimovich.division;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a dividend");
            int dividend = scanner.nextInt();
            System.out.println("Enter a divisor");
            int divisor = scanner.nextInt();
            Calculator calculator = new Calculator();
            ResultOfDivision result = calculator.devider(dividend, divisor);
            Viev viev = new Viev();
            viev.showResult(result);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}