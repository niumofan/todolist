package com.todolist_test2.demo.dto.todo;

import lombok.Data;

import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 17:24
 */
@Data
public class QueryTodoDTO {

    private Integer todoId;

    private Integer categoryId;

    private Integer userId;

    private Integer priority;

    private Date startTime;

    private Date endTime;
}
