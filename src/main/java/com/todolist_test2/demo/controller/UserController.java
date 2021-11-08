package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.UserRegisterDTO;
import com.todolist_test2.demo.entity.SecurityUser;
import com.todolist_test2.demo.service.UserService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nmf
 * @date 2021年11月02日 18:12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonResult<String> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        int i = userService.registerUser(userRegisterDTO);
        if (i == 1) {
            return new JsonResult<>(true, "创建成功");
        } else {
            return new JsonResult<>(true, "创建失败");
        }
    }

    @PostMapping("getUser")
    public JsonResult<String> getUser() {
        return ResultTool.success( "aaabbbccc");
    }
}
