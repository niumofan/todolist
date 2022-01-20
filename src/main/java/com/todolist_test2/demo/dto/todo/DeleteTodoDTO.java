package com.todolist_test2.demo.dto.todo;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 17:13
 */
@Data
public class DeleteTodoDTO {

    @Size(min = 1)
    private List<Integer> todoIds;
}
