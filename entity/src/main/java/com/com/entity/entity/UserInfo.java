package com.com.entity.entity;

import com.com.entity.common.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author TanYuan
 * @date 2022年07月03日 17:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends DataEntity implements Serializable {

    /**
     * 用户信息id
     */
    private String userInfoId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 描述
     */
    private String description;

    /**
     * 自我签名
     */
    private String signature;

    /**
     * 性别：0：男；1：女
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;
}
