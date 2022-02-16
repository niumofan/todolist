package com.todolist_test2.demo.dto.user;

import lombok.Data;

@Data
public class UpdateUserDTO {

    private Integer id;

    private String password;

    private String nickname;

    private Character sex;

    private String mobile;

    private String qq;

    private String weixin;

    private String email;

}
