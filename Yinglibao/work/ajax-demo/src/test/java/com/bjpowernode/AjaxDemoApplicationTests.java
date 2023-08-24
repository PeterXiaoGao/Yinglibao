package com.bjpowernode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class jaxDemoApplicationTests {

    @Test
    void contextLoads() {
        String s = "123llll";
        System.out.println(s.substring(2));
    }

}
