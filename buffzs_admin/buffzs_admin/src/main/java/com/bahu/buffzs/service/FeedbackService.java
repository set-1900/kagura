package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffFeedback;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface FeedbackService {
    PageBean findAll(Integer current, Integer size);

    BuffFeedback findById(Integer id);

    Integer save(BuffFeedback buffFeedback);

    Integer updateSave(BuffFeedback buffFeedback);

    Integer delete(Integer id);
}
