package ru.netology.pageobject.data;

import lombok.Value;

public class DataHelper {
    private DataHelper(){
    }

    public static AuthInfo getAuthInfo(){
        return new AuthInfo("vasya","qwerty123");
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static CardInfo getNumberOfTheFirstCard() {
        return new CardInfo ("5559 0000 0000 0001");
    }

    public static CardInfo getNumberOfTheSecondCard() {
        return new CardInfo ("5559 0000 0000 0002");
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
    }




}
