package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.RechargeProportionMapper;
import com.bahu.buffzs.pojo.BuffRechargeProportion;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.RechargeProportionService;
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
public class RechargeProportionServiceImpl implements RechargeProportionService {
    @Autowired
    private RechargeProportionMapper rechargeProportionMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffRechargeProportion>  buffVpnList =  rechargeProportionMapper.findAll();
        PageInfo<BuffRechargeProportion> pageInfo = new PageInfo<>(buffVpnList);
        PageBean<BuffRechargeProportion> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffRechargeProportion findById(Integer id) {
        BuffRechargeProportion buffRechargeProportion = rechargeProportionMapper.findById(id);
        return buffRechargeProportion;
    }

    @Override
    public Integer save(BuffRechargeProportion buffRechargeProportion) {
        return rechargeProportionMapper.save(buffRechargeProportion);
    }

    @Override
    public Integer updateSave(BuffRechargeProportion buffRechargeProportion) {
        return rechargeProportionMapper.updateSave(buffRechargeProportion);
    }

    @Override
    public Integer delete(Integer id) {
        return rechargeProportionMapper.delete(id);
    }
}
