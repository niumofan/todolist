package com.todolist_test2.demo.aop;

import com.todolist_test2.demo.component.UserContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RemoveUserContextAop {

    private UserContext userContext;

    @Autowired
    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    @Pointcut("execution(public * com.todolist_test2.demo.controller.*.*(..))")
    public void remove() {}

    @After("remove()")
    public void after() {
        System.out.println(userContext.getUserId());
        System.out.println(userContext.getUsername());
        userContext.remove();
    }
}
