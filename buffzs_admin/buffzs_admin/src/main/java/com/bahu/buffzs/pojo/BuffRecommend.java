package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/12/5
 * @Version: 1.0
 **/

@Data
@ApiModel(value = "推荐表")
public class BuffRecommend {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "设备id")
    private String modulId;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "时间戳")
    private String timestamp;

    @ApiModelProperty(value = "8_8_加密信息")
    private String channelNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
