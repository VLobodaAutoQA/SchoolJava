package ru.alfabank.edu.lesson13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ========== ЧАСТЬ 1: БАЗА ДАННЫХ ПРИШЕЛЬЦЕВ ==========
        System.out.println("========== ЧАСТЬ 1: БАЗА ДАННЫХ ПРИШЕЛЬЦЕВ ==========");

        // 1. Создайте ArrayList<Alien>
        ArrayList<Alien> aliens = new ArrayList<>();

        // 2. Добавьте 5 объектов Alien. Два из них должны иметь одинаковые имя и планету, но разный dangerLevel
        aliens.add(new Alien("Зигмунд", "Марс", 5));
        aliens.add(new Alien("Глок", "Венера", 8));
        aliens.add(new Alien("Зигмунд", "Марс", 7)); // Дубликат по имени и планете
        aliens.add(new Alien("Ксар", "Юпитер", 3));
        aliens.add(new Alien("Норг", "Сатурн", 9));

        // 3. Проверьте: содержит ли список дубликат
        boolean hasDuplicate = false;
        Alien duplicate1 = null;
        Alien duplicate2 = null;

        for (int i = 0; i < aliens.size(); i++) {
            for (int j = i + 1; j < aliens.size(); j++) {
                if (aliens.get(i).equals(aliens.get(j))) {
                    hasDuplicate = true;
                    duplicate1 = aliens.get(i);
                    duplicate2 = aliens.get(j);
                    break;
                }
            }
            if (hasDuplicate) break;
        }

        // 4. Выведите результат на экран
        System.out.println("Список пришельцев:");
        for (Alien alien : aliens) {
            System.out.println("  " + alien);
        }

        if (hasDuplicate) {
            System.out.println("\nРезультат: Список СОДЕРЖИТ дубликат!");
            System.out.println("Дублирующиеся объекты:");
            System.out.println("  " + duplicate1);
            System.out.println("  " + duplicate2);
            System.out.println("  equals(): " + duplicate1.equals(duplicate2));
            System.out.println("  hashCode(): " + duplicate1.hashCode() + " = " + duplicate2.hashCode());
        } else {
            System.out.println("\nРезультат: Дубликатов не обнаружено.");
        }

        System.out.println("\n========================================\n");

        // ========== ЧАСТЬ 2: ФОРМИРОВАНИЕ ОТРЯДОВ ==========
        System.out.println("========== ЧАСТЬ 2: ФОРМИРОВАНИЕ ОТРЯДОВ ==========");

        // 1. Создайте экземпляр SquadManager и вызовите метод demonstrateListCreations()
        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreations();

        // ========== ЧАСТЬ 3: ОТСЕИВАНИЕ ТРУСОВ ==========
        System.out.println("========== ЧАСТЬ 3: ОТСЕИВАНИЕ ТРУСОВ ==========");

        // 1. Создайте ArrayList<String> с 3 обычными именами и 2 именами на «Трус»
        ArrayList<String> squad = new ArrayList<>();
        squad.add("Иван");
        squad.add("Трус Петя");
        squad.add("Алексей");
        squad.add("Трус Вася");
        squad.add("Дмитрий");

        // 2. Передайте этот список в метод filterOutCowards
        squadManager.filterOutCowards(squad);

        // ========== ЧАСТЬ 4: ОЧЕРЕДЬ НА ВХОД ==========
        System.out.println("========== ЧАСТЬ 4: ОЧЕРЕДЬ НА ВХОД ==========");

        // 1. Создайте объект AssaultQueue
        AssaultQueue queue = new AssaultQueue();

        // 2. Добавьте 5 человек
        System.out.println("Добавление 5 рекрутов:");
        queue.addRecruit("Иван");
        queue.addRecruit("Петр");
        queue.addRecruit("Сидор");
        queue.addRecruit("Алексей");
        queue.addRecruit("Дмитрий");
        queue.printQueue();

        // 3. Имитируйте уход 2 человек из начала очереди (выведите их имена)
        System.out.println("\nУход 2 человек из начала очереди:");
        String person1 = queue.retreatCoward();
        String person2 = queue.retreatCoward();
        System.out.println("Ушедшие: " + person1 + ", " + person2);
        queue.printQueue();

        // 4. Добавьте 3 новых в конец
        System.out.println("\nДобавление 3 новых рекрутов в конец:");
        queue.addRecruit("Григорий");
        queue.addRecruit("Константин");
        queue.addRecruit("Михаил");
        queue.printQueue();

        // 5. Выведите итоговое состояние очереди
        System.out.println("\nИтоговое состояние очереди:");
        queue.printQueue();
        System.out.println("toString(): " + queue);

        System.out.println("\n========================================\n");

        // ========== ЧАСТЬ 5: ОТЧЁТ КОМАНДОВАНИЮ ==========
        System.out.println("========== ЧАСТЬ 5: ОТЧЁТ КОМАНДОВАНИЮ ==========");

        // Создаем список пришельцев для отчетов
        List<Alien> capturedAliens = new ArrayList<>();
        capturedAliens.add(new Alien("Зигмунд", "Марс", 5));
        capturedAliens.add(new Alien("Глок", "Венера", 8));
        capturedAliens.add(new Alien("Ксар", "Юпитер", 3));

        // 1. Создайте объект отчёта и выведите его на экран
        MissionReport report1 = new MissionReport("Штурм Зоны 51", capturedAliens, 50);
        System.out.println("Отчет №1:");
        System.out.println(report1);

        // 2. Создайте второй отчёт с теми же данными
        MissionReport report2 = new MissionReport("Штурм Зоны 51", capturedAliens, 50);
        System.out.println("\nОтчет №2 (с теми же данными):");
        System.out.println(report2);

        // 3. Сравните их через == и через equals()
        System.out.println("\nСравнение отчетов:");
        System.out.println("  Сравнение через == : " + (report1 == report2));
        System.out.println("  Сравнение через equals(): " + report1.equals(report2));
    }
}