package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.ChannelMapper;
import com.bahu.buffzs.mapper.KeywordMapper;
import com.bahu.buffzs.mapper.SubchannelMapper;
import com.bahu.buffzs.mapper.UserLoginStatisticsMapper;
import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.KeywordStatisticsDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.StatisticsDto;
import com.bahu.buffzs.pojo.dto.UserLoginStatistics;
import com.bahu.buffzs.service.UserLoginStatisticsService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Transactional
@Service
public class UserLoginStatisticsServiceImpl implements UserLoginStatisticsService {

    @Autowired
    private UserLoginStatisticsMapper userLoginStatisticsMapper;

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private SubchannelMapper subchannelMapper;

    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public List<UserLoginStatistics> findAll(String date) {
        if (date == null) {
            return userLoginStatisticsMapper.findAll();
        }
        if (date.equals("1")) {
            return userLoginStatisticsMapper.findLastMonth();
        } else {
            return userLoginStatisticsMapper.findThisYear();
        }
    }

    @Override
    public List<UserLoginStatistics> findAllByKeyword(String channel, String subchannel, String keyword) {
        return userLoginStatisticsMapper.findAllByKeyword(channel, subchannel, keyword);
    }

    /**
     * 关键字统计
     *
     * @param channelId
     * @param subchannelId
     * @param keywordId
     * @return
     */
    @Override
    public List<KeywordStatisticsDto> findByChannelNum(String channelId, String subchannelId, String keywordId, Integer data) {
        List<KeywordStatisticsDto> keywordStatisticsDtoList = null;
        if (data != null) {
            if (data == 1)
            keywordStatisticsDtoList = userLoginStatisticsMapper.findByChannelNum(channelId, subchannelId, keywordId);
        } else {
            keywordStatisticsDtoList = userLoginStatisticsMapper.findLastMonthByChannelNum(channelId, subchannelId, keywordId);
        }
        // 查询新增用户与新增账号后再统一赋值其他属性
        BuffChannel channel = null;
        if (channelId != null && !channelId.equals("")) {
            channel = channelMapper.findById(Integer.parseInt(channelId));
        }
        BuffSubchannel subchannel = subchannelMapper.findById(subchannelId);
        BuffKeyword keyword = keywordMapper.findById(keywordId);
        for (KeywordStatisticsDto kl : keywordStatisticsDtoList) {
            if (channel != null) {
                kl.setChannelId(channelId);
                kl.setCreateChannelName(channel.getName());
            }
            if (subchannel != null) {
                kl.setCreateSubchannelId(subchannelId);
                kl.setCreateSubchannelName(subchannel.getName());
            }
            if (keyword != null) {
                kl.setCreateKeywordId(keywordId);
                kl.setCreateKeywordName(keyword.getName());
            }
        }
        return keywordStatisticsDtoList;
    }


    /**
     *
     * @param name
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public PageBean<StatisticsDto> findByGameName(String name, String startTime, String endTime,Integer current, Integer size ) {
        /*PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        if (current == null) current = 1;*/
        List<StatisticsDto> list = null ;
        if (StringUtils.isNotEmpty(name)){
            list = userLoginStatisticsMapper.findByGameName2(name ,startTime ,endTime);
        }else {
            list = userLoginStatisticsMapper.findByGameName(name ,startTime ,endTime);
        }
        PageInfo<StatisticsDto> pageInfo = new PageInfo<>(list);
        PageBean<StatisticsDto> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(list);
        return pageBean ;

    }

    /**
     * 关键字统计 查询子渠道下的所有关键字
     * @param subchannelId
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<KeywordStatisticsDto> findBySubchannelId(String subchannelId, String startTime, String endTime) {
        return userLoginStatisticsMapper.findBySubchannelId(subchannelId,startTime,endTime);
    }

    /**
    * @Author: XieXiang
    * @Description: 查询所有渠道数据
    * @Date: 2019/12/16
    * @Param: [date]
    * @return: java.lang.String
    **/
    @Override
    public String findAllChannel(String date, String channelId) {
        List<UserLoginStatistics> allChannel;
        String str = "<table class=\"layui-table\">\n" +
                "<thead>\n" +
                "\t<tr>\n" +
                "\t\t<th>渠道</th>\n" +
                "\t\t<th>新增用户数量</th>\n" +
                "\t\t<th>新增账号数量</th>\n" +
                "\t\t<th>活跃用户数量</th>\n" +
                "\t\t<th>活跃账号数量</th>\n" +
                "\t\t<th>启动次数</th>\n" +
                "\t\t<th>次日活跃</th>\n" +
                "\t\t<th>七日活跃</th>\n" +
                "\t\t<th>十五日活跃</th>\n" +
                "\t\t<th>三十日活跃</th>\n" +
                "\t</tr>\n" +
                "</thead>\n" +
                "<tbody>";
        if (channelId == null) {
            allChannel = userLoginStatisticsMapper.findAllChannel(date);
        } else {
            allChannel = userLoginStatisticsMapper.findByChannelId(channelId, date);
        }
        for (UserLoginStatistics s : allChannel) {
            str += "</tr>";
            str += "<td class='name'>" + s.getName() + "</td>";
            str += "<td>" + s.getAddNewUserNumber() + "</td>";
            str += "<td>" + s.getAddNewAccountsNumber() + "</td>";
            str += "<td>" + s.getActiveUserNumber() + "</td>";
            str += "<td>" + s.getActiveAccountsNumber() + "</td>";
            str += "<td>" + s.getStartNumber() + "</td>";
            str += "<td>" + s.getNextActive() + "</td>";
            str += "<td>" + s.getSevenActive() + "</td>";
            str += "<td>" + s.getFifteenActive() + "</td>";
            str += "<td>" + s.getThirtyActive() + "</td>";
            str += "</tr>";
        }
        str += "</tbody>\n" +
                "</table>";
        return str;
    }

}
