package com.bahu.buffzs.pojo;

/**
 * @program: buffzs
 * @description: 反馈
 * @author: Mr.Baron
 * @create: 2019-09-02
 **/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "反馈")
public class BuffFeedback {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "反馈内容")
    private String content;

    @ApiModelProperty(value = "反馈类型")
    private Integer feedbackType;

    @ApiModelProperty(value = "反馈图片")
    private String img;

    @ApiModelProperty(value = "反馈图片1")
    private String img1;

    @ApiModelProperty(value = "反馈图片2")
    private String img2;

    @ApiModelProperty(value = "添加时间")
    private Date addTime;

    @ApiModelProperty(value = "邮箱或者qq")
    private String contact;

    @ApiModelProperty(value = "反馈类型名称")
    private String name;
}
