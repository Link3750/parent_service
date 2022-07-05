package com.user.user_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.com.entity.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author 短途游
 */
public interface UserService extends UserDetailsService, IService<User> {
}
