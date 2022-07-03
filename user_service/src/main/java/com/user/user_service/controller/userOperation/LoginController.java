package com.user.user_service.controller.userOperation;

import com.com.entity.common.WebResponse;
import com.user.user_service.controller.BaseController;
import com.user.user_service.form.RegisterForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TanYuan
 * @date 2022年07月03日 17:07
 */
@RestController
@RequestMapping("/operation")
public class LoginController extends BaseController {

    @PostMapping("/register")
    public WebResponse register(@RequestBody RegisterForm registerForm) {
        return null;
    }
}
