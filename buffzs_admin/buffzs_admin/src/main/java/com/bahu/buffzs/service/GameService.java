package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffGame;
import com.bahu.buffzs.pojo.dto.PageBean;


import java.util.List;

public interface GameService {

    PageBean findAll(Integer current, Integer size , String name);

    Integer save(BuffGame buffGame);

    Integer delete(Integer id);

    BuffGame findById(Integer id);

    Integer updateSave(BuffGame buffGame);

    List<BuffGame> selectGameByName(BuffGame buffGame);

    int deleteByGameId(Integer gameId);
}
