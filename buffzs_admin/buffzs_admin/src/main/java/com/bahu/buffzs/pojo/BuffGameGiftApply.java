package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuffGameGiftApply 实体类
 *
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */
@ApiModel(value = "礼包申请")
public class BuffGameGiftApply implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "自增ID")
    private Integer id;
    @ApiModelProperty(value = "礼包ID")
    private String uniqueId;
    @ApiModelProperty(value = "渠道归属用户ID")
    private Integer channelUserid;
    @ApiModelProperty(value = "渠道id")
    private Integer channelId;
    @ApiModelProperty(value = "渠道名")
    private String channelName;
    @ApiModelProperty(value = "游戏归属用户ID")
    private Integer gameUserid;
    @ApiModelProperty(value = "游戏ID")
    private Integer gameId;
    @ApiModelProperty(value = "游戏名")
    private String gameName;
    @ApiModelProperty(value = "礼包名称")
    private String giftName;
    @ApiModelProperty(value = "兑换码数量")
    private Integer giftNum;
    @ApiModelProperty(value = "价值说明")
    private String giftContent;
    @ApiModelProperty(value = "补充说明")
    private String giftNote;
    @ApiModelProperty(value = "申请状态")
    private String applyStatus;
    @ApiModelProperty(value = "驳回理由")
    private String reason;
    @ApiModelProperty(value = "申请时间")
    private java.util.Date applyTime;
    @ApiModelProperty(value = "处理时间")
    private java.util.Date handleTime;

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

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setGameUserid(Integer gameUserid) {
        this.gameUserid = gameUserid;
    }

    public Integer getGameUserid() {
        return this.gameUserid;
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

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftName() {
        return this.giftName;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    public Integer getGiftNum() {
        return this.giftNum;
    }

    public void setGiftContent(String giftContent) {
        this.giftContent = giftContent;
    }

    public String getGiftContent() {
        return this.giftContent;
    }

    public void setGiftNote(String giftNote) {
        this.giftNote = giftNote;
    }

    public String getGiftNote() {
        return this.giftNote;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyStatus() {
        return this.applyStatus;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setApplyTime(java.util.Date applyTime) {
        this.applyTime = applyTime;
    }

    public java.util.Date getApplyTime() {
        return this.applyTime;
    }

    public void setHandleTime(java.util.Date handleTime) {
        this.handleTime = handleTime;
    }

    public java.util.Date getHandleTime() {
        return this.handleTime;
    }

}