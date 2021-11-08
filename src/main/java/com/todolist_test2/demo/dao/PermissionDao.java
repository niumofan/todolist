package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.mbg.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月04日 11:30
 */
@Mapper
public interface PermissionDao {


    List<Permission> selectPermissionsByRequestPath(String requestPath);
}
