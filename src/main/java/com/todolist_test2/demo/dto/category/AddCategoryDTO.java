package com.todolist_test2.demo.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author nmf
 * @date 2022年01月20日 15:57
 */
@ApiModel(value = "添加分类的请求参数", description = "即使分类名相同，只要是不同用户创建的，那也是不同的分类")
@Data
public class AddCategoryDTO {

    @ApiModelProperty(value = "用户ID", required = true, example = "123456")
    @NotNull(message = "userId[{user.id.notnull}]")
    private Integer userId;

    @ApiModelProperty(value = "分类名", required = true, example = "健身", position = 1)
    @NotBlank(message = "name[{category.name.notblank}]")
    @Size(max = 10, message = "name[{category.name.size}]")
    private String name;
}
