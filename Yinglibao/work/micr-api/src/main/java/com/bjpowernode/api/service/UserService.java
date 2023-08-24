package com.bjpowernode.api.service;

import com.bjpowernode.api.model.User;
import com.bjpowernode.api.pojo.UserAccountInfo;

/**
 * @author xiaogao
 * @version 1.0
 * @className UserService
 * @description
 * @since 1.0
 */
public interface UserService {

    /**
     * 根据手机号查询数据
     */
    User queryByPhone(String phone);

    /**
     * 用户注册
     * @param phone
     * @param password
     * @return
     */
    int userRegister(String phone, String password);

    /*登录*/
    User userLogin(String phone, String pword);

    /*更新实名认证信息*/
    boolean modifyRealname(String phone, String name, String idCard);

    /*获取用户和资金信息*/
    UserAccountInfo queryUserAllInfo(Integer uid);

    /*查询用户*/
    User queryById(Integer uid);
}
