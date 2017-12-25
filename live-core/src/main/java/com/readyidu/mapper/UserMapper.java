package com.readyidu.mapper;

import com.readyidu.model.Source;
import com.readyidu.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by 123 on 2017/8/9.
 */
@Component
public interface UserMapper {
    User selectUserByLoginInfo(User user);
}
