package ru.alfabank.edu.lesson16.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("========================================");
        System.out.println("▶ Начинаем сценарий: " + scenario.getName());
        System.out.println("  Теги: " + scenario.getSourceTagNames());
        System.out.println("----------------------------------------");
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("----------------------------------------");
        if (scenario.isFailed()) {
            System.out.println("❌ Сценарий ПРОВАЛЕН: " + scenario.getName());
        } else {
            System.out.println("✅ Сценарий УСПЕШНО выполнен: " + scenario.getName());
        }
        System.out.println("========================================");
        System.out.println();
    }
}
