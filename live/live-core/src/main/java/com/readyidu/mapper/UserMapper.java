package com.readyidu.mapper;

import com.readyidu.model.User;

/**
 * Created by 123 on 2017/8/9.
 */
public interface UserMapper {
    User selectUserByLoginInfo(User user);
}
