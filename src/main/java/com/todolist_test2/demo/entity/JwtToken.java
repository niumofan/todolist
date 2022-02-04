package com.todolist_test2.demo.entity;

import com.todolist_test2.demo.utils.JwtUtils;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
public class JwtToken implements AuthenticationToken {
    // 加密后的 JWT token串
    private final String token;

    private final String userName;

    private final Set<String> permissions;

    public JwtToken(String token) {
        this.token = token;
        this.userName = JwtUtils.getClaimFiled(token, "username");

        String perms = JwtUtils.getClaimFiled(token, "auth");

        this.permissions = new HashSet<>();
        if (perms != null && perms.length() != 0) {
            this.permissions.addAll(Arrays.asList(perms.split(" ")));
        }
    }

    @Override
    public Object getPrincipal() {
        return this.userName;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }
}
