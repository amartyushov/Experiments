package io.mart.checkers;

import io.mart.repo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Service
public class UserChecker {

    public void checkBookName(User user, String bookName){
        assertThat(bookName).isEqualTo(user.getBook().getName());
    }
}
