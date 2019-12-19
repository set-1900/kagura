package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "插件表")
public class BuffPlugins  {
    @ApiModelProperty(value = "插件id")
    private Integer id;

    @ApiModelProperty(value = "插件介绍")
    private String introduction;

    public BuffPlugins(Integer id, String introduction) {
        this.id = id;
        this.introduction = introduction;
    }

    public BuffPlugins() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
