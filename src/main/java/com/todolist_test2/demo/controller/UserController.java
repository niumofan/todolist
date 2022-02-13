package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.user.ImageDTO;
import com.todolist_test2.demo.dto.user.UserLoginDTO;
import com.todolist_test2.demo.dto.user.UserRegisterDTO;
import com.todolist_test2.demo.enums.ResultCode;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.service.TokenService;
import com.todolist_test2.demo.service.UserService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmf
 * @date 2021年11月02日 18:12
 */
@Api(tags = {"用户"}, description = "用户相关接口")
@RestController
public class UserController {

    private UserService userService;

    private TokenService tokenService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @PostMapping("/register")
    public JsonResult<String> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        System.out.println(userRegisterDTO);
        int i = userService.registerUser(userRegisterDTO);
        if (i == 1) {
            return new JsonResult<>(true, "创建成功");
        } else {
            return new JsonResult<>(true, "创建失败");
        }
    }

    @PostMapping("/login")
    public JsonResult<Object> login(@RequestBody UserLoginDTO userDTO) {

        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 执行认证登陆
        subject.login(token);
        if (subject.isAuthenticated()) {
            User user = (User) subject.getPrincipal();
            String[] jwtTokenPair = tokenService.generateTokenPair(user);
            Map<String, String> res = new HashMap<>();
            res.put("accessToken", jwtTokenPair[0]);
            res.put("refreshToken", jwtTokenPair[1]);
            return ResultTool.success(res);
        } else {
            return ResultTool.fail(ResultCode.AUTHENTICATION_ERROR);
        }
    }

    @PostMapping("/user/getUser")
    public JsonResult<User> getUser() {
        User user = userService.getUser();
        return ResultTool.success(user);
    }

    @PostMapping("/user/uploadImage")
    public JsonResult<String> uploadImage(@RequestBody ImageDTO imageDTO) {
        String s = userService.uploadImage(imageDTO);
        if (s != null) {
            return ResultTool.fail(s);
        } else {
            return ResultTool.success("OK");
        }
    }
}
