package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/12/7
 * @description：
 */
@Data
@ApiModel(value = "点击次数统计")
public class StatisticsDto {

    @ApiModelProperty(value = "时间")
    private String date;

    @ApiModelProperty(value = "游戏Id")
    private int gameId;

    @ApiModelProperty(value = "游戏名称")
    private String gameName;

    @ApiModelProperty(value = "游戏点击次数")
    private int gameClickCount;

    @ApiModelProperty(value = "游戏下载次数")
    private int gameDownloadCount;

    private int gameDownloadCountSum;
}
