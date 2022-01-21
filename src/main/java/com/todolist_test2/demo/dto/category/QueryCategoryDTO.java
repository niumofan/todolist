package com.todolist_test2.demo.dto.category;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author nmf
 * @date 2022年01月22日 1:42
 */
@Data
public class QueryCategoryDTO {

    @NotNull
    private Integer userId;
}
