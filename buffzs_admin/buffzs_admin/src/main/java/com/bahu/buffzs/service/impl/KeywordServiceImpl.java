package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.KeywordMapper;
import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.dto.KeywordStatisticsDto;
import com.bahu.buffzs.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/12/3
 * @description：
 */

@Transactional
@Service
public class KeywordServiceImpl implements KeywordService{

    @Autowired
    private KeywordMapper keywordMapper;


    @Override
    public List<BuffKeyword> findBySubchannelId(String subchannelId) {
        return keywordMapper.findBySubchannelId(subchannelId);
    }
}
