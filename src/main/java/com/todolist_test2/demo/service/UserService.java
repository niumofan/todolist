package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dao.UserDao;
import com.todolist_test2.demo.mbg.mapper.UserMapper;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.mbg.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 10:47
 */
@Service
public class UserService {

    private UserMapper userMapper;

    private UserDao userDao;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public User loadUserByUsername(String username) {

        if (username == null || "".equals(username)) {
//            throw new UsernameNotFoundException("异常");
            return null;
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.size() == 0) {
            throw new RuntimeException("用户不存在");
        }

        User user = userList.get(0);
        return user;
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        if (user != null) {
//            List<Permission> permissionList = userDao.selectPermissionsByUserId(user.getId());
//            for (Permission permission: permissionList) {
//                if (permission != null) {
//                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getCode()));
//                }
//            }
//
//            SecurityUser securityUser = new SecurityUser();
//            securityUser.setUser(user);
//            securityUser.setAuthorities(grantedAuthorities);
//            return securityUser;
//        }
//        return null;
    }

//    @Transactional
//    @Override
//    public int registerUser(UserRegisterDTO userRegisterDTO) {
//        String username = userRegisterDTO.getUsername();
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andUsernameEqualTo(username);
//        if (userMapper.selectByExample(userExample).size() > 0) {
//            throw new RuntimeException("用户名已存在");
//        }
//
//        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getRepeatPassword())) {
//            throw new RuntimeException("两次密码不一致");
//        }
//
//        User user = new User();
//        BeanUtils.copyProperties(userRegisterDTO, user);
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        user.setAccountNonExpired((byte) 1);
//        user.setAccountNonLocked((byte) 1);
//        user.setEnabled((byte) 1);
//        user.setCredentialsNonExpired((byte) 1);
//
//        Date curTime = new Date();
//        user.setCreateTime(curTime);
//        user.setUpdateTime(curTime);
//        user.setLastLoginTime(curTime);
//
//        return userMapper.insertSelective(user);
//    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

//    public User getUser()
}
