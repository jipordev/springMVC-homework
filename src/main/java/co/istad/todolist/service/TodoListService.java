package co.istad.todolist.service;

import co.istad.todolist.model.Todo;

import java.util.List;

public interface TodoListService {
    List<Todo> getAll();
    Todo create(Todo todo);
    Todo delete(Integer id);
    Todo update(Todo todo);
    List<Todo> searchList(String task);
    Todo getById(Integer id);
    List<Todo> searchByIsDone(Boolean isDone);
}
