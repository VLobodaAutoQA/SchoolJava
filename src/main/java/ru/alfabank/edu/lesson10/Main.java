package ru.alfabank.edu.lesson10;

public class Main {
    static void main() {
        TaskTracker tracker = new TaskTracker();

        // Добавляем задачи
        tracker.addTask("Проверить авторизацию");
        tracker.addTask("Проверить регистрацию");
        tracker.addTask("Написать тесты");
        tracker.addTask("Исправить баги");

        System.out.println();

        System.out.println("--- Выводим все задачи ---");
        tracker.printAllTasks();

        System.out.println("--- Отмечаем задачи ---");
        tracker.markTaskAsDone("Проверить регистрацию");
        tracker.markTaskAsDone("Написать тесты");

        System.out.println();

        System.out.println("--- Проверяем статус ---");
        boolean status = tracker.getStatusTask("Проверить авторизацию");


        System.out.println();

        System.out.println("--- Статистика ---");
        tracker.printStatistics();

        System.out.println("--- Обновленный список ---");
        tracker.printAllTasks();
    }
}
