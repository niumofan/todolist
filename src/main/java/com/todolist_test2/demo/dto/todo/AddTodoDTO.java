package com.todolist_test2.demo.dto.todo;

import com.todolist_test2.demo.enums.TodoState;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 16:33
 */
@Data
public class AddTodoDTO {

    @NotNull
    private Integer userId;

    private Integer categoryId;

    private String categoryName;

    @NotBlank
    private String description;

    @Range(min=1, max=3)
    private Byte priority;

    @Future
    private Date startTime;

    @Future
    private Date endTime;

    private Date alarmTime;

    private String subtodos;

    @Min(1)
    private Byte repeat;
}
