package crudOperation.repo;

import crudOperation.entity.AppUser;
import crudOperation.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUser(AppUser user);
}
