package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.GameGenresMapper;
import com.bahu.buffzs.mapper.VersionMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffGameGenres;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.GameGenresService;
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
public class GameGenresServiceImpl implements GameGenresService {
    @Autowired
    private GameGenresMapper gameGenresMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffGameGenres>  buffGameGenres =  gameGenresMapper.findAll();
        PageInfo<BuffGameGenres> pageInfo = new PageInfo<>(buffGameGenres);
        PageBean<BuffGameGenres> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffGameGenres findById(Integer id) {
        BuffGameGenres BuffGameGenres = gameGenresMapper.findById(id);
        return BuffGameGenres;
    }

    @Override
    public Integer save(BuffGameGenres buffGameGenres) {
        return gameGenresMapper.save(buffGameGenres);
    }

    @Override
    public Integer updateSave(BuffGameGenres buffGameGenres) {
        return gameGenresMapper.updateSave(buffGameGenres);
    }

    @Override
    public Integer delete(Integer id) {
        return gameGenresMapper.delete(id);
    }
}
