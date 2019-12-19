package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/11/25
 * @description：
 */

@Data
@ApiModel(value = "推广模板表")
public class BuffHtmlTemplate implements Serializable{

    @ApiModelProperty(value = "id自增长")
    private Integer id;

    @ApiModelProperty(value = "模板名称")
    private String name;

    @ApiModelProperty(value = "模板地址")
    private String templateUrl;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "用户图片地址")
    private String imgUrl;
}
