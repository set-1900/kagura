package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * BuffGame 实体类
 *
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */

@Data
@ApiModel(value = "游戏对象模型")
public class BuffGame implements java.io.Serializable {

    @ApiModelProperty(value = "自增长id")
    private Integer id;

    @ApiModelProperty(value = "游戏显示名称")
    private String name;

    @ApiModelProperty(value = "游戏图标")
    private String icon;

    @ApiModelProperty(value = "描述")
    private String shortDescribe;

    @ApiModelProperty(value = "游戏版本号")
    private String version;

    @ApiModelProperty(value = "游戏包大小")
    private String size;

    @ApiModelProperty(value = "游戏下载地址")
    private String downloadUrl;

    @ApiModelProperty(value = "游戏类别id")
    private Integer genres;

    @ApiModelProperty(value = "游戏包名")
    private String packageName;

    @ApiModelProperty(value = "模块id")
    private String module;

    @ApiModelProperty(value = "游戏介绍详情")
    private String detailDescribe;

    @ApiModelProperty(value = "游戏横向宣传图")
    private String pic_h;

    @ApiModelProperty(value = "游戏宣传图竖屏1")
    private String pic_v1;

    @ApiModelProperty(value = "游戏宣传图竖屏2")
    private String pic_v2;

    @ApiModelProperty(value = "游戏宣传图竖屏3")
    private String pic_v3;

    @ApiModelProperty(value = "游戏宣传图竖屏4")
    private String pic_v4;

    @ApiModelProperty(value = "游戏宣传图竖屏5")
    private String pic_v5;

    @ApiModelProperty(value = "游戏宣传图竖屏6")
    private String pic_v6;

    @ApiModelProperty(value = "插件id，0表示无插件")
    private Integer pluginid;

    @ApiModelProperty(value = "是否横幅推荐")
    private String ifbanner;

    @ApiModelProperty(value = "默认不开通问答专区")
    private Integer ifquestion;

    @ApiModelProperty(value = "游戏所属国家id")
    private Integer countryId;

    @ApiModelProperty(value = "游戏等级")
    private Integer level;

    @ApiModelProperty(value = "海外游戏等级")
    private Integer haiWaiLevel;

    @ApiModelProperty(value = "火热图标")
    private Integer iconId;

    @ApiModelProperty(value = "游戏状态1：上架 0：下架")
    private Integer gameStatus;




    @ApiModelProperty(value = "游戏标签")
    private String label;

    @ApiModelProperty(value = "游戏标签名称")
    private String labelName;

    @ApiModelProperty(value = "游戏类别名称")
    private String genresName;

    @ApiModelProperty(value = "游戏模块名称")
    private String bmName;

    @ApiModelProperty(value = "游戏标签集合id")
    private List labelId;

    @ApiModelProperty(value = "游戏模块集合id")
    private List moduleId;
}