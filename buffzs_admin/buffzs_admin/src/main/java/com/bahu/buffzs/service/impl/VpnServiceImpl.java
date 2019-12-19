package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.VersionMapper;
import com.bahu.buffzs.mapper.VpnMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffVpn;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.VersionService;
import com.bahu.buffzs.service.VpnService;
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
public class VpnServiceImpl implements VpnService {
    @Autowired
    private VpnMapper vpnMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffVpn>  buffVpnList =  vpnMapper.findAll();
        PageInfo<BuffVpn> pageInfo = new PageInfo<>(buffVpnList);
        PageBean<BuffVpn> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffVpn findById(Integer id) {
        BuffVpn buffVpn = vpnMapper.findById(id);
        return buffVpn;
    }

    @Override
    public Integer save(BuffVpn buffVpn) {
        return vpnMapper.save(buffVpn);
    }

    @Override
    public Integer updateSave(BuffVpn buffVpn) {
        return vpnMapper.updateSave(buffVpn);
    }

    @Override
    public Integer delete(Integer id) {
        return vpnMapper.delete(id);
    }
}
