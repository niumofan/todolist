package com.todolist_test2.demo.dto.focus;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 23:18
 */
@Data
public class QueryFocusDTO {

    @NotNull
    private Integer userId;

    private Date startTime;

    private Date endTime;
}
