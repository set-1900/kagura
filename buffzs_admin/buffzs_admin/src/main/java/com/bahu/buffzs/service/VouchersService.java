package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffVouchers;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface VouchersService {
    PageBean findAll(Integer current, Integer size);

    BuffVouchers findById(Integer id);

    Integer save(BuffVouchers buffVouchers);

    Integer updateSave(BuffVouchers buffVouchers);

    Integer delete(Integer id);
}
