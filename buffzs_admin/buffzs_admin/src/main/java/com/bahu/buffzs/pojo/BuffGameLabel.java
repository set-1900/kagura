package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuffGameLabel 实体类
 * @date 2019-08-19 18:08:30
 * @version 1.0
 */
@ApiModel(value = "游戏标签中间表")
public class BuffGameLabel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "游戏id")
	private Integer gameid;

	@ApiModelProperty(value = "标签id")
	private Integer labelid;

	/** setter and getter method */
	public void setGameid(Integer gameid){
		this.gameid = gameid;
	}
	public Integer getGameid(){
		return this.gameid;
	}
	public void setLabelid(Integer labelid){
		this.labelid = labelid;
	}
	public Integer getLabelid(){
		return this.labelid;
	}

}