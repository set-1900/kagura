package com.bahu.buffzs.service;


import com.bahu.buffzs.pojo.BuffGameGift;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface GameGiftService {

    PageBean findAll(Integer current, Integer size);

    BuffGameGift findById(Integer id);

    Integer save(BuffGameGift buffGameGift);

    Integer updateSave(BuffGameGift buffGameGift);

    Integer delete(Integer id);

    List<BuffGameGift> findAll();
}
