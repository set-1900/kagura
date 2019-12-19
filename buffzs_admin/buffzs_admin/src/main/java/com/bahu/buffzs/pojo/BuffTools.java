package com.bahu.buffzs.pojo;

/**
 * @program: buffzs
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-02
 **/
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "工具")
public class BuffTools {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "游戏工具图片")
    private String icon ;

    @ApiModelProperty(value = "工具名称")
    private String title ;

    @ApiModelProperty(value = "工具详情地址")
    private String detail ;

    @ApiModelProperty(value = "工具描述")
    private String shortDescribe ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getShortDescribe() {
        return shortDescribe;
    }

    public void setShortDescribe(String shortDescribe) {
        this.shortDescribe = shortDescribe;
    }

    public BuffTools(Integer id, String icon, String title, String detail, String shortDescribe) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.detail = detail;
        this.shortDescribe = shortDescribe;
    }

    public BuffTools() {
    }
}
