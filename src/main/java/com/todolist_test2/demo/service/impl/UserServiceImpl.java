package com.todolist_test2.demo.service.impl;

import com.todolist_test2.demo.dao.UserDao;
import com.todolist_test2.demo.dto.UserRegisterDTO;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
                if (permission != null) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getCode()));
                }
            }

            SecurityUser securityUser = new SecurityUser();
            securityUser.setUser(user);
            securityUser.setAuthorities(grantedAuthorities);
            return securityUser;
        }
        return null;
    }

    @Transactional
    @Override
    public int registerUser(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.selectByExample(userExample).size() > 0) {
            throw new RuntimeException("用户名已存在");
        }

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getRepeatPassword())) {
            throw new RuntimeException("两次密码不一致");
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setAccountNonExpired((byte) 1);
        user.setAccountNonLocked((byte) 1);
        user.setEnabled((byte) 1);
        user.setCredentialsNonExpired((byte) 1);

        Date curTime = new Date();
        user.setCreateTime(curTime);
        user.setUpdateTime(curTime);
        user.setLastLoginTime(curTime);

        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
