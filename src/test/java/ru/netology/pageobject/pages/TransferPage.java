package ru.netology.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.pageobject.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class TransferPage {

    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private final SelenideElement sum = $("[data-test-id='amount'] input");
    private final SelenideElement fromCard = $("[data-test-id='from'] input");
    private final SelenideElement header = $(byText("Пополнение карты"));
    private final SelenideElement errorMessage = $("[data-test-id='error-message']");

    public TransferPage() {
        header.shouldBe(visible);
    }


    public DashBoard moneyTransfer(int amount, DataHelper.CardInfo from) {
        sum.setValue(valueOf(amount));
        fromCard.setValue(valueOf(from));
        transferButton.click();
        return new DashBoard();
        }

        public void Error() {
            $(byText("Невозможно осуществить перевод, так как сумма превышает баланс.")).shouldBe(visible);
        }
    }