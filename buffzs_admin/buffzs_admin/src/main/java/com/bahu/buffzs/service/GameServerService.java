package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffGameServer;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface GameServerService {
    PageBean findAll(Integer current, Integer size);

    BuffGameServer findById(Integer id);

    Integer save(BuffGameServer buffGameServer);

    Integer updateSave(BuffGameServer buffGameServer);

    Integer delete(Integer id);
}
