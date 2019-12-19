package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffRecommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/12/5
 * @Version: 1.0
 **/

@Mapper
public interface RecommendMapper {

    @Insert("insert into buff_recommend (phone, userId, modulId, type, timestamp, channelNum, createTime) " +
            "values " +
            "(#{phone},#{userId},#{modulId},#{type},#{timestamp},#{channelNum},#{createTime})")
    Integer save(BuffRecommend recommend);

    @Select("select * from buff_recommend")
    List<BuffRecommend> findAll();

    @Select("select * from buff_recommend where id = #{id}")
    BuffRecommend findById(String id);
}
