package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "buff助手用户资讯浏览表")
public class BuffUserConsultion {

    @ApiModelProperty(value = "buff助手id")
    private Integer userId ;

    @ApiModelProperty(value = "咨讯id")
    private Integer consultionId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getConsultionId() {
        return consultionId;
    }

    public void setConsultionId(Integer consultionId) {
        this.consultionId = consultionId;
    }
}
