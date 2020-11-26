package com.jc.demo.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

/**
 * description：po基类
 *
 * @author milete
 * @date 2020/11/26
 */
@Data
public abstract class BasePo {

    @TableId(type = IdType.ASSIGN_UUID)
    protected String id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected Timestamp createdDate = new Timestamp(System.currentTimeMillis());
}
