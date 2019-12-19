package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: buffzs
 * @description: 朋友
 * @author: Mr.Baron
 * @create: 2019-09-03
 **/

@Data
@ApiModel(value = "朋友圈对象模型")
public class BuffCircleOfFriends implements Serializable{

    @ApiModelProperty(value = "评论id自增长")
    private Integer id;

    @ApiModelProperty(value = "buff助手用户id")
    private Integer userId;

    @ApiModelProperty(value = "朋友圈图片1")
    private String img1;
    @ApiModelProperty(value = "朋友圈图片2")
    private String img2;
    @ApiModelProperty(value = "朋友圈图片3")
    private String img3;
    @ApiModelProperty(value = "朋友圈图片4")
    private String img4;
    @ApiModelProperty(value = "朋友圈图片5")
    private String img5;
    @ApiModelProperty(value = "朋友圈图片6")
    private String img6;
    @ApiModelProperty(value = "朋友圈图片7")
    private String img7;
    @ApiModelProperty(value = "朋友圈图片8")
    private String img8;
    @ApiModelProperty(value = "朋友圈图片9")
    private String img9;

    @ApiModelProperty(value = "朋友圈内容")
    private String content;

    @ApiModelProperty(value = "添加时间")
    private Date addTime;

    @ApiModelProperty(value = "点赞数")
    private Integer laud;

    @ApiModelProperty(value = "用户名")
    private String username;

}
