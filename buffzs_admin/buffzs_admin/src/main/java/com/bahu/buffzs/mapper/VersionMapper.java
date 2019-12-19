package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffApkVersion;
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
public interface VersionMapper {
     List<BuffApkVersion> findAll() ;

    BuffApkVersion findById(Integer id);

    Integer save(BuffApkVersion buffApkVersion);

    Integer updateSave(BuffApkVersion buffApkVersion);

    Integer delete(Integer id);
}
