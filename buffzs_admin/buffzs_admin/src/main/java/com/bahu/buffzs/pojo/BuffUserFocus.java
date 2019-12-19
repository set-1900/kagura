package com.bahu.buffzs.pojo;

/**
 * BuffUserFocus 实体类
 * @date 2019-08-19 18:08:30
 * @version 1.0
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "buff助手用户关注表")
public class BuffUserFocus implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "用户id")
	private Integer userid;

	@ApiModelProperty(value = "关注用户id")
	private Integer useridFocus;

	/** setter and getter method */
	public void setUserid(Integer userid){
		this.userid = userid;
	}
	public Integer getUserid(){
		return this.userid;
	}
	public void setUseridFocus(Integer useridFocus){
		this.useridFocus = useridFocus;
	}
	public Integer getUseridFocus(){
		return this.useridFocus;
	}

}