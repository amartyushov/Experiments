package io.mart;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.mart.Constants.EPIC_CREATE_USER;

@Epic(EPIC_CREATE_USER)
public class UserTest {

    @BeforeMethod(description = "Initial setup for user creation")
    public void setup() {
        Executor.cleanupData();
    }

    @Test(description = "Create user")
    @Description("This is a description for createUser")
    @Severity(SeverityLevel.CRITICAL)
    public void createUser(){
        Executor.login("Sasha", "Mart");
        Checker.checkCorrectLogin("Sasha", "Mart");
    }

    @Issue("KOALA-460")
    @Test(description = "Create invalid user")
    @Description("This is a description for createInvalidUser")
    public void createInvalidUser(){
        Executor.login("Sasha", "BlaBla");
        Checker.checkCorrectLogin("Sasha", "BlaBla");
    }
}
