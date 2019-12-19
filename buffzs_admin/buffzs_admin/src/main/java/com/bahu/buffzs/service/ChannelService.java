package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface ChannelService {
    PageBean findAll(Integer current, Integer size);

    BuffChannel findById(Integer id);

    Integer save(BuffChannel buffChannel);

    Integer updateSave(BuffChannel buffChannel);

    Integer delete(Integer id);

    List<BuffChannel> findAllChannel();
}
