package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffLabel;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface LabelService {
    List<BuffLabel> findAll();


    Integer save(Integer gameid, String labelid);





    PageBean findAll(Integer current, Integer size);

    BuffLabel findById(Integer id);

    Integer save(BuffLabel buffLabel);

    Integer updateSave(BuffLabel buffLabel);

    Integer delete(Integer id);

}
