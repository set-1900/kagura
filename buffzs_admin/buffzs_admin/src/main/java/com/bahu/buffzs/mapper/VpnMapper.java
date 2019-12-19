package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffVpn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface VpnMapper {
    List<BuffVpn> findAll();

    BuffVpn findById(Integer id);

    Integer save(BuffVpn buffVpn);

    Integer updateSave(BuffVpn buffVpn);

    Integer delete(Integer id);
}
