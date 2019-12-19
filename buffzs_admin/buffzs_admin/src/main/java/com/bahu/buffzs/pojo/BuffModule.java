package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "模块分类表")
public class BuffModule implements Serializable {
    @ApiModelProperty(value = "模块分类id")
    private Integer id;

    @ApiModelProperty(value = "模块分类名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private Integer pid;

    @ApiModelProperty(value = "1，顶部菜单模块   2.首页内容模块")
    private Integer type;

    @ApiModelProperty(value = "游戏产品内容排列方式。0竖向，1横向")
    private Integer sequence;

    @ApiModelProperty(value = "1.所属首页   2.所属海外游戏")
    private Integer moduleType;


    @ApiModelProperty(value = "")
    private Integer gameid;

    @ApiModelProperty(value = "上级模块名称")
    private String pName;

    @ApiModelProperty(value = "模块图标的地址")
    private String iconUrl;

    @ApiModelProperty(value = "模块的级别")
    private Integer level;
}
