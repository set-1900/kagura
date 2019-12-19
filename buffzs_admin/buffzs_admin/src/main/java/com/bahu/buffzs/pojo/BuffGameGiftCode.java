package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuffGameGiftCode 实体类
 * @date 2019-08-19 18:08:30
 * @version 1.0
 */
@ApiModel(value = "礼包码表")
public class BuffGameGiftCode implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "自增ID")
	private Integer id;

	@ApiModelProperty(value = "礼包ID")
	private String uniqueId;

	@ApiModelProperty(value = "游戏id")
	private Integer gameId;

	@ApiModelProperty(value = "领取渠道ID")
	private Integer channelId;

	@ApiModelProperty(value = "礼包码")
	private String giftCode;

	@ApiModelProperty(value = "领取状态 1已领取 0未领取")
	private String status;



	@ApiModelProperty(value = "游戏图标")
	private String icon;

	@ApiModelProperty(value = "礼包名称")
	private String giftName;

	@ApiModelProperty(value = "游戏名称")
	private String gameName;


	/** setter and getter method */
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setUniqueId(String uniqueId){
		this.uniqueId = uniqueId;
	}
	public String getUniqueId(){
		return this.uniqueId;
	}
	public void setGameId(Integer gameId){
		this.gameId = gameId;
	}
	public Integer getGameId(){
		return this.gameId;
	}
	public void setChannelId(Integer channelId){
		this.channelId = channelId;
	}
	public Integer getChannelId(){
		return this.channelId;
	}
	public void setGiftCode(String giftCode){
		this.giftCode = giftCode;
	}
	public String getGiftCode(){
		return this.giftCode;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
}