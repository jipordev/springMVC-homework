package co.istad.todolist.repository;

import co.istad.todolist.model.Todo;

import java.util.List;

public interface TodoRepo {
    List<Todo> getTodoList();
    Todo create(Todo todo);
    List<Todo> delete(List<Todo> todos, Integer id);
    Todo update(List<Todo> todoList);
    List<Todo> searchList(String task);
    Todo getById(Integer id);
}
