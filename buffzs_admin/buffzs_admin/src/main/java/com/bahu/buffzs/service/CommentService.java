package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffComment;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface CommentService {
    PageBean findAll(Integer current, Integer size);

    BuffComment findById(Integer id);

    Integer save(BuffComment buffComment);

    Integer updateSave(BuffComment buffComment);

    Integer delete(Integer id);
}
