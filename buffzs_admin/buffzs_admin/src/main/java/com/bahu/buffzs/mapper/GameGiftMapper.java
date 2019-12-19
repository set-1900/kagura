package com.bahu.buffzs.mapper;


import com.bahu.buffzs.pojo.BuffGameGift;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameGiftMapper {

    List<BuffGameGift> findAll();

    BuffGameGift findById(Integer id);

    Integer save(BuffGameGift buffGameGift);

    Integer updateSave(BuffGameGift buffGameGift);

    Integer delete(Integer id);

    BuffGameGift findByUniqueId(Integer uniqueId);
}
