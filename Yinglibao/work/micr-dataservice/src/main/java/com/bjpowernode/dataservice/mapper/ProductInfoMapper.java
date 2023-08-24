package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.api.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ProductInfoMapper {

    /*利率平均值*/
    BigDecimal selectAvgRate();

    /*an产品类型分页查询*/
    List<ProductInfo> selectByTypeLimit(@Param("ptype") Integer ptype,
                                        @Param("offset") Integer offset,
                                        @Param("rows") Integer rows);

    /*某个产品类型的记录总数*/
    Integer selectCountByType(@Param("ptype") Integer pType);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo row);

    int insertSelective(ProductInfo row);

    ProductInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductInfo row);

    int updateByPrimaryKey(ProductInfo row);

    /*扣除产品剩余可投资金额*/
    int updateLeftProductMoney(@Param("productId") Integer productId, @Param("money") BigDecimal money);

    /*更新产品为满标*/
    int updateSelled(@Param("id") Integer productId);

    /*满标的理财列表*/
    List<ProductInfo> selectFullTimeProducts(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /*更新状态*/
    int updateStatus(@Param("id") Integer id, @Param("newStatus") int newStatus);
}
