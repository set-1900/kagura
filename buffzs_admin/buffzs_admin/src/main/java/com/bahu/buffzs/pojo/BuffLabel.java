package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BuffLabel 实体类
 * @date 2019-08-19 18:08:30
 * @version 1.0
 */

@Data
@ApiModel(value = "游戏标签表")
public class BuffLabel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "标签名")
	private String name;

	@ApiModelProperty(value = "标签颜色")
	private String color;

	private String gameId;


}