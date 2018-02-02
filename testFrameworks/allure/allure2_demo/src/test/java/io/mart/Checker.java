package io.mart;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class Checker {

    @Step("Check login was successfull")
    public static void checkCorrectLogin(String name, String pass){
        assertThat(name).isEqualTo("Sasha");
        assertThat(pass).isEqualTo("Mart");
    }

    @Step("Check message is correct")
    public static void checkCorrectMessage(String title){
        assertThat(title).isEqualTo("Welcome message");
    }
}
