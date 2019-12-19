package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BuffGameGenres 实体类
 * @date 2019-08-19 18:08:30
 * @version 1.0
 */

@Data
@ApiModel(value = "游戏类型对象模型")
public class BuffGameGenres implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "游戏类型（角色扮演，动作）")
	private String name;


}