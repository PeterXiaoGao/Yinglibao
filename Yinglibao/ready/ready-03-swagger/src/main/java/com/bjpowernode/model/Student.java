package com.bjpowernode.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xiaogao
 * @version 1.0
 * @className Student
 * @description
 * @since 1.0
 */
@ApiModel(description = "数据类，表示学生信息")
@Data
public class Student {
    @ApiModelProperty(value = "学生主键")
    private Integer id;
    @ApiModelProperty(value = "学生姓名")
    private String name;

}
