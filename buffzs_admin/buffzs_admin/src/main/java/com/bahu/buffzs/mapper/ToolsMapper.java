package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffTools;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface ToolsMapper {
     List<BuffTools> findAll() ;

    BuffTools findById(Integer id);

    Integer save(BuffTools buffTools);

    Integer updateSave(BuffTools buffTools);

    Integer delete(Integer id);
}
