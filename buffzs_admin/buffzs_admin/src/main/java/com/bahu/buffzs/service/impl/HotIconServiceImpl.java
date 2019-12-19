package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.HotIconMapper;
import com.bahu.buffzs.pojo.BuffGameIcon;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.util.FileUtil;
import com.bahu.buffzs.service.HotIconService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
public class HotIconServiceImpl implements HotIconService {
    @Autowired
    private HotIconMapper hotIconMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffGameIcon>  buffBannerList =  hotIconMapper.findAll();
        PageInfo<BuffGameIcon> pageInfo = new PageInfo<>(buffBannerList);
        PageBean<BuffGameIcon> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffGameIcon findById(Integer id) {
        BuffGameIcon buffBanner = hotIconMapper.findById(id);
        return buffBanner;
    }

    @Override
    public Integer save(BuffGameIcon buffGameIcon) {
        return hotIconMapper.save(buffGameIcon);
    }

    @Override
    public Integer updateSave(BuffGameIcon buffGameIcon) {
        String iconUrl = buffGameIcon.getIconUrl();
        BuffGameIcon byId = hotIconMapper.findById(buffGameIcon.getId());
        if (!iconUrl.equals(byId.getIconUrl())){
            FileUtil.delFile(byId.getIconUrl());
        }
        return hotIconMapper.updateSave(buffGameIcon);
    }

    @Override
    public Integer delete(Integer id) {
        BuffGameIcon buffGameIcon = hotIconMapper.findById(id);
        String iconUrl = buffGameIcon.getIconUrl();
        if (StringUtils.isNotEmpty(iconUrl)){
            FileUtil.delFile(iconUrl);
        }
        return hotIconMapper.delete(id);

    }

    @Override
    public List<BuffGameIcon> findAll() {
        List<BuffGameIcon>  buffBannerList =  hotIconMapper.findAll();
        return buffBannerList;
    }
}
