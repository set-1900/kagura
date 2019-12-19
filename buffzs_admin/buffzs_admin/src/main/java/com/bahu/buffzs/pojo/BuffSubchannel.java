package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "子渠道表")
public class BuffSubchannel {

    @ApiModelProperty(value = "子渠道id")
    private Integer id;

    @ApiModelProperty(value = "主渠道id")
    private Integer channelId;

    @ApiModelProperty(value = "子渠道名称")
    private String name;

    @ApiModelProperty(value = "子渠道链接")
    private String downloadUrl;

    @ApiModelProperty(value = "结算方式")
    private Integer stype;

    @ApiModelProperty(value = "扣量比例")
    private Integer discount;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
