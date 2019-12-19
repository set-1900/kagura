package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.SubchannelMapper;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.SubchannelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SubchannelServiceImpl implements SubchannelService {

    @Autowired
    SubchannelMapper subchannelMapper;

    @Override
    public BuffSubchannel findById(String id) {
        return subchannelMapper.findById(id);
    }

    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 :current, size == null ? 10 : size);
        List<BuffSubchannel> subchannelList = subchannelMapper.findAll(current, size);
        PageInfo<BuffSubchannel> pageInfo = new PageInfo<>(subchannelList);
        PageBean<BuffSubchannel> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public Integer save(BuffSubchannel subchannel) {
        return subchannelMapper.save(subchannel);
    }

    @Override
    public Integer delete(Integer id) {
        return subchannelMapper.delete(id);
    }

    @Override
    public Integer updateSave(BuffSubchannel subchannel) {
        return subchannelMapper.updateById(subchannel);
    }

    @Override
    public List<BuffSubchannel> findByChannelId(String channelId) {
        return subchannelMapper.findByChannelId(channelId);
    }
}
