package com.todolist_test2.demo.component;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserContext {

    private static final ThreadLocal<Integer> userIdThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> usernameThreadLocal = new ThreadLocal<>();

    public Integer getUserId() {
        return userIdThreadLocal.get();
    }

    public String getUsername() {
        return usernameThreadLocal.get();
    }

    public void setUserId(Integer userId) {
        userIdThreadLocal.set(userId);
    }

    public void setUsername(String username) {
        usernameThreadLocal.set(username);
    }

    public void remove() {
        userIdThreadLocal.remove();
        usernameThreadLocal.remove();
    }
}
