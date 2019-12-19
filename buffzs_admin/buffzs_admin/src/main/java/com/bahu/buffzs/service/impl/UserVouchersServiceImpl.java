package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.UserVouchersMapper;
import com.bahu.buffzs.pojo.BuffUserVouchers;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.UserVouchersService;
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
public class UserVouchersServiceImpl implements UserVouchersService {
    @Autowired
    private UserVouchersMapper userVouchersMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffUserVouchers> buffVpnList = userVouchersMapper.findAll();
        PageInfo<BuffUserVouchers> pageInfo = new PageInfo<>(buffVpnList);
        PageBean<BuffUserVouchers> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffUserVouchers findById(Integer id) {
        BuffUserVouchers buffUserVouchers = userVouchersMapper.findById(id);
        return buffUserVouchers;
    }

    @Override
    public Integer save(BuffUserVouchers buffUserVouchers) {
        buffUserVouchers.setCreateTime(new Date());
        return userVouchersMapper.save(buffUserVouchers);
    }

    @Override
    public Integer updateSave(BuffUserVouchers buffUserVouchers) {
        return userVouchersMapper.updateSave(buffUserVouchers);
    }

    @Override
    public Integer delete(Integer id) {
        return userVouchersMapper.delete(id);
    }
}
