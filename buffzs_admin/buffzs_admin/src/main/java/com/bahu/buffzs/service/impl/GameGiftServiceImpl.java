package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.GameGiftMapper;
import com.bahu.buffzs.mapper.GameMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffGame;
import com.bahu.buffzs.pojo.BuffGameGift;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.GameGiftService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/
@Transactional
@Service
public class GameGiftServiceImpl implements GameGiftService {

    @Autowired
    private GameGiftMapper gameGiftMapper;

    @Autowired
    private GameMapper gameMapper;

    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffGameGift>  buffApkVersionList =  gameGiftMapper.findAll();
        PageInfo<BuffGameGift> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffGameGift> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffGameGift findById(Integer id) {
        BuffGameGift buffGameGift = gameGiftMapper.findById(id);
        return buffGameGift;
    }

    @Override
    public Integer save(BuffGameGift buffGameGift) {
        BuffGame game = gameMapper.findById(buffGameGift.getGameId());
        buffGameGift.setGameName(game.getName());
        buffGameGift.setAddTime(new Date());
        buffGameGift.setUniqueId(UUID.randomUUID().toString());
        return gameGiftMapper.save(buffGameGift);
    }

    @Override
    public Integer updateSave(BuffGameGift buffGameGift) {
        return gameGiftMapper.updateSave(buffGameGift);
    }

    @Override
    public Integer delete(Integer id) {
        return gameGiftMapper.delete(id);
    }

    @Override
    public List<BuffGameGift> findAll() {
        return gameGiftMapper.findAll();
    }
}
