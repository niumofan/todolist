package com.todolist_test2.demo.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "上传用户头像参数")
@Data
public class ImageDTO {

    @ApiModelProperty(value = "用户ID", example = "2", position = 1)
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "base64编码后的图像", required = true, position = 1)
    @NotBlank
    private String base64Image;

}
