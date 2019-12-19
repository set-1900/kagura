package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * BuffComment 实体类
 *
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */

@Data
@ApiModel(value = "评论对象模型")
public class BuffComment implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id自增长")
    private Integer id;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "评论的用户id")
    private Integer fromUid;

    @ApiModelProperty(value = "评论类型")
    private Integer topicType;

    @ApiModelProperty(value = "评论主题id评论类型里面具体某一项的id")
    private Integer topicId;

    @ApiModelProperty(value = "目标的用户id")
    private Integer toUid;

    @ApiModelProperty(value = "添加时间")
    private Date addTime;

    @ApiModelProperty(value = "点赞数")
    private Integer laud;

}