package co.istad.todolist.service;

import co.istad.todolist.model.Todo;
import co.istad.todolist.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService{
    private final TodoListRepository todoListRepository;
    TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }
    
    @Override
    public List<Todo> getAll() {
        return todoListRepository.getTodoList();
    }

    @Override
    public Todo create(Todo todo) {
        return todoListRepository.create(todo);
    }

    @Override
    public Todo delete(Integer id) {
        return todoListRepository.delete(id);
    }

    @Override
    public Todo update(Todo todo) {
        return todoListRepository.update(todo.getId(), todo);
    }

    @Override
    public List<Todo> searchList(String task) {
        return todoListRepository.searchList(task);
    }

    public Todo getById(Integer id) {
        return todoListRepository.getById(id);
    }

    @Override
    public List<Todo> searchByIsDone(Boolean isDone) {
        return todoListRepository.searchByIsDone(isDone);
    }
}
