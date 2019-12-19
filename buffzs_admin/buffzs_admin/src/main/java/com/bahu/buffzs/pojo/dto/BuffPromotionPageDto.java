package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description : buff_promotionPage(推广页)
 * @Author : XieXiang
 * @Date : 2019/11/27
 * @Version : 1.0
 **/

@Data
@ApiModel(value = "推广页")
public class BuffPromotionPageDto {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "推广页名称")
    private String name;

    @ApiModelProperty(value = "推广页地址")
    private String url;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "主渠道id")
    private String channelId;

    @ApiModelProperty(value = "主渠道名称")
    private String channelName;

    @ApiModelProperty(value = "子渠道id")
    private String subchannelId;

    @ApiModelProperty(value = "子渠道名称")
    private String subchannelName;

    @ApiModelProperty(value = "关键字id")
    private String keywordId;

    @ApiModelProperty(value = "关键字名称")
    private String keywordName;

    @ApiModelProperty(value = "推广链接")
    private String promotionUrl;

    @ApiModelProperty(value = "模板id")
    private String hemlTemplateId;

    @ApiModelProperty(value = "用户图片地址")
    private String imgUrl;
}
