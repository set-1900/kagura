package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface SubchannelService {

    BuffSubchannel findById(String id);

    PageBean findAll(Integer current, Integer size);

    Integer save(BuffSubchannel subchannel);

    Integer delete(Integer id);

    Integer updateSave(BuffSubchannel subchannel);

    List<BuffSubchannel> findByChannelId(String channelId);
}
