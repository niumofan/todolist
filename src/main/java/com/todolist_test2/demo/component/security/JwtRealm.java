package com.todolist_test2.demo.component.security;

import com.todolist_test2.demo.entity.JwtToken;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.service.TokenService;
import com.todolist_test2.demo.service.UserService;
import com.todolist_test2.demo.utils.JwtUtils;
import com.todolist_test2.demo.utils.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/* xxxRealm获取用户数据，得到了就是认证成功 */
public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 此处的 SimpleAuthenticationInfo 可返回任意值，密码校验时不会用到它
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authcToken;
        String accessToken = jwtToken.getToken();
        if (jwtToken.getPrincipal() == null) {
            throw new AccountException("JWT token参数异常！");
        }

        if (tokenService.isTokenInvalid(accessToken)) {
            throw new AccountException("JWT token无效");
        }

        // 从 JwtToken 中获取当前用户
        String username = jwtToken.getPrincipal().toString();

        // 查询数据库获取用户信息
        User user = JwtUtils.getUserFromToken(jwtToken.getToken());

        return new SimpleAuthenticationInfo(user, username, getName());
//        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取当前用户
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();

        // 查询数据库，获取用户的权限信息
        Set<String> roles = userService.getRolesOfUser(currentUser);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        return info;
    }
}
