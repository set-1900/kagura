package com.bahu.buffzs.service.impl;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.bahu.buffzs.mapper.AdminUserMapper;
import com.bahu.buffzs.pojo.BuffAdminRole;
import com.bahu.buffzs.pojo.BuffAdminUser;
import com.bahu.buffzs.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/10/30
 * @description：
 */
@Transactional
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;


    @Override
    public BuffAdminUser findUserByName(String username) {
        BuffAdminUser user =  adminUserMapper.findUserByName(username);
        return user;
    }

    @Override
    public List<BuffAdminRole> getRoleByUserId(Integer id) {
        List<BuffAdminRole> roles = adminUserMapper.getRoleByUserId(id);
        return roles;
    }
}
