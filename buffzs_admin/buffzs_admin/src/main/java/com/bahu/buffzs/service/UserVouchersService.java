package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffUserVouchers;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface UserVouchersService {
    PageBean findAll(Integer current, Integer size);

    BuffUserVouchers findById(Integer id);

    Integer save(BuffUserVouchers buffUserVouchers);

    Integer updateSave(BuffUserVouchers buffUserVouchers);

    Integer delete(Integer id);
}
