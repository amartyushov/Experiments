package io.mart;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class Executor {

    @Step("Login to the system")
    public static void login(String name, String password){
        enterName(name);
        enterPassword(password);
    }

    @Step("Enter user name: {0}")
    @Attachment
    private static String enterName(String name){
        return name;
    }

    @Step("Enter user password: {0}")
    @Attachment
    private static String enterPassword(String password){
        return password;
    }

    @Step("Cleanup test data")
    public static void cleanupData() { }

    @Step("Create message with title: {0}")
    @Attachment
    public static String createMessage(String title){
        return title;
    }
}
