package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffGameGenres;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenresMapper {

    List<BuffGameGenres> findAll();

}
