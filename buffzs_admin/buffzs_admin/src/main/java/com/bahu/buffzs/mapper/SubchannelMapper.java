package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubchannelMapper {

    BuffSubchannel findById(String id);

    List<BuffSubchannel> findAll(Integer current, Integer size);

    Integer save(BuffSubchannel subchannel);

    Integer delete(Integer id);

    Integer updateById(BuffSubchannel subchannel);

    List<BuffSubchannel> findByChannelId(@Param("channelId") String channelId);

    BuffSubchannel findByUrl(String url);
}
