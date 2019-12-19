package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffGameGenres;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface GameGenresMapper {
     List<BuffGameGenres> findAll() ;

    BuffGameGenres findById(Integer id);

    Integer save(BuffGameGenres buffGameGenres);

    Integer updateSave(BuffGameGenres buffGameGenres);

    Integer delete(Integer id);
}
