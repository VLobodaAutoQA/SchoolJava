package ru.alfabank.edu.lesson11;

public class CoffeeMachine {
    public final int VOLUME_OF_WATER_FOR_COFFEE = 200;

    public void makeCoffee(int waterMilliliters) {
        if (waterMilliliters <= VOLUME_OF_WATER_FOR_COFFEE) {
            throw new NotEnoughWaterException("Ошибка! Для приготовления кофе объем воды должен быть больше 200мл. Текущий уровень: " + waterMilliliters);
        }
        System.out.println("Кофе приготовлен!");
    }

    public int calculateCups(int volumeWater, int volumeCup) {
            return volumeWater / volumeCup;
    }

    public void printCoffeeName(String nameCoffe) {
        if (nameCoffe == null) {
            throw new NullPointerException("Ошибка: название кофе отсутствует");
        }
        String uppercaseNameCoffee = nameCoffe.toUpperCase();
        System.out.println("Название кофе большими буквами: " + uppercaseNameCoffee);
    }
}
