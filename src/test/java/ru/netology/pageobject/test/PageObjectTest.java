package ru.netology.pageobject.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pageobject.data.DataHelper;
import ru.netology.pageobject.pages.DashBoard;
import ru.netology.pageobject.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.pageobject.data.DataHelper.getNumberOfTheFirstCard;
import static ru.netology.pageobject.data.DataHelper.getNumberOfTheSecondCard;

public class PageObjectTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashBoard = verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferFromTheSecondCardToTheFirst() {
        var firstCardBalance = DashBoard.getCardBalance(getNumberOfTheFirstCard().getCardNumber());
        var secondCardBalance = DashBoard.getCardBalance(getNumberOfTheSecondCard().getCardNumber());
        var transferPage = DashBoard.transferToFirstCard();
        int amount = 5000;
        transferPage.moneyTransfer(amount, getNumberOfTheSecondCard());
        Assertions.assertEquals(firstCardBalance + amount, DashBoard.getCardBalance(getNumberOfTheFirstCard().getCardNumber()));
        Assertions.assertEquals(secondCardBalance - amount, DashBoard.getCardBalance(getNumberOfTheSecondCard().getCardNumber()));
    }

    @Test
    void shouldNotTransferMoney() {
        var firstCardBalance = DashBoard.getCardBalance(getNumberOfTheFirstCard().getCardNumber());
        var secondCardBalance = DashBoard.getCardBalance(getNumberOfTheSecondCard().getCardNumber());
        var transferPage = DashBoard.transferToFirstCard();
        int amount = 15000;
        transferPage.moneyTransfer(amount, getNumberOfTheSecondCard());
        transferPage.error();
    }
}


