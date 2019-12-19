package com.bahu.buffzs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "游戏评分记录表")
public class BuffScore {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "buff助手用户id")
    private Integer userId;

    @ApiModelProperty(value = "需要打分的游戏id")
    private Integer gameId;

    @ApiModelProperty(value = "星的数据量每颗星代表2分。总共5颗星，总分10分")
    private String start;

    public BuffScore() {
    }

    public BuffScore(Integer id, Integer userId, Integer gameId, String start) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.start = start;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
