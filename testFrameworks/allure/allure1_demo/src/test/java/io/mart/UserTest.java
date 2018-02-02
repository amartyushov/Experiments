package io.mart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class UserTest {

    @BeforeMethod
    public void setup() {
        Executor.cleanupData();
    }

    @Test
    @Title("create valid user")
    @Description("This is a description for createUser")
    @Severity(SeverityLevel.CRITICAL)
    public void createUser(){
        Executor.login("Sasha", "Mart");
        Checker.checkCorrectLogin("Sasha", "Mart");
    }

    @Test
    @Title("create invalid user")
    @Description("This is a description for createInvalidUser")
    public void createInvalidUser(){
        Executor.login("Sasha", "BlaBla");
        Checker.checkCorrectLogin("Sasha", "BlaBla");
    }
}
