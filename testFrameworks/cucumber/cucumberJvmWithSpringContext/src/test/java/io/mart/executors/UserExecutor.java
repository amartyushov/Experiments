package io.mart.executors;

import io.mart.repo.Book;
import io.mart.repo.User;
import org.springframework.stereotype.Service;

@Service
public class UserExecutor {

    public void assignBookToUser(User user, Book book){
        user.setBook(book);
    }
}
