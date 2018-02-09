package io.mart;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Executor {

    @Step("Login to the system")
    public static void login(String name, String password) {
        enterName(name);
        enterPassword(password);
    }

    @Step("Enter user name: {0}")
    @Attachment
    private static String enterName(String name) {
        return name;
    }

    @Step("Enter user password: {0}")
    @Attachment
    private static String enterPassword(String password) {
        return password;
    }

    @Step("Cleanup test data")
    public static void cleanupData() {
    }

    @Step("Create message with title: {0}")
    public static String createMessage(String title) {
        return title;
    }
}
