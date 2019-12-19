package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/12/4
 * @description：
 */

@Data
@ApiModel(value = "关键字统计")
public class KeywordStatisticsDto {

    @ApiModelProperty(value = "时间")
    private String date;

    @ApiModelProperty(value = "渠道Id")
    private String channelId;

    @ApiModelProperty(value = "渠道名称")
    private String createChannelName;

    @ApiModelProperty(value = "子渠道id")
    private String createSubchannelId;

    @ApiModelProperty(value = "子渠道名称")
    private String createSubchannelName;

    @ApiModelProperty(value = "关键字id")
    private String createKeywordId;

    @ApiModelProperty(value = "关键字名称")
    private String createKeywordName;

    @ApiModelProperty(value = "新增用户")
    private int addNewUserNumber;

    @ApiModelProperty(value = "新增账号")
    private int addNewAccountsNumber;

    @ApiModelProperty(value = "下载按钮点击数")
    private int downloadButtonNumber;
}
