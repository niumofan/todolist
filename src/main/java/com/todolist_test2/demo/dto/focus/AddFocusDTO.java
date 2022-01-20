package com.todolist_test2.demo.dto.focus;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 23:16
 */
@Data
public class AddFocusDTO {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer todoId;

    @Past
    private Date startTime;

    @Past
    private Date endTime;
}
