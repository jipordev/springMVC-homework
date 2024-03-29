package co.istad.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
    private Integer id;
    private String task;
    private String description;
    private Boolean isDone;
    private LocalDate createdAt;
}
