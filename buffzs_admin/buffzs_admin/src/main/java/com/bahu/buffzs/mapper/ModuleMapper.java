package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/

@Mapper
public interface ModuleMapper {
    //查询所有

    /**
    * @Description:
    * @Param: [type 模块;类型, pid  上级id]
    * @return: java.util.List<com.bahu.buffzs.pojo.BuffModule>
    * @Author: Mr.Baron
    * @Date: 2019/9/10
    */
    List<BuffModule> findAll(@Param("type") Integer type);

    List<BuffModule> findAll();

    BuffModule findById(Integer id);

    //增加
    Integer save(BuffModule buffModule);

    //修改
    Integer updateSave(BuffModule buffModule);

    //删除
    Integer delete(Integer id);

    List<BuffModule> queryByPId(Integer pid);


    List<BuffModule> find();


    List<BuffModule> findByName(@Param("name") String name);

    //保存到游戏模块中间表
    void saveGameModule(@Param("gameId") Integer gameId, @Param("moduleId")String moduleId);


    List<BuffModule> findByGameId(Integer id);

    int deleteByGameId(Integer gameId);


    List<BuffModule> queryByPIdAndType(@Param("pid")Integer pid,@Param("type") Integer type);


    List<BuffModule> findAllByModuleType(@Param("moduleType") Integer moduleType);
}
