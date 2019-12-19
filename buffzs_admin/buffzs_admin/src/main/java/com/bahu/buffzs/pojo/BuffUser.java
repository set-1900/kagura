package com.bahu.buffzs.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "buff助手用户表")
public class BuffUser implements Serializable {
    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户昵称")
    private String username;

    @ApiModelProperty(value = "性别")
    private int sex;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private Integer city;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "buff助手用户id")
    private String realname;

    @ApiModelProperty(value = "QQ号码")
    private String qq;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "获得的点赞数")
    private Integer praise;

    @ApiModelProperty(value = "请求ip")
    private String ip;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "用户类型1buffzs,2微信,3QQ,4微博 用户")
    private Integer userType;

    @ApiModelProperty(value = "来源用户的id")
    private String uid;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


    @ApiModelProperty(value = "城市名称")
    private String cityName;
}
