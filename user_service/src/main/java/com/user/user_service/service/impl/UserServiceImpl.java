package com.user.user_service.service.impl;

import com.user.user_service.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author TanYuan
 * @date 2022年07月03日 22:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
