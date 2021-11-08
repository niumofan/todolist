package com.todolist_test2.demo.service.impl;

import com.todolist_test2.demo.dao.PermissionDao;
import com.todolist_test2.demo.mbg.mapper.PermissionMapper;
import com.todolist_test2.demo.mbg.model.Permission;
import com.todolist_test2.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 11:02
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selectRequiredPermissionsByRequestPath(String requestPath) {
        return permissionDao.selectPermissionsByRequestPath(requestPath);
    }
}
