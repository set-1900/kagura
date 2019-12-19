package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "游戏提问表")
public class BuffQuestionAnswer {
    @ApiModelProperty(value = "问题id")
    private Integer id;

    @ApiModelProperty(value = "父id")
    private Integer pid;

    @ApiModelProperty(value = "游戏id")
    private Integer gameId;

    @ApiModelProperty(value = "问题标题")
    private String title;

    @ApiModelProperty(value = "问题内容")
    private String content;

    @ApiModelProperty(value = "buff助手用户id")
    private Integer userId;

    @ApiModelProperty(value = "1.问题  2.回答")
    private Integer type;

    @ApiModelProperty(value = "问题描述图片")
    private String img1;

    @ApiModelProperty(value = "问题描述图片")
    private String img2;

    @ApiModelProperty(value = "问题描述图片")
    private String img3;

    @ApiModelProperty(value = "问题或者回答的时间")
    private Date updatetime;

    @ApiModelProperty(value = "回答的点赞数")
    private Integer laud;

    @ApiModelProperty(value = "用户昵称")
    private String username;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    private List<BuffQuestionAnswer> buffQuestionAnswerList;

    public BuffQuestionAnswer() {
    }

    public BuffQuestionAnswer(Integer id, Integer pid, Integer gameId, String title, String content, Integer userId, Integer type, String img1, String img2, String img3, Date updatetime, Integer laud, List<BuffQuestionAnswer> buffQuestionAnswerList, String username, String icon) {
        this.id = id;
        this.pid = pid;
        this.gameId = gameId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.type = type;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.updatetime = updatetime;
        this.laud = laud;
        this.buffQuestionAnswerList = buffQuestionAnswerList;
        this.username = username;
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getLaud() {
        return laud;
    }

    public void setLaud(Integer laud) {
        this.laud = laud;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<BuffQuestionAnswer> getBuffQuestionAnswerList() {
        return buffQuestionAnswerList;
    }

    public void setBuffQuestionAnswerList(List<BuffQuestionAnswer> buffQuestionAnswerList) {
        this.buffQuestionAnswerList = buffQuestionAnswerList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
}
