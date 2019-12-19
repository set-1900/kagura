package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.dto.KeywordStatisticsDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.StatisticsDto;
import com.bahu.buffzs.pojo.dto.UserLoginStatistics;

import java.util.List;
import java.util.Map;

public interface UserLoginStatisticsService {
    List<UserLoginStatistics> findAll(String date);


    List<UserLoginStatistics> findAllByKeyword(String channel,String subchannel,String keyword);

    /**
     * 关键字统计
     * @param channelId
     * @param subchannelId
     * @param keywordId
     * @return
     */
    // List<KeywordStatisticsDto> findByChannelNum(String channelId, String subchannelId, String keywordId);

    /**
     * 游戏统计
     * @param gameId
     * @param startTime
     * @param endTime
     * @return
     */
    PageBean<StatisticsDto> findByGameName(String gameId, String startTime, String endTime , Integer current, Integer size );

    /**
     * 关键字统计
     * @param channelId
     * @param subchannelId
     * @param keywordId
     * @return
     */
    List<KeywordStatisticsDto> findByChannelNum(String channelId, String subchannelId, String keywordId, Integer data);

    /**
     * 关键字统计 查询子渠道下的所有关键字
     * @param subchannelId
     * @param startTime
     * @param endTime
     * @return
     */
    List<KeywordStatisticsDto> findBySubchannelId(String subchannelId, String startTime, String endTime);

    String findAllChannel(String date, String channelId);
}
