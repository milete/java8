package com.jc.demo.service;

import com.jc.demo.mapper.DailyDataMapper;
import com.jc.demo.model.vo.DailyDataChartVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description：每日消费数据
 *
 * @author milete
 * @date 2020/11/26
 */
@Service
public class DailyDataService {

    @Resource
    private DailyDataMapper dailyDataMapper;

    /**
     * 折线图数据
     *
     * @param preDate 开始日期，不传默认近一周
     * @return
     */
    public List<DailyDataChartVo> getChartData(LocalDate preDate) {
        if (Objects.isNull(preDate)) {
            preDate = LocalDate.now().minusWeeks(1);
        }
        LocalDate endDate = LocalDate.now();
        List<DailyDataChartVo> list = this.dailyDataMapper.selectChartData(preDate, endDate);
        return this.completeData(preDate, endDate, list);
    }

    /**
     * 补全数据
     *
     * @param preDate 开始日期
     * @param endDate 截止日期
     * @param oldList 未补全的列表
     * @return 补全后的列表
     */
    private List<DailyDataChartVo> completeData(LocalDate preDate, LocalDate endDate, List<DailyDataChartVo> oldList) {
        List<DailyDataChartVo> newList = new ArrayList<>();
        if (CollectionUtils.isEmpty(oldList)) {
            return newList;
        }
        //间隔的日期列表
        List<LocalDate> dates = this.getRangeDays(preDate, endDate);
        Map<LocalDate, DailyDataChartVo> map = oldList.stream()
                .collect(Collectors.toMap(DailyDataChartVo::getDate, Function.identity()));
        dates.forEach(c -> {
            if (map.containsKey(c)) {
                newList.add(map.get(c));
            } else {
                //没有这一天的数据，默认补0
                newList.add(new DailyDataChartVo(c, BigDecimal.ZERO));
            }
        });
        return newList;
    }

    /**
     * 获取间隔的日期列表
     *
     * @param preDate 开始日期
     * @param endDate 截止日期
     * @return
     */
    private List<LocalDate> getRangeDays(LocalDate preDate, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        //间隔的天数
        long betweenDays = ChronoUnit.DAYS.between(preDate, endDate);
        if (betweenDays < 1) {
            //开始日期<=截止日期
            return dates;
        }
        //创建一个从开始日期、每次加一天的无限流，限制到截止日期为止
        Stream.iterate(preDate, c -> c.plusDays(1))
                .limit(betweenDays + 1)
                .forEach(dates::add);
        return dates;
    }
}
