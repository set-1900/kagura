package com.bahu.buffzs.mapper;


import com.bahu.buffzs.pojo.BuffGameGiftCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameGiftCodeMapper {

    List<BuffGameGiftCode> findAll();

    BuffGameGiftCode findById(Integer id);

    Integer save(BuffGameGiftCode buffGameGiftCode);

    Integer updateSave(BuffGameGiftCode buffGameGiftCode);

    Integer delete(Integer id);
}
