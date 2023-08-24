package com.bjpowernode.front.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.common.constants.RedisKey;
import com.bjpowernode.front.config.AlySmsConfig;
import com.bjpowernode.front.service.SmsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaogao
 * @version 1.0
 * @className SmsServiceImpl
 * @description 登录发送短信验证码
 * @since 1.0
 */
@Service("smsCodeLoginImpl")
public class SmsCodeLoginImpl implements SmsService {

    @Resource
    private AlySmsConfig smsConfig;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean sendSms(String phone) {

        boolean send = false;
        // 设置短信内容
        String random = RandomStringUtils.randomNumeric(4);
        System.out.println("登录验证码的随机数 random=" + random);
        // 更新content中的  %s  【大富科技】登录验证码是：%s，3分钟内有效，请勿泄露给他人。
        // 用的成都创信  验证码发送
        // String content = String.format(smsConfig.getLoginText(), random);

        // // 使用HttpClient发送 post 请求给第三方。
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = null;
        try {

            uri = new URIBuilder("https://gyytz.market.alicloudapi.com/sms/smsSend")
                    .addParameter("mobile", "13800138011")
                    .addParameter("templateId", "908e94ccf08b4476ba6c876d13f084ad")
                    .addParameter("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2")
                    .addParameter("param", "**code**:"+random+",**minute**:3")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpPost post = new HttpPost(uri);

        try {

            // 对象的模式设置请求头信息 成都创信
            // post.setHeader(new BasicHeader("authorization", "appcode "+smsConfig.getAppcode()));
            // 三网106短信
            post.setHeader(new BasicHeader("authorization", "appcode 27648d207c824f4eb52fe1392a515d09"));
            // 字符串模式设置请求头信息
            //post.setHeader("authorization", "appcode "+smsConfig.getAppcode());

            // 执行post请求
            //CloseableHttpResponse response = client.execute(post);

            //if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 得到返回数据，json
                // String text = EntityUtils.toString(response.getEntity());
                String text = "{\n" +
                        "  \"msg\": \"成功\",\n" +
                        "  \"smsid\": \"169225805797315447324638983\",\n" +
                        "  \"code\": \"0\",\n" +
                        "  \"balance\": \"19\"\n" +
                        "}";

                // 解析json
                if (StringUtils.isNotBlank(text)) {
                    // fastjson 把String转为json
                    JSONObject jsonObject = JSONObject.parseObject(text);
                    if (("0".equalsIgnoreCase(jsonObject.getString("code"))) && ("成功".equalsIgnoreCase(jsonObject.getString("msg"))) ) {
                        // 第三方接口调用成功
                        // 短信发送成功
                        send = true;

                        // 把短信的验证码，存入到redis
                        String key = RedisKey.KEY_SMS_CODE_LOGIN + phone;
                        stringRedisTemplate.boundValueOps(key).set(random, 3, TimeUnit.MINUTES);

                    }
                }
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return send;
    }

    @Override
    public boolean checkSmsCode(String phone, String code) {
        String key = RedisKey.KEY_SMS_CODE_LOGIN + phone;
        if(stringRedisTemplate.hasKey(key)){
            String querySmsCode = stringRedisTemplate.boundValueOps(key).get();
            if(code.equals(querySmsCode)){
                return true;
            }
        }
        return false;
    }
}
