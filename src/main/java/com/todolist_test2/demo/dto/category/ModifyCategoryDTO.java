package com.todolist_test2.demo.dto.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nmf
 * @date 2022年01月20日 16:18
 */
@Data
public class ModifyCategoryDTO {

    @NotNull
    private Integer id;

    @NotNull
    private Integer userId;

    @NotBlank
    private String name;

    public ModifyCategoryDTO(){}
}
