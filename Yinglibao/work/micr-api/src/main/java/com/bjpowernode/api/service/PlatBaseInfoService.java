package com.bjpowernode.api.service;

import com.bjpowernode.api.pojo.BaseInfo;

/**
 * @author xiaogao
 * @version 1.0
 * @className PlatBaseInfo
 * @description
 * @since 1.0
 */
public interface PlatBaseInfoService {

    /** 计算利率， 注册人数，累计成交金额*/
    BaseInfo queryPlatBaseInfo();

}
