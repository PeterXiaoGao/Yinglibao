package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.api.model.IncomeRecord;

public interface IncomeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomeRecord row);

    int insertSelective(IncomeRecord row);

    IncomeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncomeRecord row);

    int updateByPrimaryKey(IncomeRecord row);
}