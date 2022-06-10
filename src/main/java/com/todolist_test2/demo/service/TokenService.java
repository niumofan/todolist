package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dao.UserDao;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.utils.JwtUtils;
import com.todolist_test2.demo.utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TokenService {

    private static final String REDIS_PREFIX = "token:";

    private static final String INVALID_TOKEN = "token:invalid";

    private static final long ACCESS_EXPIRE_TIME = 1440 * 60 * 1000;

    private static final long REFRESH_EXPIRE_TIME = 2880 * 60 * 1000;

    private UserDao userDao;

    private RedisService redisService;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * @return String[2]{accessToken, refreshToken}
     */
    public String[] generateTokenPair(User user) {

        /* 生成accessToken */
        long time = System.currentTimeMillis();
        String accessToken = generateAccessToken(user);
        System.out.println("accessToken: " + (System.currentTimeMillis() - time));

        /* 生成refreshToken */
        time = System.currentTimeMillis();
        String refreshToken = generateRefreshToken(user);
        System.out.println("accessToken: " + (System.currentTimeMillis() - time));

        /* 保存到redis */
        redisService.set(REDIS_PREFIX + refreshToken, accessToken, REFRESH_EXPIRE_TIME / 1000);

        return new String[]{accessToken, refreshToken};
    }

    /**
     * 刷新token，返回新的accessToken和refreshToken
     * @param oldRefreshToken 以前的refreshToken
     * @return String[]->新的{accessToken,refreshToken}; null->refreshToken过期
     */
    public String[] refreshToken(String oldRefreshToken) {

        if (!JwtUtils.verify(oldRefreshToken)) {
            return null;
        }

        final String oldKey = REDIS_PREFIX + oldRefreshToken;

        /* 原来的refreshToken在黑名单中 */
        if (isTokenInvalid(oldRefreshToken)) {
            return null;
        }

        /* refreshToken也过期了，重新登录 */
        if (!redisService.hasKey(oldKey)) {
            return null;
        }

        /* 重新生成accessToken */
        User user = JwtUtils.getUserFromToken(oldRefreshToken);
        String newAccessToken = generateAccessToken(user);
        String newRefreshToken = generateRefreshToken(user);

        /* 原来的accessToken和refreshToken放入黑名单 */
        String oldAccessToken = (String) redisService.get(oldKey);
        if (oldAccessToken != null) {
            redisService.sAdd(INVALID_TOKEN, oldAccessToken);
        }
        redisService.sAdd(INVALID_TOKEN, oldRefreshToken);

        /* 删除oldRefreshKey */
        redisService.del(oldKey);

        /* 设置新的accessToken */
        redisService.set(REDIS_PREFIX + newRefreshToken, newAccessToken);
        return new String[]{newAccessToken, newRefreshToken};
    }

    private String generateAccessToken(User user) {
        Map<String, String> map = new HashMap<>();
        List<String> roles = userDao.selectRolesOfUser(user.getId());
        String rolesStr = String.join(" ", roles);
        map.put("userId", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("auth", rolesStr);
        return JwtUtils.sign(map, ACCESS_EXPIRE_TIME);
    }

    private String generateRefreshToken(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("userId", user.getId().toString());
        map.put("username", user.getUsername());
        return JwtUtils.sign(map, REFRESH_EXPIRE_TIME);
    }

    public boolean isTokenInvalid(String token) {
        return redisService.sIsMember(INVALID_TOKEN, token);
    }
}
