package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.UserMapper;
import com.readyidu.model.User;
import com.readyidu.service.CacheService;
import com.readyidu.service.UserService;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 123 on 2017/8/9.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CacheService cacheService;
    @Override
    public int login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (NullUtil.isNullObject(email)||NullUtil.isNullObject(password))
        {
            return NetworkCode.ERROR_CODE_400;
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User loginInfo = userMapper.selectUserByLoginInfo(user);
        if (NullUtil.isNullObject(loginInfo))
        {
            return NetworkCode.ERROR_CODE_412;
        };
        return NetworkCode.CODE_SUCCESS;
    }
}
