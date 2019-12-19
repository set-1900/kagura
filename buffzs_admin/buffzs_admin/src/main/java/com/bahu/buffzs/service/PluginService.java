package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffPlugins;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface PluginService {

    List<BuffPlugins> findAll();

    PageBean findAll(Integer current, Integer size);

    BuffPlugins findById(Integer id);

    Integer save(BuffPlugins buffPlugins);

    Integer updateSave(BuffPlugins buffPlugins);

    Integer delete(Integer id);
}
