package com.user.user_service.form;

import com.com.entity.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TanYuan
 * @date 2022年07月03日 18:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {

    private User user;

    private String confirmPassword;
}
