package com.user.user_service.controller.userOperation;

import com.com.entity.common.WebResponse;
import com.user.user_service.controller.BaseController;
import com.user.user_service.form.RegisterForm;
import com.user.user_service.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TanYuan
 * @date 2022年07月03日 17:07
 */
@RestController
@RequestMapping("/operation")
public class LoginController extends BaseController {

    @Resource
    private UserServiceImpl userService;

    @PostMapping("/register")
    public WebResponse register(@RequestBody RegisterForm registerForm) {
        if(!registerForm.getUser().getPassword().equals(registerForm.getConfirmPassword())) {
            return buildErrorResponse("两次输入密码不一致", "403");
        }
        return userService.insertUser(registerForm.getUser()) == 1 ? buildSuccessResponse() : buildErrorResponse("注册失败", "500");
    }
}
