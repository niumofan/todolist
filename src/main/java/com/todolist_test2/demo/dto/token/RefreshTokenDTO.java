package com.todolist_test2.demo.dto.token;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "刷新Token的请求参数")
@Data
public class RefreshTokenDTO {

    @ApiModelProperty(value = "refreshToken(用户登录得到)", required = true, example = "123456", position = 1)
    @NotBlank(message = "refreshToken[{token.refreshToken.notblank}]")
    private String refreshToken;
}
