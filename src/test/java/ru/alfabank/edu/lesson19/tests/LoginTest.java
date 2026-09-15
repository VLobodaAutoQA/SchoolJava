package ru.alfabank.edu.lesson19.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.alfabank.edu.lesson19.pages.LoginPage;
import ru.alfabank.edu.lesson19.pages.MainPage;
import ru.alfabank.edu.lesson19.pages.SecureAreaPage;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    private static final String VALID_USERNAME = "tomsmith";
    private static final String VALID_PASSWORD = "SuperSecretPassword!";
    private static final String INVALID_USERNAME = "admin";
    private static final String INVALID_PASSWORD = "1234";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        // Отключаем проверку утечек
        System.setProperty("chromeoptions.prefs", "profile.password_manager_leak_detection=false,credentials_enable_service=false,profile.password_manager_enabled=false");
    }

    @Test
    void successfulLoginAndLogoutTest() {
        // 1-2. Открываем главную и переходим на Login Page
        LoginPage loginPage = new MainPage()
                .openPage()
                .clickFormAuthentication();

        // 3. Проверяем заголовок
        loginPage.checkTitle("Login Page");

        // 4-6. Логинимся
        SecureAreaPage secureAreaPage = loginPage
                .setUsername(VALID_USERNAME)
                .setPassword(VALID_PASSWORD)
                .clickLoginSuccess();

        // 7-8. Проверяем результат
        secureAreaPage
                .checkFlashMessage("You logged into a secure area!")
                .checkLogoutButtonVisible();

        // 9-10. Логаут и проверка заголовка
        secureAreaPage
                .clickLogout()
                .checkTitle("Login Page");
    }

    @Test
    void invalidLoginTest() {
        // 1-3. Открываем главную, переходим на Login Page, проверяем ссылку
        LoginPage loginPage = new MainPage()
                .openPage()
                .clickFormAuthentication()
                .checkElementalSeleniumLinkVisible();

        // 4-6. Пытаемся залогиниться невалидными данными
        loginPage
                .setUsername(INVALID_USERNAME)
                .setPassword(INVALID_PASSWORD)
                .clickLoginFail()
                // 7. Проверяем сообщение об ошибке
                .checkFlashMessage("Your username is invalid!");
    }
}