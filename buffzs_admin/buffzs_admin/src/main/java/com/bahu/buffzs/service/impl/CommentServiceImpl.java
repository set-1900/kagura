package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.CommentMapper;
import com.bahu.buffzs.mapper.VersionMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffComment;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.CommentService;
import com.bahu.buffzs.service.VersionService;
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
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffComment>  buffApkVersionList =  commentMapper.findAll();
        PageInfo<BuffComment> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffComment> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffComment findById(Integer id) {
        BuffComment buffComment = commentMapper.findById(id);
        return buffComment;
    }

    @Override
    public Integer save(BuffComment buffComment) {
        buffComment.setLaud(0);
        buffComment.setAddTime(new Date());
        return commentMapper.save(buffComment);
    }

    @Override
    public Integer updateSave(BuffComment buffComment) {
        return commentMapper.updateSave(buffComment);
    }

    @Override
    public Integer delete(Integer id) {
        return commentMapper.delete(id);
    }
}
