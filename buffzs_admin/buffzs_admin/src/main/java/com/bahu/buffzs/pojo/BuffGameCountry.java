package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author： Mr.Baron
 * @date： 2019/10/31
 * @description：
 */
@Data
@ApiModel(value = "游戏国家")
public class BuffGameCountry implements Serializable{
    @ApiModelProperty(value = "自增长id")
    private Integer id;
    @ApiModelProperty(value = "国家")
    private String country;
}
