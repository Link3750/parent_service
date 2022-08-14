package com.user.user_service.controller;

import com.com.entity.common.WebResponse;
import com.com.entity.enums.WebResponseEnum;

/**
 * @author TanYuan
 * @date 2022年07月03日 18:01
 */
public class BaseController {
    public BaseController() {
    }

    @SuppressWarnings("unchecked")
    public <T> WebResponse<T> buildSuccessResponse(T o) {
        return (WebResponse<T>) WebResponse.builder()
                .result(o).message(WebResponseEnum.SUCCESS.getDesc())
                .statusCode(WebResponseEnum.SUCCESS.getCode()).build();
    }

    public <T> WebResponse<T> buildSuccessResponse() {
        return buildSuccessResponse(null);
    }

    @SuppressWarnings("unchecked")
    public <T> WebResponse<T> buildErrorResponse(String message, String statusCode) {
        return (WebResponse<T>) WebResponse.builder().message(message).statusCode(statusCode).build();
    }
}
