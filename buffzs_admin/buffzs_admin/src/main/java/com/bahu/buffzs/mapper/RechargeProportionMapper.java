package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffRechargeProportion;
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
public interface RechargeProportionMapper {

    @Select("select * from buff_recharge_proportion where id = #{id}")
    BuffRechargeProportion findById(Integer id);

    @Select("select * from buff_recharge_proportion")
    List<BuffRechargeProportion> findAll();

    @Insert("insert into buff_recharge_proportion (price,systemMoney,type) values " +
            "(#{price},#{systemMoney},#{type})")
    Integer save(BuffRechargeProportion buffRechargeProportion);

    @Update("update buff_recharge_proportion set price = #{price}, " +
            "systemMoney = #{systemMoney}, type = #{type} where id = #{id}")
    Integer updateSave(BuffRechargeProportion buffRechargeProportion);

    @Delete("delete from buff_recharge_proportion where id = #{id}")
    Integer delete(Integer id);



}
