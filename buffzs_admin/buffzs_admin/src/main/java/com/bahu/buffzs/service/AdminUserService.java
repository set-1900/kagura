package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffAdminRole;
import com.bahu.buffzs.pojo.BuffAdminUser;

import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/10/30
 * @description：
 */
public interface AdminUserService {

    //获取用户
    BuffAdminUser findUserByName(String username);

    //获取权限
    List<BuffAdminRole> getRoleByUserId(Integer id);
}
