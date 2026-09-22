package ru.alfabank.edu.lesson20.steps;

import ru.alfabank.edu.lesson20.Calculator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {

    private final Calculator calculator = new Calculator();

    @Step("Сложить {a} + {b}")
    public double add(double a, double b) {
        double result = calculator.add(a, b);
        attachCalculation(a, "+", b, result);
        return result;
    }

    @Step("Вычесть {a} - {b}")
    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        attachCalculation(a, "-", b, result);
        return result;
    }

    @Step("Умножить {a} * {b}")
    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        attachCalculation(a, "*", b, result);
        return result;
    }

    @Step("Разделить {a} / {b}")
    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        attachCalculation(a, "/", b, result);
        return result;
    }

    @Step("Возвести {base} в степень {exponent}")
    public double power(double base, double exponent) {
        double result = calculator.power(base, exponent);
        Allure.addAttachment("Вычисление степени",
                base + " ^ " + exponent + " = " + result);
        return result;
    }

    @Step("Извлечь квадратный корень из {value}")
    public double sqrt(double value) {
        double result = calculator.sqrt(value);
        Allure.addAttachment("Вычисление корня",
                "sqrt(" + value + ") = " + result);
        return result;
    }

    @Step("Проверить, что результат {actual} равен ожидаемому {expected}")
    public void verifyResult(double actual, double expected) {
        assertEquals(expected, actual, 1e-9,
                "Ожидалось " + expected + ", получено " + actual);
    }

    // Приватный хелпер для аттачмента (не шаг — просто утилита)
    private void attachCalculation(double a, String op, double b, double result) {
        Allure.addAttachment("Вычисление",
                a + " " + op + " " + b + " = " + result);
    }
}
