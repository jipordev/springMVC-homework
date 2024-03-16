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
        model.addAttribute("todoList", todoListService.getById(id));
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

    @GetMapping("/todo/delete/{id}")
    public String deleteTodoById(@PathVariable("id") Integer id){
        todoListService.delete(id);
        return "redirect:/todo";
    }

    @GetMapping("/todo/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model){
        Todo todo = todoListService.getById(id);
        model.addAttribute("todo", todo);
        return "update";
    }
    @PostMapping("/todo/update")
    public String updateTodo(@ModelAttribute Todo todo) {
        todoListService.update(todo);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchTasks(@RequestParam(value = "task", required = false) String task,
                              @RequestParam(value = "isDone", required = false) Boolean isDone,
                              Model model) {
        if (task != null) {
            model.addAttribute("todoList", todoListService.searchList(task));
        } else if (isDone != null) {
            model.addAttribute("todoList", todoListService.searchByIsDone(isDone));
        }
        return "index";
    }


}
