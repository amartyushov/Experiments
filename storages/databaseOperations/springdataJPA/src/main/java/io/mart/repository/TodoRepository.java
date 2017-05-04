package io.mart.repository;

import io.mart.entities.Todo;

/**
 * Just an example how can you do
 *
 * @author Aleksandr Martiushov
 */

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}