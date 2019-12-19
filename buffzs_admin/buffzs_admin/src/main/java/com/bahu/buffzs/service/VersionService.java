package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface VersionService {
    PageBean findAll(Integer current, Integer size);

    BuffApkVersion findById(Integer id);

    Integer save(BuffApkVersion buffApkVersion);

    Integer updateSave(BuffApkVersion buffApkVersion);

    Integer delete(Integer id);

    Integer createApk(BuffPromotionPageDto promotionPageDto) ;
}
