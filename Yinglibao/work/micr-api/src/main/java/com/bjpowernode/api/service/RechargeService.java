package com.bjpowernode.api.service;

import com.bjpowernode.api.model.RechargeRecord;

import java.util.List;

/**
 * @author xiaogao
 * @version 1.0
 * @className RechargeService
 * @description
 * @since 1.0
 */
public interface RechargeService {

    /*根据userID查询它的充值记录*/
    List<RechargeRecord> queryByUid(Integer uid, Integer pageNo, Integer pageSize);

    int addRechargeRecord(RechargeRecord record);

    /*处理后续充值*/
    int handlerKQNotify(String orderId, String payAmount, String payResult);
}
