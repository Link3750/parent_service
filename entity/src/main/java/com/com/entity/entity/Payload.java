package com.com.entity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author TanYuan
 * @date 2022年07月03日 21:42
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
