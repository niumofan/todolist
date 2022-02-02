package com.todolist_test2.demo.entity;

import com.todolist_test2.demo.mbg.model.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author nmf
 * @date 2021年11月02日 10:48
 */
public class SecurityUser {

//    private User user;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public SecurityUser() {}
//
//    public SecurityUser(CacheUser cacheUser) {
//        this.user = cacheUser.getUser();
//
//        List<String> authorities = cacheUser.getAuthorities();
//        List<SimpleGrantedAuthority> res = new ArrayList<>(authorities.size());
//
//        for (String auth: authorities) {
//            res.add(new SimpleGrantedAuthority(auth));
//        }
//        this.authorities = res;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return user.getAccountNonExpired() == 1;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return user.getAccountNonLocked() == 1;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return user.getCredentialsNonExpired() == 1;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return user.getEnabled() == 1;
//    }
}
