package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffChannel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface ChannelMapper {
     List<BuffChannel> findAll() ;

    BuffChannel findById(Integer id);

    Integer save(BuffChannel buffChannel);

    Integer updateSave(BuffChannel buffChannel);

    Integer delete(Integer id);
}
