package ru.alfabank.edu.lesson19;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }



    @Test
    void successfulLoginAndLogoutTest() {
        // 1. Открыть страницу
        open("https://the-internet.herokuapp.com/");

        // 2. Кликнуть по ссылке Form Authentication
        $("a[href='/login']").click();

        // 3. Проверить заголовок
        $("h2").shouldHave(text("Login Page"));

        // 4-5. Установить Username и Password
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");

        // 6. Нажать Login
        $("button[type='submit']").click();

        // 7. Проверить сообщение результата
        $("#flash").shouldHave(text("You logged into a secure area!"));

        // 8. Проверить наличие кнопки Logout
        $("a[href='/logout']").shouldBe(visible);

        // 9. Нажать Logout
        $("a[href='/logout']").click();

        // 10. Проверить заголовок
        $("h2").shouldHave(text("Login Page"));
    }

    @Test
    void invalidLoginTest() {
        // 1. Открыть страницу
        open("https://the-internet.herokuapp.com/");

        // 2. Кликнуть по ссылке Form Authentication
        $("a[href='/login']").click();

        // 3. Проверить ссылку Elemental Selenium внизу страницы
        $("a[href='http://elementalselenium.com/']")
                .shouldHave(text("Elemental Selenium"));

        // 4-5. Установить Username и Password
        $("#username").setValue("admin");
        $("#password").setValue("1234");

        // 6. Нажать Login
        $("button[type='submit']").click();

        // 7. Проверить сообщение об ошибке
        $("#flash").shouldHave(text("Your username is invalid!"));
    }
}
