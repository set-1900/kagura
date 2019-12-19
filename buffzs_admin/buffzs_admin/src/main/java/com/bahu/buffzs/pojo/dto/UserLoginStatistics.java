package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/10/22
 * @description：
 */
@Data
@ApiModel(value = "用户登录统计")
public class UserLoginStatistics {

    @ApiModelProperty(value = "渠道id")
    private String id;

    @ApiModelProperty(value = "渠道名称")
    private String name;

    @ApiModelProperty(value = "时间")
    private Date date;

    @ApiModelProperty(value = "新增用户数量")
    private String addNewUserNumber;

    @ApiModelProperty(value = "新增账号数量")
    private String addNewAccountsNumber;

    @ApiModelProperty(value = "活跃用户数量")
    private String activeUserNumber;

    @ApiModelProperty(value = "活跃账号数量")
    private String activeAccountsNumber;

    @ApiModelProperty(value = "启动次数")
    private String startNumber;

    @ApiModelProperty(value = "次日活跃")
    private String nextActive;

    @ApiModelProperty(value = "七天活跃")
    private String sevenActive;

    @ApiModelProperty(value = "十五天活跃")
    private String fifteenActive;

    @ApiModelProperty(value = "三十活跃")
    private String thirtyActive;
}
