package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuffArea 实体类
 *
 * @version 1.0
 * @date 2019-08-19 18:08:30
 */
@ApiModel(value = "地区对象模型")
public class BuffArea implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "城市ID")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "上级ID")
    private Integer pid;

    @ApiModelProperty(value = "ID路径")
    private String path;

    @ApiModelProperty(value = "级别")
    private String level;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * setter and getter method
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return this.level;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return this.sort;
    }

}