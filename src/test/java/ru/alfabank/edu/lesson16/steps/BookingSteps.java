package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;

import java.util.List;
import java.util.Map;

public class BookingSteps {

    // ===== Блок 1 и 2. Базовые сценарии + Background =====

    @Given("в ресторане есть столики:")
    public void вРесторанеЕстьСтолики(DataTable dataTable) {
        List<Map<String, String>> tables = dataTable.asMaps(String.class, String.class);
        System.out.println("Добавлены столики:");
        for (Map<String, String> row : tables) {
            System.out.println("  Столик №" + row.get("номер") + " на " + row.get("вместимость") + " мест");
        }
    }

    @Given("все столики уже забронированы")
    public void всеСтоликиУжеЗабронированы() {
        System.out.println("Все столики заняты");
    }

    @Given("все столики вместимостью менее {int} человек")
    public void всеСтоликиВместимостьюМенееЧеловек(int capacity) {
        System.out.println("Все столики вместимостью менее " + capacity + " человек");
    }

    @Given("гость забронировал столик на {int} человека")
    public void гостьЗабронировалСтоликНаЧеловека(int guests) {
        System.out.println("Бронирование на " + guests + " человека выполнено");
    }

    @When("гость бронирует столик на {int} человек")
    public void гостьБронируетСтоликНаЧеловек(int guests) {
        System.out.println("Попытка бронирования на " + guests + " человек");
    }

    @When("гость пытается забронировать столик на {int} человек")
    public void гостьПытаетсяЗабронироватьСтоликНаЧеловек(int guests) {
        System.out.println("Попытка бронирования на " + guests + " человек");
    }

    @When("гость отменяет своё бронирование")
    public void гостьОтменяетСвоёБронирование() {
        System.out.println("Отмена бронирования");
    }

    @When("гость оставляет пожелание к брони:")
    public void гостьОставляетПожеланиеКБрони(String wish) {
        System.out.println("Пожелание клиента:");
        System.out.println(wish);
    }

    @Then("бронирование успешно подтверждено")
    public void бронированиеУспешноПодтверждено() {
        System.out.println("Бронирование подтверждено");
    }

    @Then("столик забронирован для {int} человек")
    public void столикЗабронированДляЧеловек(int guests) {
        System.out.println("Столик забронирован для " + guests + " человек");
    }

    @Then("гость получает отказ")
    public void гостьПолучаетОтказ() {
        System.out.println("Отказ в бронировании");
    }

    @Then("сообщение: {string}")
    public void сообщение(String message) {
        System.out.println("Сообщение: " + message);
    }

    @Then("бронирование отменено")
    public void бронированиеОтменено() {
        System.out.println("Бронирование отменено");
    }

    @Then("столик снова доступен")
    public void столикСноваДоступен() {
        System.out.println("Столик доступен для бронирования");
    }

    @Then("пожелание сохранено")
    public void пожеланиеСохранено() {
        System.out.println("Пожелание сохранено");
    }

    // ===== Блок 3. Scenario Outline =====

    @Given("в ресторане есть свободный столик вместимостью {int} мест")
    public void вРесторанеЕстьСвободныйСтоликВместимостьюМест(int capacity) {
        System.out.println("Свободный столик на " + capacity + " мест");
    }

    @Then("результат бронирования: {word}")
    public void результатБронирования(String result) {
        System.out.println("Результат: " + result);
    }

}