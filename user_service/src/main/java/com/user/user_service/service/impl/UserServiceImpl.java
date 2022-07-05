package com.user.user_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.com.entity.entity.User;
import com.user.user_service.mapper.UserMapper;
import com.user.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author TanYuan
 * @date 2022年07月03日 22:13
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public int insertUser(User user) {
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
        int insert = this.baseMapper.insert(user);
        log.info(String.valueOf(insert));
        return insert;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
