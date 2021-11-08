package com.todolist_test2.demo.entity;

import com.todolist_test2.demo.mbg.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author nmf
 * @date 2021年11月02日 10:48
 */
public class SecurityUser implements UserDetails {

    private User user;

    private Collection<? extends GrantedAuthority> authorities;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountNonExpired() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNonLocked() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsNonExpired() == 1;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled() == 1;
    }
}
