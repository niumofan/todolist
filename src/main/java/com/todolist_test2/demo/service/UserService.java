package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dto.UserRegisterDTO;
import com.todolist_test2.demo.mbg.model.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author nmf
 * @date 2021年11月02日 10:46
 */
public interface UserService {
    int registerUser(UserRegisterDTO userRegisterDTO);
//    UserDetails loadUserByUsername(String username);

    int updateUser(User user);
}
