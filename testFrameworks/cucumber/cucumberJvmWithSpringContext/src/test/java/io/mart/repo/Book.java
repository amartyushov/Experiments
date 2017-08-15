package io.mart.repo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String name;
}
