package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffApkVersion;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/11/29
 * @Version: 1.0
 **/

@Mapper
public interface ApkVersionMapper {

    @Select("select * from buff_apk_version where id = #{id}")
    BuffApkVersion findById(String id);

    @Select("select * from buff_apk_version")
    List<BuffApkVersion> findAll();

    @Select("select * from buff_apk_version where channelNum = #{channelNum}")
    BuffApkVersion findByChannelNum(String channelNum);

    @Insert("insert into buff_apk_version (name,code,version,about1," +
            "about2,about3,about4,about5,downurl,create_time,update_If_force,apkType," +
            "channelNum,updateTime) values (#{name},#{code},#{version},#{about1}," +
            "#{about2},#{about3},#{about4},#{about5},#{downurl}," +
            "#{createTime},#{updateIfForce},#{apkType},#{channelNum},#{updateTime})")
    Integer save(BuffApkVersion apkVersion);

    @Update("update buff_apk_version name = #{name}, " +
            "code = #{code}, version = #{version}, about1 = #{about1}, " +
            "about2 = #{about2}, about3 = #{about3}, about4 = #{about4}, " +
            "about5 = #{about5}, updateIfForce = #{updateIfForce}, " +
            "apkType = #{apkType}, updateTime = #{updateTime}, channelNum = #{channelNum} where id = #{id}")
    Integer updateById(BuffApkVersion apkVersion);

    @Delete("delete frmo buff_apk_version where id = #{id}")
    Integer deleteById(String id);

    @Select("select * from buff_apk_version where channelNum != '0_0_0'and channelNum != '' ")
    List<BuffApkVersion> find();

    @Update("update buff_apk_version t set t.oldDownurl = t.downurl WHERE channelNum not in ('0_0_0', '') ")
    Integer updateOldDownurl();

    @Update("update buff_apk_version t set t.oldDownurl = '' WHERE channelNum not in ('0_0_0', '') ")
    Integer deleteOldDownurl();

    @Update("update buff_apk_version set downurl = #{url}, code = code + 1 WHERE channelNum = #{channelNum} ")
    Integer updateDownurl(@Param("url") String url,@Param("channelNum") String channelNum);

    @Select("select * from buff_apk_version where channelNum != '0_0_0'and channelNum != '' ")
    List<BuffApkVersion> findChangeApk();

}
