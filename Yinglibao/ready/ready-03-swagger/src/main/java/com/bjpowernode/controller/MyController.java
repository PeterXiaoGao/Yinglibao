package com.bjpowernode.controller;

import com.bjpowernode.model.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaogao
 * @version 1.0
 * @className MyController
 * @description
 * @since 1.0
 */
@Api(tags = "用户功能接口")
@RestController
public class MyController {

    /**
     * @ApiOperation:说明方法的作用 位置： 控制器方法上面
     */
    @ApiOperation(value = "swagger快速使用", notes = "第一个swagger控制器方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, defaultValue = "zhangsan",
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "用户的主键", required = true)
    })
    @GetMapping("/hello")
    public String helloSwagger(String name, Integer id) {
        return "Swagger在线生成接口文档，同时具有测试接口的功能";
    }

    @ApiOperation(value = "查询学生", notes = "根据主键查询学生信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "主键")
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "接口访问成功",
                    response = Student.class
            ),

            @ApiResponse(
                    code = 404,
                    message = "接口没有找到"
            )
    })
    @PostMapping("/query/id")
    public Student queryStudent(Integer id) {
        Student student = new Student();
        student.setId(1001);
        student.setName("李四");
        return student;
    }
}
