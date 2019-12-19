package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.BannerMapper;
import com.bahu.buffzs.mapper.ConsultionMapper;
import com.bahu.buffzs.mapper.GameMapper;
import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.BuffConsultion;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.BannerService;
import com.bahu.buffzs.service.ConsultionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Transactional
@Service
public class ConsultionServiceImpl implements ConsultionService {
    @Autowired
    private ConsultionMapper consultionMapper;
    @Autowired
    private GameMapper gameMapper;

    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffConsultion>  buffBannerList =  consultionMapper.findAll();
        PageInfo<BuffConsultion> pageInfo = new PageInfo<>(buffBannerList);
        PageBean<BuffConsultion> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffConsultion findById(Integer id) {
        BuffConsultion buffBanner = consultionMapper.findById(id);
        return buffBanner;
    }

    @Override
    public Integer save(BuffConsultion buffConsultion) {
        buffConsultion.setIcon(gameMapper.findById(buffConsultion.getGameId()).getIcon());
        buffConsultion.setTime(new Date());
        buffConsultion.setAmountRead(0);
        return consultionMapper.save(buffConsultion);
    }

    @Override
    public Integer updateSave(BuffConsultion buffConsultion) {
        return consultionMapper.updateSave(buffConsultion);
    }

    @Override
    public Integer delete(Integer id) {
        return consultionMapper.delete(id);

    }
}
