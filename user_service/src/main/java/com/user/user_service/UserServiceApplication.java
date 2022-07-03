package com.user.user_service;

import com.user.user_service.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 短途游
 */
@SpringBootApplication
@EnableOpenApi
@EnableConfigurationProperties(RsaKeyProperties.class)
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
