package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffCircleOfFriends;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface FriendCircleService {
    PageBean findAll(Integer current, Integer size);

    BuffCircleOfFriends findById(Integer id);

    Integer save(BuffCircleOfFriends buffCircleOfFriends);

    Integer updateSave(BuffCircleOfFriends buffCircleOfFriends);

    Integer delete(Integer id);
}
