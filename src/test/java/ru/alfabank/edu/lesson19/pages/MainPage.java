package ru.alfabank.edu.lesson19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement formAuthenticationLink = $("a[href='/login']");

    public MainPage openPage() {
        open("https://the-internet.herokuapp.com/");
        return this;
    }

    public LoginPage clickFormAuthentication() {
        formAuthenticationLink.click();
        return new LoginPage();
    }
}