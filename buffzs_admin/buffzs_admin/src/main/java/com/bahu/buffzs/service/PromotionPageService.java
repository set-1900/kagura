package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffPromotionPage;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;

/**
 * @Description :
 * @Author : XieXiang
 * @Date : 2019/11/27
 * @Version : 1.0
 **/

public interface PromotionPageService {

    BuffPromotionPage findById(String id);

    PageBean findAll(Integer current, Integer size);

    Integer save(BuffPromotionPageDto buffPromotionPageDto);

    Integer updateById(BuffPromotionPage buffPromotionPage);

    Integer delete(String id);
}
