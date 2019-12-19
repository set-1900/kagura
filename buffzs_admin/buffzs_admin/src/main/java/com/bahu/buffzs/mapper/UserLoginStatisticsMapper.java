package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.dto.KeywordStatisticsDto;
import com.bahu.buffzs.pojo.dto.StatisticsDto;
import com.bahu.buffzs.pojo.dto.UserLoginStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/10/22
 * @description：
 */

@Mapper
public interface UserLoginStatisticsMapper {


    List<UserLoginStatistics> findAll();

    List<UserLoginStatistics> findLastMonth();

    List<UserLoginStatistics> findThisYear();


    List<UserLoginStatistics> findAllByKeyword(@Param("channelId") String channelId,
                                               @Param("subchannelId") String subchannelId,
                                               @Param("keyword") String keyword);

    /**
     * 关键字统计
     * @param channelId
     * @param subchannelId
     * @param keywordId
     * @return
     */
    List<KeywordStatisticsDto> findByChannelNum(@Param("channelId")String channelId
            ,@Param("subchannelId") String subchannelId
            ,@Param("keywordId") String keywordId);

    /**
     * 关键字统计
     * @param channelId
     * @param subchannelId
     * @param keywordId
     * @return
     */
    List<KeywordStatisticsDto> findLastMonthByChannelNum(@Param("channelId")String channelId
            ,@Param("subchannelId") String subchannelId
            ,@Param("keywordId") String keywordId);

    /**
     * 游戏点击统计
     * @param name
     * @param startTime
     * @param endTime
     * @return
     */
    List<StatisticsDto> findByGameName(@Param("name")String name, @Param("startTime") String startTime, @Param("endTime")String endTime);

    /**
     * 游戏点击统计
     * @param game  有值
     * @param startTime
     * @param endTime
     * @return
     */
    List<StatisticsDto> findByGameName2(@Param("game")String game, @Param("startTime") String startTime, @Param("endTime")String endTime);

    /**
     * 关键字统计 查询子渠道下的所有关键字
     * @param subchannelId
     * @param startTime
     * @param endTime
     * @return
     */
    List<KeywordStatisticsDto> findBySubchannelId(@Param("subchannelId")String subchannelId, @Param("startTime")String startTime, @Param("endTime")String endTime);

    /**
    * @Author: XieXiang
    * @Description:  根据日期查询所有渠道数据
    * @Date: 2019/12/16
    * @Param: [date]
    * @return: java.util.List<com.bahu.buffzs.pojo.dto.UserLoginStatistics>
    **/
    List<UserLoginStatistics> findAllChannel(String date);

    /**
    * @Author: XieXiang
    * @Description: 根据渠道查询相关的数据
    * @Date: 2019/12/19
    * @Param: []
    * @return: java.util.List<com.bahu.buffzs.pojo.dto.UserLoginStatistics>
    *
     * @param channelId
     * @param date*/
    List<UserLoginStatistics> findByChannelId(@Param("channelId") String channelId, @Param("date") String date);
}
