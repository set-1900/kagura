package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffFeedbackType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-10-8
 **/

@Mapper
public interface FeedbackTypeMapper {
    List<BuffFeedbackType> findAll();

    BuffFeedbackType findById(Integer id);

    Integer save(BuffFeedbackType buffFeedbackType);

    Integer updateSave(BuffFeedbackType buffFeedbackType);

    Integer delete(Integer id);
}
