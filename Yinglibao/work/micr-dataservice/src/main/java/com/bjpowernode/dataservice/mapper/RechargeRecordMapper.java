package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.api.model.RechargeRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeRecord row);

    int insertSelective(RechargeRecord row);

    RechargeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeRecord row);

    int updateByPrimaryKey(RechargeRecord row);

    List<RechargeRecord> selectByUid(@Param("uid") Integer uid, @Param("offset") int offset, @Param("rows") Integer pageSize);

    RechargeRecord selectByRechargeNo(@Param("rechargeNo") String orderId);

    /*更新状态*/
    int updateStatus(@Param("id") Integer id, @Param("newStatus") int rechargeStatusSuccess);
}
