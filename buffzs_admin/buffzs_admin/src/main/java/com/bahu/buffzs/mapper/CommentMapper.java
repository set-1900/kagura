package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface CommentMapper {
     List<BuffComment> findAll() ;

    BuffComment findById(Integer id);

    Integer save(BuffComment buffComment);

    Integer updateSave(BuffComment buffComment);

    Integer delete(Integer id);
}
