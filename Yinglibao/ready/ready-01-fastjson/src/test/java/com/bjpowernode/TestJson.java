package com.bjpowernode;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.model.School;
import com.bjpowernode.model.Student;
import org.junit.Test;

/**
 * @author xiaogao
 * @version 1.0
 * @className TestJson
 * @description
 * @since 1.0
 */
public class TestJson {

    @Test
    public void test01(){
        Student student = new Student();
        student.setId(1001);
        student.setName("李四");
        student.setAge(20);

        School school = new School();
        school.setName("北京大学");
        school.setAddress("北京的海淀区");
        student.setSchool(school);

        // student -》 json
        String json = JSONObject.toJSONString(student);
        // {"age":20,"id":1001,"name":"李四","school":{"address":"北京的海淀区","name":"北京大学"}}
        System.out.println("json = "+json);
    }

    @Test
    public void test02(){
        String json = "{\"age\":22,\"id\":2001,\"name\":\"李四\",\"school\":{\"address\":\"北京的海淀区\",\"name\":\"北京大学\"}}";
        // 转为Student
        Student student = JSONObject.parseObject(json, Student.class);
        System.out.println("student = "+ student);
    }

    @Test
    public void testRead(){
        String json = "{\"age\":22,\"id\":2001,\"name\":\"李四\",\"school\":{\"address\":\"北京的海淀区\",\"name\":\"北京大学\"}}";

        JSONObject jsonObject = JSONObject.parseObject(json);
        /*JSONObject schoolObject = jsonObject.getJSONObject("school");
        String address = schoolObject.getString("address");
        System.out.println("address = " + address);*/

        String string = JSONObject.parseObject(json).getJSONObject("school").getString("address");
        System.out.println("string = " + string);
    }
}
