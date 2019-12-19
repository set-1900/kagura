package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/11/8
 * @description：
 */

@Data
@ApiModel(value = "buff助手用户手机设备表对象模型")
public class BuffMobile implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "imsi")
    private String imsi;

    @ApiModelProperty(value = "imei码")
    private String imei;

    @ApiModelProperty(value = "手机机型")
    private String pModel;

    @ApiModelProperty(value = "mac地址")
    private String mac;

    @ApiModelProperty(value = "设备Id")
    private String modulId;

    @ApiModelProperty(value = "序列号")
    private String serial;

    @ApiModelProperty(value = "安卓id")
    private String android;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建渠道号")
    private String channelId;

    @ApiModelProperty(value = "更新渠道号")
    private String updateChannelId;

    @ApiModelProperty(value = "创建时渠道名称")
    private String createChannelName;

    @ApiModelProperty(value = "登录时渠道名称")
    private String registerChannelName;

    @ApiModelProperty(value = "创建时关键字id")
    private String createKeywordId;

    @ApiModelProperty(value = "登录时关键字id")
    private String registerKeywordId;

    @ApiModelProperty(value = "创建时关键字名称")
    private String createKeywordName;

    @ApiModelProperty(value = "登录时关键字名称")
    private String registerKeywordName;

    @ApiModelProperty(value = "打入apk的标记")
    private String sign;

    @ApiModelProperty(value = "创建时子渠道Id")
    private String createSubchannelId;

    @ApiModelProperty(value = "登录时子渠道名称")
    private String createSubchannelName;

    @ApiModelProperty(value = "登录时子渠道Id")
    private String registerSubchannelId;

    @ApiModelProperty(value = "登录时子渠道名称")
    private String registerSubchannelName;
}
