package com.todolist_test2.demo.service.impl;

import com.todolist_test2.demo.dao.UserDao;
import com.todolist_test2.demo.entity.SecurityUser;
import com.todolist_test2.demo.mbg.mapper.PermissionMapper;
import com.todolist_test2.demo.mbg.mapper.UserMapper;
import com.todolist_test2.demo.mbg.model.Permission;
import com.todolist_test2.demo.mbg.model.PermissionExample;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.mbg.model.UserExample;
import com.todolist_test2.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 10:47
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {

        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.size() == 0) {
            throw new RuntimeException("用户不存在");
        }

        User user = userList.get(0);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user != null) {
            List<Permission> permissionList = userDao.selectPermissionsByUserId(user.getId());
            for (Permission permission: permissionList) {
                grantedAuthorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }

            SecurityUser securityUser = new SecurityUser();
            BeanUtils.copyProperties(user, securityUser);
            securityUser.setAuthorities(grantedAuthorities);
            return securityUser;
        }
        return null;
    }
}
