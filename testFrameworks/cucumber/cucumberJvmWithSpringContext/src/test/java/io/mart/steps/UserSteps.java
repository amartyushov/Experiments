package io.mart.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import io.mart.executors.UserExecutor;
import io.mart.repo.Book;
import io.mart.repo.User;
import io.mart.repo.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Java6Assertions.assertThat;


@ContextConfiguration("classpath:cucumber.xml")
public class UserSteps {

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private UserExecutor userExecutor;

    private User user;

    @And("^User with name \"([^\"]*)\"$")
    public void userWithName(String name) throws Throwable {
        user = userProvider.createUser(name);
    }


    @And("^Assign a book \"([^\"]*)\"$")
    public void assignABook(String bookName) throws Throwable {
        userExecutor.assignBookToUser(user, new Book(bookName));
    }


    @And("^Alex has book \"([^\"]*)\"$")
    public void alexHasBook(String bookName) throws Throwable {

    }
}
