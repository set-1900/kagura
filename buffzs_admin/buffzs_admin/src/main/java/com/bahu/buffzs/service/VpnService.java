package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffVpn;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface VpnService {
    PageBean findAll(Integer current, Integer size);

    BuffVpn findById(Integer id);

    Integer save(BuffVpn buffVpn);

    Integer updateSave(BuffVpn buffVpn);

    Integer delete(Integer id);
}
