package com.bahu.buffzs.mapper;


import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelMapper {

    List<BuffLabel> findAll();

    Integer save(@Param("gameid") Integer gameid, @Param("labelid")String labelid);

    //游戏id
    List<BuffLabel> findByGameId(Integer id);

    //主键id
    BuffLabel findById(Integer id);

    Integer saveLabel(BuffLabel buffLabel);

    Integer updateSave(BuffLabel buffLabel);

    Integer delete(Integer id);

    //通过游戏id 删除 标签中间表
    Integer deleteByGameId(@Param("gameid") Integer gameid);

    //通过标签id  删除游戏标签中间表中的数据
    Integer deleteGame(Integer labelId);
}
