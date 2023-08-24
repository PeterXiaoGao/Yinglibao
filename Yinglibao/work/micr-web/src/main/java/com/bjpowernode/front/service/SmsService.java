package com.bjpowernode.front.service;

/**
 * @author xiaogao
 * @version 1.0
 * @className SmsService
 * @description
 * @since 1.0
 */
public interface SmsService {


    /**
     * @param phone 手机号
     * @return true:发送成功，false 其他情况
     */
    boolean sendSms(String phone);

    /**
     * @param phone 手机号
     * @param code 提交参数中的验证码
     * @return
     */
    boolean checkSmsCode(String phone, String code);
}
