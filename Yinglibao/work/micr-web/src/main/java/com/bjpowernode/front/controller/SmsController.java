package com.bjpowernode.front.controller;

import com.bjpowernode.common.constants.RedisKey;
import com.bjpowernode.common.enums.RCode;
import com.bjpowernode.common.util.CommonUtil;
import com.bjpowernode.front.service.SmsService;
import com.bjpowernode.front.view.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaogao
 * @version 1.0
 * @className SmsController
 * @description
 * @since 1.0
 */
@Api(tags = "短信业务")
@RestController
@RequestMapping("/v1/sms")
public class SmsController extends BaseController{

    @Resource(name = "smsCodeRegisterImpl")
    private SmsService smsService;

    @Resource(name = "smsCodeLoginImpl")
    private SmsService loginSmsService;

    /**
     * 发送注册验证码短信
     */
    @ApiOperation(value = "发送注册验证码")
    @GetMapping("/code/register")
    public RespResult sendCodeRegister(@RequestParam("phone") String phone){
        RespResult result = RespResult.fail();
        if(CommonUtil.checkPhone(phone)){
            // 判断redis中是否有这个手机号的验证码
            String key = RedisKey.KEY_SMS_CODE_REG + phone;
            if (stringRedisTemplate.hasKey(key)) {
                // redis缓存存在  不用发送验证码
                result = RespResult.ok();
                result.setRCode(RCode.SMS_CODE_CAN_USE);

            }else {
                // redis缓存不存在key 可以发送验证码
                boolean isSuccess = smsService.sendSms(phone);
                if(isSuccess){
                    // 短信发送成功
                    result = RespResult.ok();
                }
            }

        } else {
            result.setRCode(RCode.PHONE_EXISTS);
        }

        return result;
    }

    /**
     * 发送登录验证码短信
     */
    @ApiOperation(value = "发送登录验证码")
    @GetMapping("/code/login")
    public RespResult sendCodeLogin(@RequestParam("phone") String phone){
        RespResult result = RespResult.fail();
        if(CommonUtil.checkPhone(phone)){
            // 判断redis中是否有这个手机号的验证码
            String key = RedisKey.KEY_SMS_CODE_LOGIN + phone;
            if (stringRedisTemplate.hasKey(key)) {
                // redis缓存存在  不用发送验证码
                result = RespResult.ok();
                result.setRCode(RCode.SMS_CODE_CAN_USE);

            }else {
                // redis缓存不存在key 可以发送验证码
                boolean isSuccess = loginSmsService.sendSms(phone);
                if(isSuccess){
                    // 短信发送成功
                    result = RespResult.ok();
                }
            }

        } else {
            result.setRCode(RCode.PHONE_EXISTS);
        }

        return result;
    }
}
