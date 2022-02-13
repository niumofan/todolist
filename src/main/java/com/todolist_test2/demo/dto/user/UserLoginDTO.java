package com.todolist_test2.demo.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "登录参数")
public class UserLoginDTO {

    @ApiModelProperty(value = "用户名", required = true, example = "user1", position = 1)
    @NotNull(message = "username[{user.username.notnull}]")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "user1", position = 1)
    @NotNull(message = "password[{user.password.notnull}]")
    private String password;
}
