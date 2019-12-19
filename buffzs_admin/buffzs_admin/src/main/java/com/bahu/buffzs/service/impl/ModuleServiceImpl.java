package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.ModuleMapper;
import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ModuleService;
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
 * @create: 2019-09-10
 **/
@Transactional
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public PageBean findAll( Integer current ,  Integer size ,Integer moduleType) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffModule> buffModulelist = moduleMapper.findAllByModuleType(moduleType);
        PageInfo<BuffModule> pageInfo = new PageInfo<>(buffModulelist);
        PageBean<Object> pageBean = new PageBean<>();
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffModule findById(Integer id) {
        BuffModule buffModule = moduleMapper.findById(id);
        return buffModule;
    }

    @Override
    public Integer save(BuffModule buffModule) {
       return moduleMapper.save(buffModule);
    }

    @Override
    public Integer updateSave(BuffModule buffModule) {
        return moduleMapper.updateSave(buffModule);
    }


    @Override
    public Integer delete(Integer id) {
        return moduleMapper.delete(id);
    }

    @Override
    public List<BuffModule> queryByPId(Integer pid) {
        return moduleMapper.queryByPId(pid);
    }

    @Override
    public List<BuffModule> find() {
        return moduleMapper.find();
    }

    @Override
    public List<BuffModule> findByName(String name) {
        return moduleMapper.findByName(name);

    }

    /**
     * //保存到游戏模块中间表
     * @param id
     * @param module
     */
    @Override
    public void saveGameModule(Integer id, String module) {
        moduleMapper.saveGameModule(id,module);
    }

    @Override
    public List<BuffModule> findByGameId(Integer gameId) {
        List <BuffModule> buffModuleList =  moduleMapper.findByGameId(gameId);
        return buffModuleList;
    }

    @Override
    public List<BuffModule> findAll() {
        List<BuffModule> all = moduleMapper.findAll();
        return all;
    }

    @Override
    public Integer deleteByGameId(Integer gameId) {
        int a = moduleMapper.deleteByGameId(gameId);
        return a;
    }

    @Override
    public List<BuffModule> queryByPIdAndType(Integer pid, Integer type) {
        return moduleMapper.queryByPIdAndType(pid,type);
    }


}
