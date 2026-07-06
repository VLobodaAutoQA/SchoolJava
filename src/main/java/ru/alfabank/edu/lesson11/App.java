package ru.alfabank.edu.lesson11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static void main() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Scanner scnner = new Scanner(System.in);

        System.out.println("=== 3.1. Проверка InputMismatchException ===");
        try {
            System.out.println("Введите количество воды: ");
            int waterAmount = scnner.nextInt();
            System.out.println("Вы ввели: " + waterAmount);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        }

        System.out.println();
        System.out.println("=== 3.2. Проверить своё исключение NotEnoughWaterException ===");
        try {
            coffeeMachine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        System.out.println();
        System.out.println("=== 3.3. Проверить ArithmeticException ===");
        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        System.out.println();
        System.out.println("=== 3.4. Проверить NullPointerException ===");
        String coffeName = null;
        try {
            coffeeMachine.printCoffeeName(coffeName);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
