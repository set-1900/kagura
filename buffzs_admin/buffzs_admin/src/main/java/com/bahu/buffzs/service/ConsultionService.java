package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffConsultion;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface ConsultionService {
    PageBean findAll(Integer current, Integer size);

    BuffConsultion findById(Integer id);

    Integer save(BuffConsultion buffConsultion);

    Integer updateSave(BuffConsultion buffConsultion);

    Integer delete(Integer id);
}
