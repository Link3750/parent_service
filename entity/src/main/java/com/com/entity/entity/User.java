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
 * @date 2022年07月03日 16:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends DataEntity implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String userName;
}
