package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.token.RefreshTokenDTO;
import com.todolist_test2.demo.enums.ResultCode;
import com.todolist_test2.demo.service.TokenService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "token", description = "token相关接口(刷新)")
@RestController
@RequestMapping("/token")
public class TokenController {

    private TokenService tokenService;

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @ApiOperation(value = "根据refreshToken刷新token，获得新的accessToken和refreshToken",
            notes = "前端检测到accessToken失效或者快失效时再调用此接口")
    @PostMapping("refresh")
    public JsonResult<Object> refreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {
        String refreshToken = refreshTokenDTO.getRefreshToken();
        String[] tokenPair = tokenService.refreshToken(refreshToken);
        if (tokenPair == null) {
            return ResultTool.fail(ResultCode.REFRESH_TOKEN_INVALID);
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", tokenPair[0]);
        map.put("refreshToken", tokenPair[1]);
        return ResultTool.success(map);
    }

}
