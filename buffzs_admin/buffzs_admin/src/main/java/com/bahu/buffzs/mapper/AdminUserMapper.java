package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffAdminRole;
import com.bahu.buffzs.pojo.BuffAdminUser;
import com.bahu.buffzs.pojo.BuffBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface AdminUserMapper {

    @Select("select * from buff_admin_user where username = #{username}")
    BuffAdminUser findUserByName(String username);

    @Select("select * from buff_admin_role where id = #{id}")
    List<BuffAdminRole> getRoleByUserId(Integer id);
}
