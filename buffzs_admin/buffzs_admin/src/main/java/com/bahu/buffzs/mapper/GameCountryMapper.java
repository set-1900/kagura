package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffGameCountry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameCountryMapper {

    List<BuffGameCountry> findAll();
}
