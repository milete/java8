package com.jc.demo.controller;

import com.jc.demo.model.vo.DailyDataChartVo;
import com.jc.demo.service.DailyDataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * description：每日消费数据
 *
 * @author milete
 * @date 2020/11/26
 */
@RestController
@RequestMapping("daily/data")
public class DailyDataController {

    @Resource
    private DailyDataService dailyDataService;

    /**
     * 折线图数据
     *
     * @param preDate 开始日期，不传默认近一周
     * @return
     */
    @GetMapping("chart")
    public List<DailyDataChartVo> getChartData(@RequestParam(value = "date", required = false)
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate preDate) {
        return this.dailyDataService.getChartData(preDate);
    }
}
