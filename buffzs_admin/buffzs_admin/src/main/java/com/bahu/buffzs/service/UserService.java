package com.bahu.buffzs.service;


import com.bahu.buffzs.pojo.BuffAdminRole;
import com.bahu.buffzs.pojo.BuffAdminUser;
import com.bahu.buffzs.pojo.BuffArea;
import com.bahu.buffzs.pojo.BuffUser;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;

import java.util.List;

public interface UserService {

    PageBean findAll(Integer current, Integer size ,String username,String phone);

    Integer save(BuffUser buffUser);

    BuffUser findById(Integer id);

    Integer updateSave(BuffUser buffUser);

    Integer delete(Integer id);

    Result findArea();

    Result findCity(String name);

}
