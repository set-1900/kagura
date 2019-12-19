package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.BuffGameIcon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface HotIconMapper {
     List<BuffGameIcon> findAll() ;

    BuffGameIcon findById(Integer id);

    Integer save(BuffGameIcon buffBanner);

    Integer updateSave(BuffGameIcon buffBanner);

    Integer delete(Integer id);
}
