package com.todolist_test2.demo.dto.todo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 17:13
 */
@Data
public class DeleteTodoDTO {

    //    @Size(min = 1)
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer repeat;

}
