package co.istad.todolist.repository;

import co.istad.todolist.model.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoListRepository  implements TodoRepo {

    private final List<Todo> todoList = new ArrayList<>();
    public TodoListRepository(){
        todoList.add(new Todo(1,"Reading","hello world",false, LocalDate.now()));
        todoList.add(new Todo(2,"Doing Homework","hello world",false, LocalDate.now()));
        todoList.add(new Todo(3,"Coding","hello world",false, LocalDate.now()));
        todoList.add(new Todo(4,"Research","hello world",false, LocalDate.now()));
    }

    @Override
    public List<Todo> getTodoList() {
        return todoList;
    }

    @Override
    public Todo create(Todo todo) {
        int id = todoList.size() + 1;
        todo.setId(id);
        todo.setCreatedAt(LocalDate.now());
        todoList.add(todo);
        return todo;
    }

    @Override
    public Todo delete(Integer id) {
        Todo deletedTodo = null;
        Iterator<Todo> iterator = todoList.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId().equals(id)) {
                deletedTodo = todo;
                iterator.remove();
                break;
            }
        }
        return deletedTodo;
    }

    @Override
    public Todo update(Integer id, Todo updatedTodo) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .map(todo -> {
                    int index = todoList.indexOf(todo);
                    updatedTodo.setId(id);
                    updatedTodo.setCreatedAt(LocalDate.now());
                    todoList.set(index, updatedTodo);
                    return updatedTodo;
                })
                .orElse(null);
    }


    @Override
    public List<Todo> searchList(String task) {
        return todoList
                .stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(task))
                .collect(Collectors.toList());
    }

    @Override
    public Todo getById(Integer id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Todo> searchByIsDone(Boolean isDone) {
        return todoList
                .stream()
                .filter(todo -> todo.getIsDone() == isDone)
                .collect(Collectors.toList());
    }
}
