package com.bahu.buffzs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * BuffGameGift 实体类 礼包
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */
@Data
@ApiModel(value = "礼包对象模型")
public class BuffGameGift implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "礼包ID")
    private String uniqueId;

    @ApiModelProperty(value = "游戏归属用户ID")
    private Integer gameUserid;

    @ApiModelProperty(value = "游戏ID")
    private Integer gameId;

    @ApiModelProperty(value = "游戏名字")
    private String gameName;

    @ApiModelProperty(value = "礼包名称")
    private String giftName;

    @ApiModelProperty(value = "礼包价值")
    private String giftWorth;
    @ApiModelProperty(value = "礼包内容")
    private String giftContent;

    @ApiModelProperty(value = "使用说明")
    private String giftUseDesc;

    @ApiModelProperty(value = "有效期限")
    private String giftExpiration;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "过期时间")
    private Date expirationTime;

    @ApiModelProperty(value = "礼包码数量")
    private Integer giftNum;

    @ApiModelProperty(value = "礼包码数剩余数量")
    private Integer giftSurplus;
    // 1：上架 0：下架
    @ApiModelProperty(value = "礼包状态")
    private String giftStatus;

    @ApiModelProperty(value = "礼包添加时间")
    private Date addTime;


}