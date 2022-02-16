package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.dto.user.UserInfo;
import com.todolist_test2.demo.mbg.model.Permission;
import com.todolist_test2.demo.mbg.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 11:09
 */
@Mapper
public interface UserDao {

    List<String> selectRolesOfUser(Integer userId);

    UserInfo loadUserByUsername(String username);

    UserInfo loadUserById(Integer userId);

    String getImagePath(Integer userId);
}
