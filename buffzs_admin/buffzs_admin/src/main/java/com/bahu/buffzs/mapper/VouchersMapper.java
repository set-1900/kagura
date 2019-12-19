package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffVouchers;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/11/29
 * @Version: 1.0
 **/

@Mapper
public interface VouchersMapper {

    @Select("select * from buff_vouchers where id = #{id}")
    BuffVouchers findById(Integer id);

    @Select("select * from buff_vouchers")
    List<BuffVouchers> findAll();

    @Insert("insert into buff_vouchers (value,vouchersExplain,money,sum,surplusSum,expirationTime,createTime,creator) values " +
            "(#{value},#{vouchersExplain},#{money},#{sum},#{surplusSum},#{expirationTime},#{createTime},#{creator})")
    Integer save(BuffVouchers buffVouchers);

    @Update("update buff_vouchers set value = #{value}, " +
            "vouchersExplain = #{vouchersExplain}, money = #{money}, sum = #{sum}, expirationTime = #{expirationTime}, " +
            "creator = #{creator} where id = #{id}")
    Integer updateSave(BuffVouchers buffVouchers);

    @Delete("delete from buff_vouchers where id = #{id}")
    Integer delete(Integer id);



}
