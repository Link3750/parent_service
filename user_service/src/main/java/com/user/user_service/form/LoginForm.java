package com.user.user_service.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TanYuan
 * @date 2022年08月14日 15:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {

    private String userName;

    private String password;
}
