package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.UserMapper;
import com.bahu.buffzs.pojo.BuffAdminRole;
import com.bahu.buffzs.pojo.BuffAdminUser;
import com.bahu.buffzs.pojo.BuffArea;
import com.bahu.buffzs.pojo.BuffUser;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public PageBean findAll(Integer current, Integer size,String username,String phone) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffUser> buffUserList = userMapper.findAll(username , phone);
        PageInfo<BuffUser> pageInfo = new PageInfo<>(buffUserList);
        PageBean<BuffUser> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffUser findById(Integer id) {
        BuffUser buffUser = userMapper.findById(id);
        return buffUser;
    }

    @Override
    public Integer save(BuffUser buffUser) {
        buffUser.setPraise(0);
        buffUser.setCreateTime(new Date());
        buffUser.setUpdateTime(new Date());
        return userMapper.save(buffUser);
    }

    @Override
    public Integer updateSave(BuffUser buffUser) {
        return userMapper.updateSave(buffUser);
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public Result findArea() {
        List<BuffArea> areaList = userMapper.findArea();
        if (areaList.size() > 0) {
            return Result.success(areaList);
        } else {
            return  Result.error();
        }
    }

    @Override
    public Result findCity(String name) {
        List<BuffArea> areaList = userMapper.findCity(name);
        if (areaList.size() > 0) {
            return Result.success(areaList);
        } else {
            return Result.error();
        }
    }


}

