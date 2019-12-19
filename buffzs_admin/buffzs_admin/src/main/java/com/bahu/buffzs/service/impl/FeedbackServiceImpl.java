package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.FeedbackMapper;
import com.bahu.buffzs.pojo.BuffFeedback;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.FeedbackService;
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
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffFeedback> buffFeedbackList = feedbackMapper.findAll();
        PageInfo<BuffFeedback> pageInfo = new PageInfo<>(buffFeedbackList);
        PageBean<BuffFeedback> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffFeedback findById(Integer id) {
        BuffFeedback buffFeedback = feedbackMapper.findById(id);
        return buffFeedback;
    }

    @Override
    public Integer save(BuffFeedback buffFeedback) {
        return feedbackMapper.save(buffFeedback);
    }

    @Override
    public Integer updateSave(BuffFeedback buffFeedback) {
        return feedbackMapper.updateSave(buffFeedback);
    }

    @Override
    public Integer delete(Integer id) {
        return feedbackMapper.delete(id);
    }
}
