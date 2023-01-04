package com.klimovich.division;

import java.util.Scanner;

public class ColumnDivision extends Thread {
    @Override
    public void run() {
	try (Scanner scanner = new Scanner(System.in)) {
	    System.out.println("Enter a dividend");
	    int dividend = Integer.parseInt(scanner.nextLine());
	    System.out.println("Enter a divisor");
	    int divisor = Integer.parseInt(scanner.nextLine());
	    Calculator calculator = new Calculator();
	    Viev viev = new Viev();
	    viev.showResult(dividend, divisor, calculator.devider(dividend, divisor));
	} catch (NumberFormatException e) {
	    e.printStackTrace();
	}
    }
}
