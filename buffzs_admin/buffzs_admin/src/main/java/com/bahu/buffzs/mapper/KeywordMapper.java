package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffKeyword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeywordMapper {

    BuffKeyword findById(@Param("id") String id);

    BuffKeyword findByName(String name);

    Integer save(BuffKeyword keyword);

    //根据子渠道id 查询关键字列表
    List<BuffKeyword> findBySubchannelId(@Param("subchannelId") String subchannelId);
}
