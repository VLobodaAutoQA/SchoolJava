package ru.alfabank.edu.lesson10;

import net.datafaker.idnumbers.SouthAfricanIdNumber;

import java.util.ArrayList;

public class TaskTracker {
    public ArrayList<Task> tasks = new ArrayList<>();

    // добавить новую задачу в список
    public void addTask(String nameTask) {
        Task newTask = new Task(nameTask);
        tasks.add(newTask);
        System.out.println("Добавлена новая задача: " + nameTask);
    }

    // вывести все задачи
    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            System.out.println();
        }

        System.out.println("=== Список задач ===");
        for (Task task : tasks) {
            task.printInfoTask();
        }
        System.out.println();

    }

    // пометить задачу как сделанную (на базе переданного имени задачи)
    public void markTaskAsDone(String nameTask) {
        for (Task task : tasks) {
            if (!tasks.contains(task)) {
                System.out.println("Задача с названием: " + nameTask + " не найдена!");
            }
            else {
                task.isDone();
                System.out.println("Задача: " + nameTask + " отмечена как выполненная!");
            }
        }
    }

    // получить статус задачи по переданному названию (выполнена или нет)
    public boolean getStatusTask(String nameTask) {
        for (Task task : tasks) {
            if (task.getNameTask().equalsIgnoreCase(nameTask)) {
                return task.isDone();
            }
        }
        System.out.println("Задача с названием: " + nameTask + " не найдена!");
        return false;
    }

    // вывести статистику по задачам. вывод в формате: Всего задач: 3 Выполнено: 1 Открыто: 2
    public void getStatisticsTasks() {
        int totalTasks = tasks.size();
        int doneTasks = 0;
        int openTasks = 0;

        for (Task task : tasks) {
            if (task.isDone()) {
                doneTasks++;
            } else {
                openTasks++;
            }
        }

        System.out.println("=== Статистика по задачам ===");
        System.out.println("Всего задач: " + totalTasks);
        System.out.println("Выполнено: " + doneTasks);
        System.out.println("Открыто: " + openTasks);
    }



}
