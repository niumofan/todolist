package com.todolist_test2.demo.component.security;

import cn.hutool.core.util.StrUtil;
import com.todolist_test2.demo.entity.CacheUser;
import com.todolist_test2.demo.entity.SecurityUser;
import com.todolist_test2.demo.utils.JwtUtil;
import com.todolist_test2.demo.utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 拿到Authorization请求头内的信息
        String authToken = jwtUtil.getToken(request);

        // 判断一下内容是否为空
        if (StrUtil.isNotEmpty(authToken) && authToken.startsWith(jwtUtil.getTokenPrefix())) {
            // 去掉token前缀(Bearer )，拿到真实token
            authToken = authToken.substring(jwtUtil.getTokenPrefix().length());

            // 拿到token里面的登录账号
            String loginAccount = jwtUtil.getSubjectFromToken(authToken);

            if (StrUtil.isNotEmpty(loginAccount) && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 查询用户
                CacheUser cacheUser = (CacheUser) redisService.get("user::" + loginAccount);
                if (cacheUser != null) {
                    SecurityUser userDetails = new SecurityUser(cacheUser);
                    // 拿到用户信息后验证用户信息与token
                    if (userDetails != null && jwtUtil.validateToken(authToken, userDetails)) {

                        // 组装authentication对象，构造参数是Principal Credentials 与 Authorities
                        // 后面的拦截器里面会用到 grantedAuthorities 方法
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

                        // 将authentication信息放入到上下文对象中
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        System.out.println("JWT过滤器通过校验请求头token自动登录成功, user : {}" + userDetails.getUsername());
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
