package ru.netology.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.pageobject.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement code = $("[data-test-id=code] input");
    private SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public DashBoard validVerify(DataHelper.VerificationCode verificationCode) {
        code.setValue(verificationCode.getCode());
        verificationButton.click();
        return new DashBoard();
    }
}
