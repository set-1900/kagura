package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * BuffGameGiftGet 实体类
 *
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */
@ApiModel(value = "礼包领取")
public class BuffGameGiftGet implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "自增ID")
    private Integer id;

    @ApiModelProperty(value = "礼包ID")
    private String uniqueId;

    @ApiModelProperty(value = "礼包名字")
    private String giftName;

    @ApiModelProperty(value = "游戏id")
    private Integer gameId;

    @ApiModelProperty(value = "游戏名")
    private String gameName;

    @ApiModelProperty(value = "用户归属渠道id")
    private Integer channelUserid;

    @ApiModelProperty(value = "领取渠道ID")
    private Integer channelId;

    @ApiModelProperty(value = "领取数量")
    private Integer getNum;

    @ApiModelProperty(value = "价值说明")
    private String giftWorth;

    @ApiModelProperty(value = "礼包内容")
    private String giftContent;

    @ApiModelProperty(value = "有效期限")
    private String giftExpiration;

    @ApiModelProperty(value = "过期时间")
    private Date expirationTime;

    @ApiModelProperty(value = "使用说明")
    private String giftUseDesc;

    @ApiModelProperty(value = "领取时间")
    private Date getTime;

    @ApiModelProperty(value = "礼包类型 1游戏礼包 2渠道礼包")
    private String type;


    /**
     * setter and getter method
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftName() {
        return this.giftName;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameId() {
        return this.gameId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setChannelUserid(Integer channelUserid) {
        this.channelUserid = channelUserid;
    }

    public Integer getChannelUserid() {
        return this.channelUserid;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelId() {
        return this.channelId;
    }

    public void setGetNum(Integer getNum) {
        this.getNum = getNum;
    }

    public Integer getGetNum() {
        return this.getNum;
    }

    public void setGiftWorth(String giftWorth) {
        this.giftWorth = giftWorth;
    }

    public String getGiftWorth() {
        return this.giftWorth;
    }

    public void setGiftContent(String giftContent) {
        this.giftContent = giftContent;
    }

    public String getGiftContent() {
        return this.giftContent;
    }

    public void setGiftExpiration(String giftExpiration) {
        this.giftExpiration = giftExpiration;
    }

    public String getGiftExpiration() {
        return this.giftExpiration;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getExpirationTime() {
        return this.expirationTime;
    }

    public void setGiftUseDesc(String giftUseDesc) {
        this.giftUseDesc = giftUseDesc;
    }

    public String getGiftUseDesc() {
        return this.giftUseDesc;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Date getGetTime() {
        return this.getTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}