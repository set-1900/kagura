package com.bahu.buffzs.service;


import com.bahu.buffzs.pojo.BuffGameGift;
import com.bahu.buffzs.pojo.BuffGameGiftCode;
import com.bahu.buffzs.pojo.dto.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GameGiftCodeService {

    PageBean findAll(Integer current, Integer size);

    BuffGameGiftCode findById(Integer id);

    Integer save(BuffGameGiftCode buffGameGiftCode);

    Integer updateSave(BuffGameGiftCode buffGameGiftCode);

    Integer delete(Integer id);

    void batchImport(MultipartFile file, String unique_id) throws Exception;

}
