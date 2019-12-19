package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.FeedbackTypeMapper;
import com.bahu.buffzs.pojo.BuffFeedbackType;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.FeedbackTypeService;
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
public class FeedbackTypeServiceImpl implements FeedbackTypeService {
    @Autowired
    private FeedbackTypeMapper feedbackTypeMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffFeedbackType> buffFeedbackTypeList = feedbackTypeMapper.findAll();
        PageInfo<BuffFeedbackType> pageInfo = new PageInfo<>(buffFeedbackTypeList);
        PageBean<BuffFeedbackType> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffFeedbackType findById(Integer id) {
        BuffFeedbackType buffFeedbackType = feedbackTypeMapper.findById(id);
        return buffFeedbackType;
    }

    @Override
    public Integer save(BuffFeedbackType buffFeedbackType) {
        return feedbackTypeMapper.save(buffFeedbackType);
    }

    @Override
    public Integer updateSave(BuffFeedbackType buffFeedbackType) {
        return feedbackTypeMapper.updateSave(buffFeedbackType);
    }

    @Override
    public Integer delete(Integer id) {
        return feedbackTypeMapper.delete(id);
    }

    @Override
    public List<BuffFeedbackType> findAll() {
        return feedbackTypeMapper.findAll();
    }
}
