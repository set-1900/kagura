package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffRechargeProportion;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface RechargeProportionService {
    PageBean findAll(Integer current, Integer size);

    BuffRechargeProportion findById(Integer id);

    Integer save(BuffRechargeProportion buffRechargeProportion);

    Integer updateSave(BuffRechargeProportion buffRechargeProportion);

    Integer delete(Integer id);
}
