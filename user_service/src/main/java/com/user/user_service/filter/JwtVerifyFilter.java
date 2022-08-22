package com.user.user_service.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.user_service.authentificationUtils.JwtUtils;
import com.user.user_service.config.RsaKeyProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TanYuan
 * @date 2022年08月22日 22:46
 */
public class JwtVerifyFilter extends BasicAuthenticationFilter {


    private final RsaKeyProperties rsaKeyProperties;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyProperties rsaKeyProperties) {
        super(authenticationManager);
        this.rsaKeyProperties = rsaKeyProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException, IOException {
        String header = request.getHeader("Authorization");
        //没有登录
        if (header == null || !header.startsWith("RobodToken ")) {
            chain.doFilter(request, response);
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new HashMap<String, Object>(4);
            map.put("code", HttpServletResponse.SC_FORBIDDEN);
            map.put("message", "请登录！");
            out.write(new ObjectMapper().writeValueAsString(map));
            out.flush();
            out.close();
            return;
        }
        //登录之后从token中获取用户信息
        String token = header.replace("RobodToken ","");
        User user = JwtUtils.getInfoFromToken(token, rsaKeyProperties.getPublicKey(), User.class).getUserInfo();
        if (user != null) {
            Authentication authResult = new UsernamePasswordAuthenticationToken
                    (user.getUsername(),null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authResult);
            chain.doFilter(request, response);
        }
    }
}

