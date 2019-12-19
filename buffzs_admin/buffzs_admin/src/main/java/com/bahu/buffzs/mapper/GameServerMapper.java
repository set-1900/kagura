package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffGameServer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-10-17
 **/

@Mapper
public interface GameServerMapper {
    List<BuffGameServer> findAll();

    BuffGameServer findById(Integer id);

    Integer save(BuffGameServer buffGameServer);

    Integer updateSave(BuffGameServer buffGameServer);

    Integer delete(Integer id);
}
