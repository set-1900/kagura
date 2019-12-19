package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/12/12
 * @description：
 */

@Data
@ApiModel(value = "代金券表")
public class BuffVouchers {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "面值")
    private Integer value;

    @ApiModelProperty(value = "说明")
    private String vouchersExplain;

    @ApiModelProperty(value = "超过可用")
    private Integer money;

    @ApiModelProperty(value = "总数量")
    private Integer sum;

    @ApiModelProperty(value = "剩余数量")
    private Integer surplusSum;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "过期时间")
    private Date expirationTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String creator;
}
