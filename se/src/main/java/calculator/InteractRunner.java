package calculator;

import java.util.Scanner;

public class InteractRunner {
    private static String first;
    private static String second;
    private static final Scanner reader = new Scanner(System.in);
    private static String comand;
    private static String exit = "no";

    /**
     * main cicle
     *
     * @param agrs
     */
    public static void main(String[] agrs) {
        try {
            final Calculator calc = new Calculator();

            while (!exit.equals("yes")) {
                enterArgs();
                switchComand(calc);
                getResult(calc);
            }
        } finally {
            reader.close();
        }
    }

    /**
     * для ввода мараметров калькулятора и для выбора команды вычисления
     */
    private static void enterArgs() {
        System.out.println("Enter first arg");
        first = reader.next();
        System.out.println("Enter second arg");
        second = reader.next();
        System.out.println("enter operation: 1 - add, 2 - minus, 3 - multiply, 4 - divide, 5 - pow");
        comand = reader.next();
    }

    /**
     *  выаоляет указынную команду над аргументами
     * @param calc
     */
    private static void switchComand(Calculator calc) {
        switch (comand) {
            case "1":
                calc.add(Integer.valueOf(first), Integer.valueOf(second));
                break;

            case "2":
                calc.minus(Integer.valueOf(first), Integer.valueOf(second));
                break;

            case "3":
                calc.multiply(Integer.valueOf(first), Integer.valueOf(second));
                break;

            case "4":
                try {
                    calc.divide(Integer.valueOf(first), Integer.valueOf(second));
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                    System.out.println("please enter correct data");
                }
                break;

            case "5":
                calc.stepen(Integer.valueOf(first), Integer.valueOf(second));
                break;
        }
    }

    /**
     * выводит результат
     * @param calc
     */
    private static void getResult(Calculator calc) {
        System.out.println("getResult = " + calc.getResult());
        System.out.println("clear getResult? yes/no");
        String clear = reader.next();

        if (clear.equals("yes")) {
            calc.cleanResult();
        }

        System.out.println("Exit? yes/no");
        exit = reader.next();
    }
}