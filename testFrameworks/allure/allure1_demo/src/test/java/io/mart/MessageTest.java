package io.mart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class MessageTest {

    @BeforeMethod
    public void setup() {
        Executor.cleanupData();
    }

    @Test
    @Title("create valid message")
    @Description("This is a description for createMessage")
    @Severity(SeverityLevel.BLOCKER)
    public void createMessage(){
        Executor.createMessage("Welcome message");
        Checker.checkCorrectMessage("Welcome message");
    }

    @Test
    @Title("create invalid message")
    @Description("This is a description for createInvalidMessage")
    public void createInvalidMessage(){
        Executor.createMessage("Bad message");
        Checker.checkCorrectMessage("Bad message");
    }
}
