package ru.alfabank.edu.lesson19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement title = $("h2");
    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement flashMessage = $("#flash");
    private final SelenideElement elementalSeleniumLink =
            $("a[href='http://elementalselenium.com/']");

    public LoginPage checkTitle(String expectedText) {
        title.shouldHave(text(expectedText));
        return this;
    }

    public LoginPage checkElementalSeleniumLinkVisible() {
        elementalSeleniumLink.shouldHave(text("Elemental Selenium"));
        return this;
    }

    public LoginPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    /** Успешный логин — попадаем на Secure Area */
    public SecureAreaPage clickLoginSuccess() {
        loginButton.click();
        return new SecureAreaPage();
    }

    /** Неуспешный логин — остаёмся на Login Page */
    public LoginPage clickLoginFail() {
        loginButton.click();
        return this;
    }

    public LoginPage checkFlashMessage(String expectedText) {
        flashMessage.shouldHave(text(expectedText));
        return this;
    }
}
