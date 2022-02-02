package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.UserLoginDTO;
import com.todolist_test2.demo.dto.UserRegisterDTO;
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

/**
 * @author nmf
 * @date 2021年11月02日 18:12
 */
@Api(tags = {"用户"}, description = "用户相关接口(登陆注册接口不一定能用，可以试试)")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public JsonResult<String> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        System.out.println(userRegisterDTO);
//        int i = userService.registerUser(userRegisterDTO);
        int i = 1;
        if (i == 1) {
            return new JsonResult<>(true, "创建成功");
        } else {
            return new JsonResult<>(true, "创建失败");
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO userDTO) {

        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        Boolean rememberMe = userDTO.getRememberMe();

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }

//    @PostMapping("getUser")
//    public JsonResult<Object> getUser() {
//        return ResultTool.success(SecurityContextHolder.getContext().getAuthentication());
//    }
}
