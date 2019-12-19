package com.bahu.buffzs.pojo;
/**
 * @author Barom
 * @date 2019-08-30
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "buff助手用户关注表")
public class BuffUserVote {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "游戏id")
    private Integer gameId;

    @ApiModelProperty(value = "buff助手用户id")
    private Integer userId;


    @ApiModelProperty(value = "投票数")
    private Integer num;
    @ApiModelProperty(value = "游戏名")
    private String name;
    @ApiModelProperty(value = "游戏图标")
    private String icon ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
