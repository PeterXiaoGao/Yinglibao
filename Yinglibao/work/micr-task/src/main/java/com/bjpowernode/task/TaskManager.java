package com.bjpowernode.task;

import com.bjpowernode.api.service.IncomeService;
import com.bjpowernode.common.util.HttpClientUtils;
import io.netty.handler.codec.http.HttpUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xiaogao
 * @version 1.0
 * @className TaskManager
 * @description
 * @since 1.0
 */
@Component("taskManager")
public class TaskManager {

    /**
     * 定义方法，表示要执行的定时任务功能
     * 方法定义的要求：
     * 1.public 公共方法
     * 2.方法没有参数
     * 3.方法没有返回值
     * 4.方法上面加入 @Scheduled， 设置cron属性，指定时间
     */
    /*@Scheduled(cron = "1 48 22 * * ?")
    public void testCron(){
        System.out.println("执行了定时任务的方法：" + new Date());
    }*/

    // @Scheduled(cron = "*/5 * * * * ?")
    /*public void testCron(){
        System.out.println("执行了定时任务的方法：" + new Date());
    }*/

    @DubboReference(interfaceClass = IncomeService.class, version = "1.0")
    private IncomeService incomeService;

    /*生成收益计划*/
    @Scheduled(cron = "0 0 1 * * ?")
    public void invokeGenerateIncomePlan(){
        incomeService.generateIncomePlan();
    }

    /*生成收益返还*/
    @Scheduled(cron = "0 0 2 * * ?")
    public void invokeGenerateIncomeBack(){
        incomeService.generateIncomeBack();;
    }

    /**补单接口*/
    //@Scheduled(cron = "0 0/20 * * * ?")
    public void invokeKuaiQianQuery(){
        try {
            String url = "http://localhost:9000/pay/kq/rece/query";
            HttpClientUtils.doGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
