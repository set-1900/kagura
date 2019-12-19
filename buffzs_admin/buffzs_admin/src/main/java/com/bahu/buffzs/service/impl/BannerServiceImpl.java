package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.BannerMapper;
import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.util.FileUtil;
import com.bahu.buffzs.service.BannerService;
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
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;


    @Override
    public PageBean findAll(Integer current, Integer size ,BuffBanner buffBanner) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffBanner>  buffBannerList =  bannerMapper.findAll(buffBanner);
        PageInfo<BuffBanner> pageInfo = new PageInfo<>(buffBannerList);
        PageBean<BuffBanner> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffBanner findById(Integer id) {
        BuffBanner buffBanner = bannerMapper.findById(id);
        return buffBanner;
    }

    @Override
    public Integer save(BuffBanner buffBanner) {
        return bannerMapper.save(buffBanner);
    }

    @Override
    public Integer updateSave(BuffBanner buffBanner) {
        return bannerMapper.updateSave(buffBanner);
    }

    @Override
    public Integer delete(Integer id) {
        BuffBanner banner = bannerMapper.findById(id);
        String imageUrl = banner.getImageUrl();
        FileUtil.delFile(imageUrl);
        return bannerMapper.delete(id);

    }
}
