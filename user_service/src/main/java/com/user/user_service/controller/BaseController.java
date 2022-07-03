package com.user.user_service.controller;

import com.com.entity.common.WebResponse;

/**
 * @author TanYuan
 * @date 2022年07月03日 18:01
 */
public class BaseController {
    public BaseController() {
    }

    public WebResponse buildSuccessResponse(Object o) {
        return WebResponse.builder().result(o).message("成功").statusCode("200").build();
    }

    public WebResponse buildSuccessResponse() {
        return buildSuccessResponse(null);
    }

    public WebResponse buildErrorResponse(String message, String statusCode) {
        return WebResponse.builder().message(message).statusCode(statusCode).build();
    }
}
