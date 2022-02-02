package com.todolist_test2.demo.dto;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String username;
    private String password;
    private Boolean rememberMe;
}
