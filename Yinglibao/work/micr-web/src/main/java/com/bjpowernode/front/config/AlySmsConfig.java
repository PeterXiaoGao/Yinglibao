package com.bjpowernode.front.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiaogao
 * @version 1.0
 * @className AlySmsConfig
 * @description
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = "aly.sms")
public class AlySmsConfig {

    private String url;
    private String appcode;
    private String content;
    private String loginText;


    public String getLoginText() {
        return loginText;
    }

    public void setLoginText(String loginText) {
        this.loginText = loginText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
