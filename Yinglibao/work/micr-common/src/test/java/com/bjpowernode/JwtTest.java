package com.bjpowernode;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xiaogao
 * @version 1.0
 * @className JwtTest
 * @description
 * @since 1.0
 */
public class JwtTest {

    // 创键jwt
    // 307a2418d38a497794f2ed74d8aaf706
    @Test
    public void testCreateJwt(){
        String key = "307a2418d38a497794f2ed74d8aaf706";

        // 创建SecretKey
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

        Date curDate = new Date();
        Map<String, Object> data = new HashMap<>();
        data.put("userId", 1001);
        data.put("name", "李四");
        data.put("role", "经理");
        // 创建Jwt, 使用Jwts类
        String jwt = Jwts.builder().signWith(secretKey, SignatureAlgorithm.HS256)
                .setExpiration(DateUtils.addMinutes(curDate, 10))
                .setIssuedAt(curDate)
                .setId(UUID.randomUUID().toString())
                .addClaims(data).compact();

        // eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTIzMjg4OTQsImlhdCI6MTY5MjMyODI5NCwianRpIjoiNWFjNTk4ZWEtMGE4Yi00NGJmLTllNjEtMzhmMDA1NGIwZDdhIiwicm9sZSI6Iue7j-eQhiIsIm5hbWUiOiLmnY7lm5siLCJ1c2VySWQiOjEwMDF9.K6Shynj_GhGFkmNonoxbmAMUcAmRLGvJHI5F-CsL3ts
        System.out.println("jwt == " + jwt);

    }

    @Test
    public void testReadJwt(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTIzNDMxOTUsImlhdCI6MTY5MjM0MjU5NSwianRpIjoiNTI2NzZkZTgtNThmZC00ODdjLWFiMDgtNGViYmFkOGJmOWM0Iiwicm9sZSI6Iue7j-eQhiIsIm5hbWUiOiLmnY7lm5siLCJ1c2VySWQiOjEwMDF9.hAgSkapZgDeWYDdqFGuJwDsYzxd1HUPDedcgv62E1Q0";
        String key = "307a2418d38a497794f2ed74d8aaf706";

        //创建secretKey
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

        // 解析jwt， 没有异常， 解析成功
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt);

        // 读数据
        Claims body = claims.getBody();
        Integer userId = body.get("userId", Integer.class);
        System.out.println("userId = " + userId);
        Object uid = body.get("userId");
        System.out.println("uid = " + uid);

        Object name = body.get("name");
        if(name != null){
            String str = name.toString();
            System.out.println("str = " + str);
        }

        String jwtId = body.getId();
        System.out.println("jwtId = " + jwtId);

        Date expiration = body.getExpiration();
        System.out.println("过期时间 = " + expiration);


    }

}
