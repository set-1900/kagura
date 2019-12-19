package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author： Mr.Baron
 * @date： 2019/10/14
 * @description：
 */

@Data
@ApiModel(value = "vpn表")
public class BuffVpn implements Serializable{
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "国家")
    private String country;
}
