package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffArea;
import com.bahu.buffzs.pojo.BuffUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    List<BuffUser> findAll(@Param("username") String username,@Param("phone") String phone);

    BuffUser findById(Integer id);

    Integer save(BuffUser buffUser);

    Integer updateSave(BuffUser buffUser);

    Integer delete(Integer id);

    List<BuffArea> findArea();

    List<BuffArea> findCity(@Param("name") String name);

    @Select("SELECT * FROM buff_user WHERE id = #{phone}")
    BuffUser findByPhone(@Param("phone")String phone);
}
