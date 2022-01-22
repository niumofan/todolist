package com.todolist_test2.demo.dto.todo;

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
 * @date 2022年01月20日 17:18
 */
@Data
public class ModifyTodoDTO {

    @NotNull
    private Integer id;

    @NotNull
    private Integer userId;

    private Integer categoryId;

    private String categoryName;

    @NotBlank
    private String description;

    @Range(min=1, max=3)
    private Integer priority;

//    @Future
//    private Date startTime;

    @Future
    private Date alarmTime;

    private String subtodos;

    @NotNull
    private Integer repeat;
}
