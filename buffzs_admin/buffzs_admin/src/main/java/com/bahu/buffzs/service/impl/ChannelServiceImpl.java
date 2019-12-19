package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.ChannelMapper;
import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.ChannelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelMapper channelMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffChannel> list = channelMapper.findAll();
        PageInfo<BuffChannel> pageInfo = new PageInfo<>(list);
        PageBean<BuffChannel> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffChannel findById(Integer id) {
        BuffChannel buffChannel = channelMapper.findById(id);
        return buffChannel;
    }

    @Override
    public Integer save(BuffChannel buffChannel) {
        buffChannel.setCreateTime(new Date());
        return channelMapper.save(buffChannel);
    }


    @Override
    public Integer updateSave(BuffChannel buffChannel) {
        return channelMapper.updateSave(buffChannel);
    }

    @Override
    public Integer delete(Integer id) {
        return channelMapper.delete(id);
    }

    @Override
    public List<BuffChannel> findAllChannel() {
        return channelMapper.findAll();
    }
}
