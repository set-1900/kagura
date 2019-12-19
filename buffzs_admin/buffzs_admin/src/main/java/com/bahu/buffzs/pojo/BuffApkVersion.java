package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-23
 **/
@Data
@ApiModel(value = "buffzs版本对象模型")
public class BuffApkVersion implements Serializable {

    @ApiModelProperty(value = "版本ID")
    private Integer id;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "版本代码")
    private Integer code;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "更新内容说明1")
    private String about1;

    @ApiModelProperty(value = "更新内容说明2")
    private String about2;

    @ApiModelProperty(value = "更新内容说明3")
    private String about3;

    @ApiModelProperty(value = "更新内容说明4")
    private String about4;

    @ApiModelProperty(value = "更新内容说明5")
    private String about5;

    @ApiModelProperty(value = "下载地址")
    private String downurl;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "0不需要强更，前端提示更新。1.强制更新，app启动时检查")
    private Integer updateIfForce;

    @ApiModelProperty(value = "1是buffzs,2是google plugin")
    private Integer apkType;

    @ApiModelProperty(value = "下载地址")
    private String downurl2;

    @ApiModelProperty(value = "apk所属渠道")
    private String channelNum;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "上一版本的apk地址")
    private String oldDownurl;
}