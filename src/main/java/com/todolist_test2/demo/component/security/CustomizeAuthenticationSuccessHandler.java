package com.todolist_test2.demo.component.security;

import com.alibaba.fastjson.JSON;
import com.todolist_test2.demo.entity.AccessToken;
import com.todolist_test2.demo.entity.CacheUser;
import com.todolist_test2.demo.entity.SecurityUser;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.service.UserService;
import com.todolist_test2.demo.service.impl.UserServiceImpl;
import com.todolist_test2.demo.utils.JwtUtil;
import com.todolist_test2.demo.utils.RedisService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author nmf
 * @date 2021年11月03日 23:39
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = securityUser.getUser();

        Date curTime = new Date();
        user.setLastLoginTime(curTime);
        user.setUpdateTime(curTime);
        userService.updateUser(user);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

//        user.setPassword(null);

        redisService.set("user::" + user.getUsername(), new CacheUser(securityUser));

        AccessToken accessToken = jwtUtil.createToken(securityUser);

        //返回json数据
        JsonResult<Object> result = ResultTool.success(accessToken);
        user.setPassword(null);
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
