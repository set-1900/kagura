package com.bahu.buffzs.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: buffzs
 * @description: 分页实体
 * @author: Mr.Baron
 * @create: 2019-09-06
 **/

@Data
@ApiModel(value = "分页实体")
public class PageBean<T> implements Serializable {
    @ApiModelProperty(value = "当前页")
    private Integer current;// 当前页

    @ApiModelProperty(value = "每页数量")
    private Integer size;// 每页量

    @ApiModelProperty(value = "总记录数")
    private Long total;// 总记录数

    @ApiModelProperty(value = "总页数")
    private long totalPages;// 总页数

    @ApiModelProperty(value = "数据")
    private Object data;
}
