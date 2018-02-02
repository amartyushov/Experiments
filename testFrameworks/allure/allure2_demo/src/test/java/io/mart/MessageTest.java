            package io.mart;

            import io.qameta.allure.*;
            import org.testng.annotations.BeforeMethod;
            import org.testng.annotations.Test;

            import static io.mart.Constants.EPIC_CREATE_USER;
            import static io.mart.Constants.FEATURE_CREATE_MESSAGE;

            @Epic(FEATURE_CREATE_MESSAGE)
            public class MessageTest {

                @BeforeMethod(description = "Initial setup for user creation")
                public void setup() {
                    Executor.cleanupData();
                }

                @Test(description = "Create message")
                @Description("This is a description for createMessage")
                @Severity(SeverityLevel.BLOCKER)
                public void createMessage(){
                    Executor.createMessage("Welcome message");
                    Checker.checkCorrectMessage("Welcome message");
                }

                @Feature(EPIC_CREATE_USER)
                @Test(description = "Create invalid message")
                @Description("This is a description for createInvalidMessage")
                public void createInvalidMessage(){
                    Executor.createMessage("Bad message");
                    Checker.checkCorrectMessage("Bad message");
                }
            }








