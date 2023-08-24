package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.api.model.RechargeRecord;

public interface RechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeRecord row);

    int insertSelective(RechargeRecord row);

    RechargeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeRecord row);

    int updateByPrimaryKey(RechargeRecord row);
}