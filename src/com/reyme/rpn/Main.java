package com.reyme.rpn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean done = false;
        // create new rpn calculator instance
        RPNCalculator cal = new RPNCalculator();
        // process user input until done is equal to true
        Scanner scan = new Scanner(System.in);
        while(!done) {
            String in = scan.next();
            done = "q".equalsIgnoreCase(in);
            cal.processUserInput(in);
        }
    }
}
