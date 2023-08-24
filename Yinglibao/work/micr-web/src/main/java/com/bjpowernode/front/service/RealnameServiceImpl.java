package com.bjpowernode.front.service;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.api.service.UserService;
import com.bjpowernode.common.util.HttpClientUtils;
import com.bjpowernode.front.config.AlyRealNameConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaogao
 * @version 1.0
 * @className RealnameServiceImpl
 * @description
 * @since 1.0
 */
@Service
public class RealnameServiceImpl {

    @Resource
    private AlyRealNameConfig realNameConfig;

    @DubboReference(interfaceClass = UserService.class, version = "1.0")
    private UserService userService;


    /*true:认证通过*/
    public boolean handleRealname(String phone, String name, String idCard){
        boolean realname = false;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idcard", idCard);
        // 设置响应头
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "APPCODE " + realNameConfig.getAppcode());

        try {
            // String resp = HttpClientUtils.doPost(realNameConfig.getUrl(), header, params);
            String resp = "{\n" +
                    "    \"code\": \"0\", //返回码，0：成功，非0：失败（详见错误码定义）\n" +
                    "          //当code=0时，再判断下面result中的res；当code!=0时，表示调用已失败，无需再继续\n" +
                    "    \"message\": \"成功\", //返回码说明\n" +
                    "    \"result\": {\n" +
                    "        \"name\": \""+name+"\", //姓名\n" +
                    "        \"idcard\": \"350301198011129422\", //身份证号\n" +
                    "        \"res\": \"1\", //核验结果状态码，1 一致；2 不一致；3 无记录\n" +
                    "        \"description\": \"一致\",  //核验结果状态描述\n" +
                    "       \"sex\": \"男\",\n" +
                    "        \"birthday\": \"19940320\",\n" +
                    "        \"address\": \"江西省南昌市东湖区\"\n" +
                    "    }\n" +
                    "}";
            if(StringUtils.isNotBlank(resp)){
                JSONObject respObject = JSONObject.parseObject(resp);
                if("0".equalsIgnoreCase(respObject.getString("code"))){
                    // 访问api成功 解析result
                    if("1".equalsIgnoreCase(respObject.getJSONObject("result").getString("res"))){
                        //姓名 身份证号一致
                        // 处理更新数据库
                        boolean modifyResult = userService.modifyRealname(phone,name,idCard);
                        // 更新结果
                        realname = modifyResult;

                    }
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return realname;
    }
}
