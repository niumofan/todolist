package com.todolist_test2.demo.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 16:12
 */
@ApiModel(value = "删除分类的请求参数")
@Data
public class DelCategoryDTO {

    @ApiModelProperty(value = "用户ID", required = true, example = "123456")
    @NotNull(message = "userId[{user.id.notnull}]")
    private Integer userId;


    @ApiModelProperty(value = "分类ID列表", required = true, example = "[1,2,3]")
    @Size(min = 1, message = "categoryIds[{category.ids.size}]")
    private List<Integer> categoryIds;
}
