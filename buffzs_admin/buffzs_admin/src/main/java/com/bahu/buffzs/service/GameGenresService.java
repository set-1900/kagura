package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffGameGenres;
import com.bahu.buffzs.pojo.dto.PageBean;

public interface GameGenresService {
    PageBean findAll(Integer current, Integer size);

    BuffGameGenres findById(Integer id);

    Integer save(BuffGameGenres buffGameGenres);

    Integer updateSave(BuffGameGenres buffGameGenres);

    Integer delete(Integer id);
}
