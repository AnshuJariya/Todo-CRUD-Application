package crudOperation.service;

import crudOperation.entity.AppUser;
import crudOperation.entity.Todo;
import crudOperation.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // CREATE
    public Todo addTodo(Todo todo){
        return todoRepository.save(todo);
    }

    // GET USER TODOS
    public List<Todo> getTodosByUser(AppUser user){
        return todoRepository.findByUser(user);
    }

    // GET ONE
    public Todo getById(int id){
        return todoRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Todo updateTodo(int id, Todo updatedTodo){

        Todo existingTodo = getById(id);

        if(existingTodo != null){

            existingTodo.setContent(updatedTodo.getContent());

            return todoRepository.save(existingTodo);
        }

        return null;
    }

    // DELETE
    public boolean deleteTodo(int id){

        Todo todo = getById(id);

        if(todo != null){

            todoRepository.deleteById(id);

            return true;
        }

        return false;
    }
}