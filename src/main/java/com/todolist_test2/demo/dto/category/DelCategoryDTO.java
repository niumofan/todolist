package com.todolist_test2.demo.dto.category;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 16:12
 */
@Data
public class DelCategoryDTO {

    @NotNull
    private Integer userId;

    @Size(min = 1)
    private List<Integer> categoryIds;
}
