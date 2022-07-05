package com.com.entity.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
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
    @TableField
    private Date createDate;

    /**
     * 更新日期
     */
    @TableField
    private Date updateDate;

    /**
     * 创建人
     */
    @TableField
    private String createBy;

    /**
     * 更新人
     */
    @TableField
    private String updateBy;

    /**
     * 状态：0：正常；1：删除
     */
    @TableLogic
    @TableField
    private Integer status;

    /**
     * 乐观锁
     */
    @Version
    @TableField
    private Integer version;
}
