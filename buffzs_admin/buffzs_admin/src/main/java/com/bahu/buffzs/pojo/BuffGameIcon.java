package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: buffzs
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-17
 **/

@Data
@ApiModel(value = "游戏图标对象模型")
public class BuffGameIcon implements Serializable{

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "图标名称")
    private String name;

    @ApiModelProperty(value = "游戏图标地址")
    private String iconUrl;




}
