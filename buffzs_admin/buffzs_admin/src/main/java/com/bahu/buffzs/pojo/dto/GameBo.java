package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "游戏返回实体")
public class GameBo {

    @ApiModelProperty(value = "自增长id")
    private Integer id;

    @ApiModelProperty(value = "游戏显示名称")
    private String name;

    @ApiModelProperty(value = "游戏图标")
    private String icon;

    @ApiModelProperty(value = "游戏标签")
    private Integer label;

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

    @ApiModelProperty(value = "i游戏包名d")
    private String packageName;

    @ApiModelProperty(value = "模块id")
    private Integer module;

    @ApiModelProperty(value = "游戏介绍详情")
    private String describe;

    @ApiModelProperty(value = "游戏横向宣传图")
    private String pic_h;

    @ApiModelProperty(value = "游戏宣传图竖屏")
    private String pic_v1;

    @ApiModelProperty(value = "游戏宣传图竖屏")
    private String pic_v2;

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


    @ApiModelProperty(value = "服务器名")
    private String serverName;      //服务器名

    @ApiModelProperty(value = "开服时间")
    private java.util.Date openDate; // 开服时间

    @ApiModelProperty(value = "模块名")
    private String bmName;  // 模块名

    @ApiModelProperty(value = "游戏类型名")
    private String genresName;

    @ApiModelProperty(value = "标签名")
    private List<String> labelName; // 标签名

    @ApiModelProperty(value = "游戏插件介绍")
    private String introduction; //游戏插件介绍


}
