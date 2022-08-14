package com.user.user_service.config;

import com.user.user_service.filter.JwtLoginFilter;
import com.user.user_service.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Robod
 * @date 2020/8/9 15:47
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final RsaKeyProperties rsaKeyProperties;

    public WebSecurityConfig(UserService userService, RsaKeyProperties rsaKeyProperties) {
        this.userService = userService;
        this.rsaKeyProperties = rsaKeyProperties;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证用户的来源
     *
     * @param auth 认证
     * @throws Exception 异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //数据库中
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    /**
     * 配置SpringSecurity相关信息
     *
     * @param http http请求
     * @throws Exception 异常
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  //关闭csrf
                .addFilter(new JwtLoginFilter(super.authenticationManager(),rsaKeyProperties))
                //禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
