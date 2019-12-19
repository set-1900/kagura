package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 咨询中心表
 * BuffConsultion 实体类
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */

@Data
@ApiModel(value = "咨询对象模型")
public class BuffConsultion implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id自增长")
    private Integer id;

    @ApiModelProperty(value = "评论类型 :1.咨讯    2.攻略  3.原创")
    private String type;

    @ApiModelProperty(value = "游戏icon")
    private String icon;

    @ApiModelProperty(value = "游戏id")
    private Integer gameId;

    @ApiModelProperty(value = "资讯title")
    private String title;

    @ApiModelProperty(value = "资讯内容")
    private String content;

    @ApiModelProperty(value = "阅读量")
    private Integer amountRead;

    @ApiModelProperty(value = "1.公告，2.新闻，3.新手，4.高阶 5.评测'")
    private Integer tag;

    @ApiModelProperty(value = "发布时间")
    private Date time;

    @ApiModelProperty(value = "游戏名称")
    private String gameName;
}