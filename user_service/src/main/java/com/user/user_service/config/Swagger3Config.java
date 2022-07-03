package com.user.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author TanYuan
 * @date 2022年07月03日 18:32
 */
@Configuration
public class Swagger3Config {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder()
                        .contact(new Contact("短途游", "", "Link3750@aliyun.com"))
                        .title("私人博客项目")
                        .build()
        );
    }
}
