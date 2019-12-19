package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffPlugins;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PluginMapper {

    List<BuffPlugins> findAll();
}
