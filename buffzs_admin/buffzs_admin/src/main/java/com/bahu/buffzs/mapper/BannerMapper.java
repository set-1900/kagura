package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffBanner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface BannerMapper {
     List<BuffBanner> findAll(BuffBanner buffBanner) ;

    BuffBanner findById(Integer id);

    Integer save(BuffBanner buffBanner);

    Integer updateSave(BuffBanner buffBanner);

    Integer delete(Integer id);
}
