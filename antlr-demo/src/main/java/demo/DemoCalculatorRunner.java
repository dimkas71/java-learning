package demo;

import java.util.Scanner;

public class DemoCalculatorRunner {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        System.out.println("Enter expression to calculate:");

        Scanner scanner = new Scanner(System.in);

        String experssion = scanner.nextLine();

        try {
            int result = calculator.evaluate(experssion);

            System.out.println("Result of evaluation = " + result);

        } catch (CalculatorException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
            e.printStackTrace();
        }


    }
}
