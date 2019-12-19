package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "横幅对象模型")
public class BuffBanner implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "banner图片地址")
    private String imageUrl;

    @ApiModelProperty(value = "咨询id")
    private Integer consultionId;

    @ApiModelProperty(value = "0 默认首页banner。1.单机   2福利版  3.爆款 4.朋友圈'")
    private Integer moduleId;

    @ApiModelProperty(value = "1.游戏   2.资讯")
    private Integer type;

}
