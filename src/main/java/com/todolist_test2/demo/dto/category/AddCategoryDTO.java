package com.todolist_test2.demo.dto.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nmf
 * @date 2022年01月20日 15:57
 */
@Data
public class AddCategoryDTO {

    @NotNull
    private Integer userId;

    @NotBlank
    private String name;
}
