package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.VouchersMapper;
import com.bahu.buffzs.pojo.BuffVouchers;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.VouchersService;
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
public class VouchersServiceImpl implements VouchersService {
    @Autowired
    private VouchersMapper vouchersMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffVouchers>  buffVpnList =  vouchersMapper.findAll();
        PageInfo<BuffVouchers> pageInfo = new PageInfo<>(buffVpnList);
        PageBean<BuffVouchers> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffVouchers findById(Integer id) {
        BuffVouchers buffVouchers = vouchersMapper.findById(id);
        return buffVouchers;
    }

    @Override
    public Integer save(BuffVouchers buffVouchers) {
        buffVouchers.setCreateTime(new Date());
        return vouchersMapper.save(buffVouchers);
    }

    @Override
    public Integer updateSave(BuffVouchers buffVouchers) {
        return vouchersMapper.updateSave(buffVouchers);
    }

    @Override
    public Integer delete(Integer id) {
        return vouchersMapper.delete(id);
    }
}
