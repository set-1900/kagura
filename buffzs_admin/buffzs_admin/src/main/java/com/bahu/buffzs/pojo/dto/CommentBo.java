package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "评论返回实体")
public class CommentBo implements Serializable{
    @ApiModelProperty(value = "评论id自增长")
    private Integer id;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "评论的用户id")
    private Integer fromUid; // 当前登录id

    @ApiModelProperty(value = "评论类型")
    private Integer topicType; //评论类型

    @ApiModelProperty(value = "评论主题id评论类型里面具体某一项的id")
    private Integer topicId;

    @ApiModelProperty(value = "目标的用户id")
    private Integer toUid; // 创建人id

    @ApiModelProperty(value = "添加时间")
    private Date addTime; // 添加时间

    @ApiModelProperty(value = "点赞数")
    private Integer laud;  //点赞数量



    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "头像")
    private String icon;
    @ApiModelProperty(value = "回复")
    private List<CommentBo> buffCommentList;


}
