package ru.alfabank.edu.lesson19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SecureAreaPage {

    private final SelenideElement flashMessage = $("#flash");
    private final SelenideElement logoutButton = $("a[href='/logout']");

    public SecureAreaPage checkFlashMessage(String expectedText) {
        flashMessage.shouldHave(text(expectedText));
        return this;
    }

    public SecureAreaPage checkLogoutButtonVisible() {
        logoutButton.shouldBe(visible);
        return this;
    }

    public LoginPage clickLogout() {
        logoutButton.click();
        return new LoginPage();
    }
}
