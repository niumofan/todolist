package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.mbg.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 11:09
 */
@Mapper
public interface UserDao {

    List<Permission> selectPermissionsByUserId(Integer userId);
}
