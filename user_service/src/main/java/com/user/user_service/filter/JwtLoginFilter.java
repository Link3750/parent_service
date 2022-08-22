package com.user.user_service.filter;

import com.alibaba.fastjson.JSONObject;
import com.com.entity.entity.Role;
import com.com.entity.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.user_service.authentificationUtils.JwtUtils;
import com.user.user_service.config.RsaKeyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TanYuan
 * @date 2022年07月03日 22:18
 */
@Slf4j
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final RsaKeyProperties rsaKeyProperties;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties rsaKeyProperties) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyProperties = rsaKeyProperties;
    }

    /**
     * 这个方法是用来去尝试验证用户的，父类中是从POST请求的form表单中获取，但是这里不是，所以需要重写
     * @param request http请求
     * @param response http返回
     * @return 认证信息
     * @throws AuthenticationException 认证失败异常
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = JSONObject.parseObject(request.getInputStream(),User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword())
            );
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<>(2);
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("message", "账号或密码错误！");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * 成功之后执行的方法，父类中是放入session，不符合我们的要求，所以重写
     *
     * @param request http请求
     * @param response http返回
     * @param chain 过滤链
     * @param authResult 认证结果
     */
    @Override
    @SuppressWarnings("unchecked")
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        User user = new User();
        user.setUsername(authResult.getName());
        user.setRoles((List<Role>) authResult.getAuthorities());
        String token = JwtUtils.generateTokenExpireInMinutes(user,rsaKeyProperties.getPrivateKey(),24*60);
        response.addHeader("Authorization", "RobodToken " + token);
        try {
            //登录成功时，返回json格式进行提示
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new HashMap<>(4);
            map.put("code", HttpServletResponse.SC_OK);
            map.put("message", "登陆成功！");
            out.write(new ObjectMapper().writeValueAsString(map));
            out.flush();
            out.close();
        } catch (Exception e) {
            log.error("登录失败", e);
        }
    }
}

