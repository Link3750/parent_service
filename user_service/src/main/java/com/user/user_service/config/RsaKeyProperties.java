package com.user.user_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import com.user.user_service.authentificationUtils.RsaUtils;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author TanYuan
 * @date 2022年07月03日 21:56
 */
@Data
@ConfigurationProperties("rsa.key")     //指定配置文件的key
public class RsaKeyProperties {

    private String pubKeyPath;

    private String priKeyPath;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void createKey() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }
}

