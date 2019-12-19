package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.BuffConsultion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-26
 **/

@Mapper
public interface ConsultionMapper {
    List<BuffConsultion> findAll();

    BuffConsultion findById(Integer id);

    Integer save(BuffConsultion buffConsultion);

    Integer updateSave(BuffConsultion buffConsultion);

    Integer delete(Integer id);
}
