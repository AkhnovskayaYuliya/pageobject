package ru.netology.pageobject.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.pageobject.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static SelenideElement login = $("[data-test-id=login] input");
    private static SelenideElement password = $("[data-test-id=password] input");
    private static SelenideElement loginButton = $("[data-test-id=action-login]");

    public static VerificationPage validLogin(DataHelper.AuthInfo info) {
        login.setValue(info.getLogin());
        password.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
