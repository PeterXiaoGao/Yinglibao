package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.api.model.BidInfo;

public interface BidInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BidInfo row);

    int insertSelective(BidInfo row);

    BidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo row);

    int updateByPrimaryKey(BidInfo row);
}