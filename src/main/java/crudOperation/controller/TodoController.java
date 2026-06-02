package crudOperation.controller;
import crudOperation.entity.AppUser;
import crudOperation.entity.Todo;
import crudOperation.repo.UserRepository;
import crudOperation.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.security.Principal;

@RestController
@RequestMapping("/todos")
@CrossOrigin("*") // Allows your HTML frontend to send API requests smoothly
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserRepository userRepository;

    // create
//    @PostMapping
//    public Todo createTodo(@RequestBody Todo todo){
//        return todoService.addTodo(todo);
//    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo,
                           Principal principal){

        String username = principal.getName();

        AppUser user =
                userRepository.findByUsername(username);

        todo.setUser(user);

        return todoService.addTodo(todo);
    }

    // getAll
    @GetMapping
    public List<Todo> getAll(Principal principal){

        String username = principal.getName();

        AppUser user =
                userRepository.findByUsername(username);

        return todoService.getTodosByUser(user);
    }
    // getOne
    @GetMapping("/{id}")
    public Todo getById(@PathVariable int id){
        return todoService.getById(id);
    }
    // update
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id){
    boolean deleted = todoService.deleteTodo(id);
    if(deleted){
        return "Todo deleted successfully";
    }
    return "Todo not found";
    }



}
