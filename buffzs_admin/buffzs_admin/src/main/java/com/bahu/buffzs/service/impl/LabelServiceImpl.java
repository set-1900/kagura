package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.LabelMapper;
import com.bahu.buffzs.pojo.BuffLabel;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.LabelService;
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
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;


    @Override
    public List<BuffLabel> findAll() {
        return labelMapper.findAll();
    }

    @Override
    public Integer save(Integer gameid, String labelid) {
        return  labelMapper.save(gameid,labelid);
    }


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffLabel> buffApkVersionList = labelMapper.findAll();
        PageInfo<BuffLabel> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffLabel> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffLabel findById(Integer id) {
        BuffLabel buffLabel = labelMapper.findById(id);
        return buffLabel;
    }

    @Override
    public Integer save(BuffLabel buffLabel) {
        return labelMapper.saveLabel(buffLabel);
    }

    @Override
    public Integer updateSave(BuffLabel buffLabel) {
        return labelMapper.updateSave(buffLabel);
    }

    @Override
    public Integer delete(Integer id) {
        Integer a = labelMapper.deleteGame(id);
        return labelMapper.delete(id);
    }
}
