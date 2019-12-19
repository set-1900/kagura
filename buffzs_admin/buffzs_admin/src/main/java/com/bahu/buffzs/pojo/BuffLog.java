package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/11/29
 * @description：
 */

@Data
@ApiModel(value = "点击日志")
public class BuffLog implements Serializable{

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "game / banner 的 id")
    private Integer gameId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "类型1游戏2下载游戏3banner4首页广告页5推广页下载按钮")
    private String type;

    @ApiModelProperty(value = "所在位置")
    private String moduleId;

    @ApiModelProperty(value = "设备Id")
    private String modulId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "渠道Id")
    private String channelId;

    @ApiModelProperty(value = "子渠道Id")
    private String subchannelId;

    @ApiModelProperty(value = "关键字Id")
    private String keywordId;

}
