package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffFeedback;
import com.bahu.buffzs.pojo.BuffFeedbackType;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface FeedbackTypeService {
    PageBean findAll(Integer current, Integer size);

    BuffFeedbackType findById(Integer id);

    Integer save(BuffFeedbackType buffFeedbackType);

    Integer updateSave(BuffFeedbackType buffFeedbackType);

    Integer delete(Integer id);

    List<BuffFeedbackType> findAll();
}
