package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 子渠道关键字中间表
 * @Author: XieXiang
 * @Date: 2019/12/3
 * @Version: 1.0
 **/

@Data
@ApiModel(value = "子渠道关键字中间表")
public class BuffSubchannelKeyword {

    @ApiModelProperty(value = "子渠道id")
    private String subchannelId;

    @ApiModelProperty(value = "关键字id")
    private String keywordId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
