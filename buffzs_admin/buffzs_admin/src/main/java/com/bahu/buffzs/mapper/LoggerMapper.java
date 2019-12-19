package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author： Mr.Baron
 * @date： 2019/11/29
 * @description：
 */

@Mapper
public interface LoggerMapper {

    Integer save(BuffLog buffLog);

    //查询上一条记录
    BuffLog findBy(@Param("modulId") String modulId, @Param("type") String type, @Param("gameId") Integer gameId);
}
