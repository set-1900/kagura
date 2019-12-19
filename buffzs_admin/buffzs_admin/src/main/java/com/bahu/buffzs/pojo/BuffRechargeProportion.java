package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author： Mr.Baron
 * @date： 2019/11/28
 * @description：
 */

@Data
@ApiModel(value = "平台货币比例表对象模型")
public class BuffRechargeProportion implements Serializable{

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "现金")
    private Integer price;

    @ApiModelProperty(value = "平台币")
    private Integer systemMoney;

    @ApiModelProperty(value = "充值类型")
    private Integer type;


}
