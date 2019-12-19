package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffGame;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GameMapper {

    List<BuffGame> findAll(@Param("name")String name);

    Integer save(BuffGame buffGame);

    Integer delete(Integer id);

    BuffGame findById(Integer id);

    Integer updateSave(BuffGame buffGame);

    List<BuffGame> selectGameByName(@Param("name")String name);

    //删除label关联
    int deleteByGameId(Integer gameId);
}
