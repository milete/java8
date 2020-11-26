package com.jc.demo.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * description：订单项
 *
 * @author milete
 * @date 2020/11/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderItem extends BasePo {

    /**
     * 制作时间
     */
    private Timestamp productionTime;

    /**
     * 售价
     */
    private BigDecimal salePrice;
}
