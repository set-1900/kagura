package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.GameServerMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffGameServer;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.GameServerService;
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
public class GameServerServiceImpl implements GameServerService {
    @Autowired
    private GameServerMapper gameServerMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffGameServer> buffApkVersionList = gameServerMapper.findAll();
        PageInfo<BuffGameServer> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffGameServer> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffGameServer findById(Integer id) {
        BuffGameServer buffGameServer = gameServerMapper.findById(id);
        return buffGameServer;
    }

    @Override
    public Integer save(BuffGameServer buffGameServer) {
        return gameServerMapper.save(buffGameServer);
    }

    @Override
    public Integer updateSave(BuffGameServer buffGameServer) {
        return gameServerMapper.updateSave(buffGameServer);
    }

    @Override
    public Integer delete(Integer id) {
        return gameServerMapper.delete(id);
    }
}
