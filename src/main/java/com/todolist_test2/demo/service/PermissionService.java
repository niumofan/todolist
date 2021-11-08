package com.todolist_test2.demo.service;

import com.todolist_test2.demo.mbg.model.Permission;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 11:00
 */
public interface PermissionService {

   List<Permission> selectRequiredPermissionsByRequestPath(String requestPath);
}
