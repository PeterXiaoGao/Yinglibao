package com.bjpowernode;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiaogao
 * @version 1.0
 * @className SwaggerApp
 * @description
 * @since 1.0
 */
// 启用Swaager
@EnableSwagger2
@EnableSwaggerBootstrapUI
@SpringBootApplication
public class SwaggerApp {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApp.class, args);
    }
}
