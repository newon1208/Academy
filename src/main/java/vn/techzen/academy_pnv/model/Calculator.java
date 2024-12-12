package vn.techzen.academy_pnv.model;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private double result;

    public Calculator(double firstNumber, double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = calculateResult();
    }

    private double calculateResult() {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }

    public double getResult() {
        return result;
    }
}