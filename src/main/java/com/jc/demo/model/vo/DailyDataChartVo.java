package com.jc.demo.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * description：每日消费数据折线图vo
 *
 * @author milete
 * @date 2020/11/26
 */
@Data
@AllArgsConstructor
public class DailyDataChartVo {

    /**
     * 日期
     */
    private LocalDate date;

    /**
     * 今日营收
     */
    private BigDecimal revenue;
}
