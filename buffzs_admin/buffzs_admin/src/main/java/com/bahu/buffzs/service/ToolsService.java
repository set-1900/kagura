package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffTools;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface ToolsService {
    PageBean findAll(Integer current, Integer size);

    BuffTools findById(Integer id);

    Integer save(BuffTools buffTools);

    Integer updateSave(BuffTools buffTools);

    Integer delete(Integer id);
}
