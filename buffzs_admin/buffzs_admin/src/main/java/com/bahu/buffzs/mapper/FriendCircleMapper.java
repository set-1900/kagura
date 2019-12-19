package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffCircleOfFriends;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface FriendCircleMapper {
    List<BuffCircleOfFriends> findAll();

    BuffCircleOfFriends findById(Integer id);

    Integer save(BuffCircleOfFriends buffCircleOfFriends);

    Integer updateSave(BuffCircleOfFriends buffCircleOfFriends);

    Integer delete(Integer id);
}
