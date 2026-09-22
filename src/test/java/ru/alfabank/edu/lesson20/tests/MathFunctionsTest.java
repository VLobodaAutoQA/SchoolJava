package ru.alfabank.edu.lesson20.tests;

import ru.alfabank.edu.lesson20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Калькулятор")
@Feature("Математические функции")
@DisplayName("Математические функции")
public class MathFunctionsTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ivanov")
    @Description("Проверяем возведение 2 в степень 10 — ожидаем 1024")
    @DisplayName("Возведение в степень")
    public void testPower() {
        double result = steps.power(2, 10);
        steps.verifyResult(result, 1024);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("ivanov")
    @Description("Извлечение корня из отрицательного числа должно выбрасывать ArithmeticException")
    @DisplayName("Корень из отрицательного числа — ожидаем исключение")
    public void testSqrtNegative() {
        Allure.parameter("значение", -16);

        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> steps.sqrt(-16));

        Allure.addAttachment("Текст исключения", ex.getMessage());
    }

    // Специально ПАДАЮЩИЙ тест — чтобы в отчёте был пример FAIL с шагами и вложениями
    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.MINOR)
    @Owner("ivanov")
    @Description("Демонстрационный падающий тест: ожидаем 5, но получаем 4 — чтобы показать FAIL в отчёте")
    @DisplayName("Демо-FAIL: неверное ожидание для sqrt(16)")
    public void testSqrtFailDemo() {
        double result = steps.sqrt(16);
        steps.verifyResult(result, 5); // намеренно неверное ожидание → FAIL
    }
}