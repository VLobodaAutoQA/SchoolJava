package ru.alfabank.edu.lesson20.tests;

import ru.alfabank.edu.lesson20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Калькулятор")
@Feature("Арифметические операции")
@DisplayName("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ivanov")
    @Description("Проверяем базовое сложение двух положительных чисел: 2 + 3 должно дать 5")
    @DisplayName("Сложение двух положительных чисел")
    public void testAddPositiveNumbers() {
        double result = steps.add(2, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ivanov")
    @Description("Проверяем сложение отрицательного числа с положительным: -5 + 3 = -2")
    @DisplayName("Сложение с отрицательным числом")
    public void testAddNegativeNumber() {
        double result = steps.add(-5, 3);
        steps.verifyResult(result, -2);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем вычитание: 10 - 4 = 6")
    @DisplayName("Вычитание двух чисел")
    public void testSubtract() {
        double result = steps.subtract(10, 4);
        steps.verifyResult(result, 6);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Требование CALC-101", url = "https://example.com/calc/101")
    @DisplayName("Умножение двух чисел")
    public void testMultiply() {
        double result = steps.multiply(7, 8);
        steps.verifyResult(result, 56);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("ivanov")
    @Issue("CALC-202")
    @Description("Проверяем обычное деление: 15 / 3 = 5")
    @DisplayName("Деление двух чисел")
    public void testDivide() {
        // Динамический шаг Allure.step()
        double result = Allure.step("Выполнить деление 15 / 3", () -> steps.divide(15, 3));
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("ivanov")
    @Description("Деление на ноль должно выбрасывать ArithmeticException с сообщением 'Деление на ноль'")
    @DisplayName("Деление на ноль — ожидаем исключение")
    public void testDivideByZero() {
        // Параметр в отчёт
        Allure.parameter("делимое", 10);
        Allure.parameter("делитель", 0);

        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> steps.divide(10, 0));

        Allure.addAttachment("Текст исключения", ex.getMessage());
    }
}