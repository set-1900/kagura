package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/
public interface ModuleService {
    //查询所有模块
    PageBean findAll(Integer current , Integer size ,Integer moduleType);

    //通过id查询一个
    BuffModule findById(Integer id);

    //增加
    Integer save(BuffModule buffModule);

    //修改
    Integer updateSave(BuffModule buffModule);

    Integer delete(Integer id);

    //通过上级id
    List<BuffModule> queryByPId(Integer pid);

    //查询所有
    List<BuffModule> find();


    List<BuffModule> findByName(String name);

    //保存到游戏模块中间表
    void saveGameModule(Integer id, String module);


    List<BuffModule> findByGameId(Integer id);

    List<BuffModule> findAll();

    Integer deleteByGameId(Integer id);


    List<BuffModule> queryByPIdAndType(Integer pid, Integer type);
}
