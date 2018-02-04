package com.zwwSys.batch.task;

import com.zwwSys.user.service.PaymentService;
import com.zwwSys.user.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * 统计定时任务
 *
 * @author kuang
 * @since 2018.02.04
 * @version 1.0
 */
@Component
public class StatisticsTask {

    /**
     * 注册用户统计
     */
    @Resource
    private UserService userService;

    /**
     * 用户充值信息统计
     */
    @Resource
    private PaymentService paymentService;

    /**
     * 当天6点执行一次，生成前一天的注册用户统计信息
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void loginUserStatistics() {
        // 获取前一天的日期
        String date = LocalDate.now().minusDays(1).toString();

        // 调用生成逻辑
        userService.insert(date, true);
    }

    /**
     * 当天6点执行一次，生成前一天的用户充值统计信息
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void userRechargeStatistics() {
        // 获取前一天的日期
        String date = LocalDate.now().minusDays(1).toString();

        // 调用生成逻辑
        paymentService.insert(date, true);
    }
}
