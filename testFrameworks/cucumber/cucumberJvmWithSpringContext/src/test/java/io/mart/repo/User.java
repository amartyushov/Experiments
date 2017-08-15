package io.mart.repo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter @Getter @NoArgsConstructor
@Component
public class User {
    private String name;

    @Autowired
    private Book book;

}
