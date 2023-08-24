package com.bjpowernode;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.model.Student;
import org.junit.Test;

/**
 * @author xiaogao
 * @version 1.0
 * @className MyTest
 * @description
 * @since 1.0
 */
public class MyTest {

    // student-json
    @Test
    public void testToJson(){
        Student student = new Student();
        student.setId(2001);
        student.setName("李四");
        student.setAge(20);
        // student-json, 使用fastjson -- JSONObject 提供了静态方法
        String json = JSONObject.toJSONString(student);

        // {"age":20,"id":2001,"name":"李四"}
        System.out.println("student转为json="+json);
    }

    // json-student
    @Test
    public void testToObject(){
        String json="{\"age\":30,\"id\":5671,\"name\":\"周畅\"}";
        // 转为对象
        Student student = JSONObject.parseObject(json, Student.class);
        //Student{id=5671, name='周畅', age=30}
        System.out.println("student=" + student);
        System.out.println("name=" + student.getName());
    }

    // 获取name key 的值
    @Test
    public void testAccessValue(){
        String json="{\"age\":30,\"id\":5671,\"name\":\"周畅\"}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        // JSONObject是一个map
        String name = jsonObject.getString("name");
        System.out.println("name= "+ name);

        int age = jsonObject.getInteger("age");
        System.out.println("age = " + age);
    }
}
