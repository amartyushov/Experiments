package io.mart.repo;

import org.springframework.stereotype.Repository;

@Repository
public class UserProvider {

    public User createUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }
}
