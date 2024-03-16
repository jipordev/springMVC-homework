package co.istad.todolist.repository;

import co.istad.todolist.model.Todo;

import java.util.List;

public interface TodoRepo {
    List<Todo> getTodoList();
    Todo create(Todo todo);
    Todo delete(Integer id);
    Todo update(Integer id, Todo updateTodo);
    List<Todo> searchList(String task);
    Todo getById(Integer id);
    List<Todo> searchByIsDone(Boolean isDone);
}
