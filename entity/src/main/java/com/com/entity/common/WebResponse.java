package com.com.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author TanYuan
 * @date 2022年07月03日 17:26
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WebResponse implements Serializable {
    private static final long SERIAL_VERSION_ID = 143243246534L;
    private String statusCode;
    private String message;
    private Object result;
}
