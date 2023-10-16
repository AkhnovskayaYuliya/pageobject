package ru.netology.pageobject.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashBoard {
    private SelenideElement header = $("[data-test-id=dashboard]");
    private static final ElementsCollection cards = $$(".list__item");
    private static final SelenideElement transferButton1 = $("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0'] [class=button__text]");
    private final SelenideElement transferButton2 = $("[data-test-id= '0f3f5c2a-249e-4c3d-8287-09f7a039391d'] [class=button__text]");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public DashBoard() {
        header.shouldBe(visible);
    }

    private static int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public static int getCardBalance(String cardNumber) {
        return extractBalance(cards.find(text(cardNumber.substring(15, 19))).getText());
    }

    public static TransferPage transferToFirstCard() {
        transferButton1.click();
        return new TransferPage();
    }

    public TransferPage transferToSecondCard() {
        transferButton2.click();
        return new TransferPage();
    }
}

