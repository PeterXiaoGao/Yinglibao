package com.bjpowernode.api.service;

/**
 * @author xiaogao
 * @version 1.0
 * @className IncomeService
 * @description 收益（利息）
 * @since 1.0
 *
 */
public interface IncomeService {
    /*收益计划*/
    void generateIncomePlan();

    /*收益返还*/
    void generateIncomeBack();
}
