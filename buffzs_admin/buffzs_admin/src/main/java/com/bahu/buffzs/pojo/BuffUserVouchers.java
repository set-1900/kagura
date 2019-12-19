package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/12/13
 * @description：
 */

@Data
@ApiModel(value = "buff助手用户领取代金券表")
public class BuffUserVouchers {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "代金券")
    private Integer vouchersId;

    @ApiModelProperty(value = "状态")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
