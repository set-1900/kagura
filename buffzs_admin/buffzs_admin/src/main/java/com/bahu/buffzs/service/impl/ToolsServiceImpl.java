package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.ToolsMapper;
import com.bahu.buffzs.mapper.VersionMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffTools;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.ToolsService;
import com.bahu.buffzs.service.VersionService;
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
 * @create: 2019-09-11
 **/

@Transactional
@Service
public class ToolsServiceImpl implements ToolsService {
    @Autowired
    private ToolsMapper toolsMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffTools>  buffTools =  toolsMapper.findAll();
        PageInfo<BuffTools> pageInfo = new PageInfo<>(buffTools);
        PageBean<BuffTools> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffTools findById(Integer id) {
        BuffTools buffTools = toolsMapper.findById(id);
        return buffTools;
    }

    @Override
    public Integer save(BuffTools buffTools) {
        return toolsMapper.save(buffTools);
    }

    @Override
    public Integer updateSave(BuffTools buffTools) {
        return toolsMapper.updateSave(buffTools);
    }

    @Override
    public Integer delete(Integer id) {
        return toolsMapper.delete(id);
    }
}
