package co.istad.todolist.controller;



import co.istad.todolist.model.Todo;
import co.istad.todolist.service.TodoListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private final TodoListServiceImpl todoListService;

    TodoController(TodoListServiceImpl todoListService){
        this.todoListService = todoListService;
    }

    @GetMapping("/todo")
    public String getAll(Model model){
        model.addAttribute("todoList", todoListService.getAll());
        return "index";
    }
    @GetMapping("/todo/{id}")
    public String getById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("todos", todoListService.getById(id));
        return "index";
    }


    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo){
        todoListService.create(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/add")
    public String showAddForm(Model model){
        Todo newTodo = new Todo();
        newTodo.setIsDone(false);
        newTodo.setCreatedAt(LocalDate.now());
        model.addAttribute("todo",newTodo);
        return ("add");
    }

    @GetMapping("/todo/search")
    public String searchTask(@RequestParam("task") String task, Model model) {
        model.addAttribute("todoLists", todoListService.searchList(task));
        return "index"; // Return only the table fragment of the index page
    }

}
