package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.ChannelMapper;
import com.bahu.buffzs.mapper.KeywordMapper;
import com.bahu.buffzs.mapper.LoggerMapper;
import com.bahu.buffzs.mapper.SubchannelMapper;
import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.BuffLog;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/11/29
 * @description：
 */

@Transactional
@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    private LoggerMapper loggerMapper;

    @Autowired
    private SubchannelMapper subchannelMapper;

    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public Integer save(String url) {
        int index = url.indexOf("?");
        //子渠道推广链接
        String subchannelUrl = url.substring(0, url.lastIndexOf("/"));
        subchannelUrl = subchannelUrl.substring(0, subchannelUrl.lastIndexOf("/"));
        //关键字名称
        String keywordName = url.substring(index + 1, url.length());

        BuffSubchannel subchannel = subchannelMapper.findByUrl(subchannelUrl);
        BuffKeyword keyword = keywordMapper.findByName(keywordName);

        BuffLog buffLog = new BuffLog();
        buffLog.setChannelId(subchannel.getChannelId().toString());
        buffLog.setSubchannelId(subchannel.getId().toString());
        buffLog.setKeywordId(keyword.getId().toString());
        buffLog.setCreateTime(new Date());
        // 类型1游戏2下载游戏3banner4首页广告页5推广页下载按钮
        buffLog.setType(5 + "");
        return loggerMapper.save(buffLog);
    }
}
