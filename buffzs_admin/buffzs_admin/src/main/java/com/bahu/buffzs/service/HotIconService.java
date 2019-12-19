package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffGameIcon;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface HotIconService {
    PageBean findAll(Integer current, Integer size);

    BuffGameIcon findById(Integer id);

    Integer save(BuffGameIcon buffGameIcon);

    Integer updateSave(BuffGameIcon buffGameIcon);

    Integer delete(Integer id);

    List<BuffGameIcon> findAll();
}
