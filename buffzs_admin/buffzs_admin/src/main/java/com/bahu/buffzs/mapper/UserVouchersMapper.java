package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffUserVouchers;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/11/29
 * @Version: 1.0
 **/

@Mapper
public interface UserVouchersMapper {

    @Select("select * from buff_user_vouchers where id = #{id}")
    BuffUserVouchers findById(Integer id);

    @Select("select * from buff_user_vouchers")
    List<BuffUserVouchers> findAll();

    @Insert("insert into buff_user_vouchers (userId,vouchersId,createTime,type) values " +
            "(#{userId},#{vouchersId},#{createTime},#{type})")
    Integer save(BuffUserVouchers buffUserVouchers);

    @Update("update buff_user_vouchers set userId = #{userId}, vouchersId = #{vouchersId} ,type = #{type} where id = #{id}")
    Integer updateSave(BuffUserVouchers buffUserVouchers);

    @Delete("delete from buff_user_vouchers where id = #{id}")
    Integer delete(Integer id);



}
