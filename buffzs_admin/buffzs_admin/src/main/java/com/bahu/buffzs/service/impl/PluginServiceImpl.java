package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.PluginMapper;
import com.bahu.buffzs.pojo.BuffPlugins;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.PluginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-16
 **/

@Transactional
@Service
public class PluginServiceImpl implements PluginService {

    @Autowired
    private PluginMapper pluginMapper;

    @Override
    public List<BuffPlugins> findAll() {
        return pluginMapper.findAll();
    }


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffPlugins>  buffApkVersionList =  pluginMapper.findAll();
        PageInfo<BuffPlugins> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffPlugins> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffPlugins findById(Integer id) {
        return null;
    }

    @Override
    public Integer save(BuffPlugins buffPlugins) {
        return null;
    }

    @Override
    public Integer updateSave(BuffPlugins buffPlugins) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }
}
