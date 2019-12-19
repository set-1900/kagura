package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface BannerService {
    PageBean findAll(Integer current, Integer size ,BuffBanner buffBanner);

    BuffBanner findById(Integer id);

    Integer save(BuffBanner buffBanner);

    Integer updateSave(BuffBanner buffBanner);

    Integer delete(Integer id);
}
