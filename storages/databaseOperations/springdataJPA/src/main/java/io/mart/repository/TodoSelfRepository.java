package io.mart.repository;

/**
 * Just an example how can you do
 * (better way then CRUD repository)
 * @author Aleksandr Martiushov
 */
import io.mart.entities.Todo;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TodoSelfRepository extends Repository<Todo, Long> {

    void delete(Todo deleted);

    List<Todo> findAll();

    Optional<Todo> findOne(Long id);

    Todo save(Todo persisted);
}
