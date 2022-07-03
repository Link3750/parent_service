package com.com.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author TanYuan
 * @date 2022年07月03日 16:48
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DataEntity {
    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 状态：0：正常；1：删除
     */
    private Integer status;
}
