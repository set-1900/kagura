package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/11/14
 * @description：
 */

@Data
@ApiModel(value = "渠道对象模型")
public class BuffChannel implements Serializable {

    @ApiModelProperty(value = "id自增长")
    private Integer id;

    @ApiModelProperty(value = "渠道名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
