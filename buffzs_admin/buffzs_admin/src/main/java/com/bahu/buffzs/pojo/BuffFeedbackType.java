package com.bahu.buffzs.pojo;

/**
 * @program: buffzs
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-02
 **/
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "反馈类目")
public class BuffFeedbackType {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "反馈类别名称")
    private String name ;

    @ApiModelProperty(value = "反馈类目说明")
    private String shortDescribe ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescribe() {
        return shortDescribe;
    }

    public void setShortDescribe(String shortDescribe) {
        this.shortDescribe = shortDescribe;
    }

    public BuffFeedbackType(Integer id, String name, String shortDescribe) {
        this.id = id;
        this.name = name;
        this.shortDescribe = shortDescribe;
    }

    public BuffFeedbackType() {
    }
}
