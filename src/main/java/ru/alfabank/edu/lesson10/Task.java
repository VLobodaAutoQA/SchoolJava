package ru.alfabank.edu.lesson10;

public class Task {
    private String nameTask;
    private boolean isDone;

    public Task (String nameTask) {
        this.nameTask = nameTask;
    }
    // пометить задачу как выполненную
    public void markAsDone() {
        isDone = true;
    }

    // получить статус - выполнена задача или нет
    public boolean getStatus() {
        return isDone;
    }

    // получить название задачи
    public String getName() {
        return nameTask;
    }

    // вывести информацию о задаче
    public void printInfo() {
        if (isDone) {
            System.out.println("[x] " + nameTask);
        } else {
            System.out.println("[ ] " + nameTask);
        }
    }
}
