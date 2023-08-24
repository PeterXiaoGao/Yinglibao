package com.bjpowernode.front.config;

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
@ConfigurationProperties(prefix = "aly.realname")
public class AlyRealNameConfig {

    private String url;
    private String appcode;


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
}
