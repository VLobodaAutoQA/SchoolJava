package ru.alfabank.edu.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {

    public void demonstrateListCreations() {
        // основной отряд: new ArrayList<>()
        List<String> mainSquad = new ArrayList<>();
        mainSquad.add("Основной_1");
        mainSquad.add("Основной_2");
        mainSquad.add("Основной_3");
        mainSquad.add("Основной_4");
        System.out.println("Основной отряд (new ArrayList<>()): " + mainSquad);

        // отряд поддержки: Arrays.asList()
        List<String> supportSquad = Arrays.asList("Поддержка_1", "Поддержка_2", "Поддержка_3");
        System.out.println("Отряд поддержки (Arrays.asList()): " + supportSquad);

        // элитный отряд: List.of()
        List<String> eliteSquad = List.of("Элитный_1", "Элитный_2");
        System.out.println("Элитный отряд (List.of()): " + eliteSquad);

        // Добавление в основной отряд
        try {
            mainSquad.add("Новый_основной_5");
            System.out.println("✓ Добавление в основной отряд: УСПЕХ");
        } catch (Exception e) {
            System.out.println("✗ Добавление в основной отряд: " + e.getClass().getSimpleName());
        }

        // Удаление из основного отряда
        try {
            mainSquad.remove(0);
            System.out.println("✓ Удаление из основного отряда: УСПЕХ");
        } catch (Exception e) {
            System.out.println("✗ Удаление из основного отряда: " + e.getClass().getSimpleName());
        }
        System.out.println("Основной отряд после модификации: " + mainSquad);

        // Добавление в отряд поддержки
        try {
            supportSquad.add("Новый_поддержка_4");
            System.out.println("✓ Добавление в отряд поддержки: УСПЕХ");
        } catch (Exception e) {
            System.out.println("✗ Добавление в отряд поддержки: " + e.getClass().getSimpleName());
        }

        // Удаление из отряда поддержки
        try {
            supportSquad.remove(0);
            System.out.println("✓ Удаление из отряда поддержки: УСПЕХ");
        } catch (Exception e) {
            System.out.println("✗ Удаление из отряда поддержки: " + e.getClass().getSimpleName());
        }
        System.out.println("Отряд поддержки после попыток: " + supportSquad);

        // Добавление в элитный отряд
        try {
            eliteSquad.add("Новый_элитный_3");
            System.out.println("✓ Добавление в элитный отряд: УСПЕХ");
        } catch (Exception e) {
            System.out.println("✗ Добавление в элитный отряд: " + e.getClass().getSimpleName());
        }

        // Удаление из элитного отряда
        try {
            eliteSquad.remove(0);
            System.out.println("✓ Удаление из элитного отряда: УСПЕХ");
        } catch (Exception e) {
            System.out.println("✗ Удаление из элитного отряда: " + e.getClass().getSimpleName());
        }
        System.out.println("Элитный отряд после попыток: " + eliteSquad);
    }

    public void filterOutCowards(List<String> squad) {
        System.out.println("=== Фильтрация трусов ===");
        System.out.println("Отряд до фильтрации: " + squad);

        // Используем Iterator для удаления
        Iterator<String> iterator = squad.iterator();
        int removedCount = 0;

        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.startsWith("Трус")) {
                iterator.remove();
                removedCount++;
            }
        }

        System.out.println("Удалено трусов: " + removedCount);
        System.out.println("Отряд после фильтрации: " + squad);
    }
}
