package com.todolist_test2.demo.dto.category;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author nmf
 * @date 2022年01月20日 16:18
 */
@Data
public class ModifyCategoryDTO {

    @NotNull
    private Integer categoryId;

    @NotBlank
    private String name;
}
