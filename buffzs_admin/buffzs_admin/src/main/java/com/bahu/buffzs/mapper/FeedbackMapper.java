package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffFeedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-10-8
 **/

@Mapper
public interface FeedbackMapper {
    List<BuffFeedback> findAll() ;

    BuffFeedback findById(Integer id);

    Integer save(BuffFeedback BuffFeedback);

    Integer updateSave(BuffFeedback BuffFeedback);

    Integer delete(Integer id);
}
