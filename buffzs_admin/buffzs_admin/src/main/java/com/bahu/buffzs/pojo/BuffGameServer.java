package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * BuffGameServer 实体类
 *
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */

@Data
@ApiModel(value = "游戏区服表")
public class BuffGameServer implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer serverId;

    @ApiModelProperty(value = "游戏id")
    private Integer gameId;

    @ApiModelProperty(value = "所属大区")
    private Integer areaId;

    @ApiModelProperty(value = "服务器名")
    private String serverName;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开服时间")
    private java.util.Date openDate;

    @ApiModelProperty(value = "是否热门")
    private String ifhot;



    @ApiModelProperty(value = "游戏名称")
    private String gameName;
}