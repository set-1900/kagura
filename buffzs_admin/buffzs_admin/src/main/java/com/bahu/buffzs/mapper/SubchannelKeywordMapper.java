package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffSubchannelKeyword;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/12/3
 * @Version: 1.0
 **/

@Mapper
public interface SubchannelKeywordMapper {

    @Select("select * from buff_subchannel_keyword where keywordId = #{keywordId}")
    BuffSubchannelKeyword findByKeywordId(String keywordId);

    @Insert("insert into buff_subchannel_keyword (subchannelId, keywordId, createTime) " +
            "values" +
            "(#{subchannelId}, #{keywordId}, #{createTime})")
    Integer save(BuffSubchannelKeyword subchannelKeyword);

    @Select("select * from buff_subchannel_keyword where subchannelId = #{subchannelId} and keywordId = #{keywordId}")
    BuffSubchannelKeyword findBySubchannelIdAndKeywordId (@Param("subchannelId") String subchannelId,@Param("keywordId") String keywordId);
}
