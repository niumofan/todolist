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
public class SecurityUser extends User implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return getAccountNonExpired() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return getAccountNonLocked() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return getCredentialsNonExpired() == 1;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled() == 1;
    }
}
