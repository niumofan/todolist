package com.todolist_test2.demo.dto.todo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 17:24
 */
@ApiModel(value = "查询待办的请求参数")
@Data
public class QueryTodoDTO {

    private Integer id;

    private Integer categoryId;

    private Integer userId;

    private Integer priority;

    private Integer state;

    private Date startTime;

    private Date endTime;
}
