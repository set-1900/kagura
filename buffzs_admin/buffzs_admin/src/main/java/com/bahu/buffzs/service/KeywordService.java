package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.dto.KeywordStatisticsDto;

import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/12/3
 * @description：
 */

public interface KeywordService {
    List<BuffKeyword> findBySubchannelId(String subchannelId);

}
