package ru.alfabank.edu.lesson13;

import java.util.LinkedList;
import java.util.Objects;

public class AssaultQueue {
    private LinkedList<String> queue;

    public AssaultQueue() {
        this.queue = new LinkedList<>();
    }

    public void addRecruit(String name) {
        queue.addLast(name);
        System.out.println("Добавлен рекрут: " + name);
    }

    public String retreatCoward() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста!");
            return null;
        }
        String coward = queue.removeFirst();
        System.out.println("Удалён трус из начала очереди: " + coward);
        return coward;
    }

    public void printQueue() {
        System.out.println("Текущее состояние очереди: " + queue);
    }

    @Override
    public String toString() {
        return "AssaultQueue{" +
                "queue=" + queue +
                ", size=" + queue.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssaultQueue that = (AssaultQueue) o;
        return Objects.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(queue);
    }
}