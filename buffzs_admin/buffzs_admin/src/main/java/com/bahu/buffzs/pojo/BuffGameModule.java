package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BuffGameLabel 实体类
 * @date 2019-08-19 18:08:30
 * @version 1.0
 */
@Data
@ApiModel(value = "游戏模块中间表")
public class BuffGameModule implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "游戏id")
	private Integer gameId;

	@ApiModelProperty(value = "模块id")
	private Integer moduleId;


}