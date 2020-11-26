package com.jc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.demo.model.po.OrderItem;
import com.jc.demo.model.vo.DailyDataChartVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * description：每日消费数据
 *
 * @author milete
 * @date 2020/11/26
 */
public interface DailyDataMapper extends BaseMapper<OrderItem> {

    /**
     * 折线图数据
     *
     * @param preDate 开始日期，不传默认近一周
     * @param endDate 截止日期
     * @return
     */
    List<DailyDataChartVo> selectChartData(@Param("preDate") LocalDate preDate,
                                           @Param("endDate") LocalDate endDate);
}
