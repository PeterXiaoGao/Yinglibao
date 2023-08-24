package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.api.model.ProductInfo;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo row);

    int insertSelective(ProductInfo row);

    ProductInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductInfo row);

    int updateByPrimaryKey(ProductInfo row);
}