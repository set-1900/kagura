package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffPromotionPage;
import com.bahu.buffzs.pojo.dto.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description :
 * @Author : XieXiang
 * @Date : 2019/11/27
 * @Version : 1.0
 **/

@Mapper
public interface PromotionPageMapper {

    BuffPromotionPage findById(String id);

    List<BuffPromotionPage> findAll(Integer current, Integer size);

    Integer save(BuffPromotionPage buffPromotionPage);

    Integer updateById(BuffPromotionPage buffPromotionPage);

    Integer deleteById(String id);
}
