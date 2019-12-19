package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.GenresMapper;
import com.bahu.buffzs.pojo.BuffGameGenres;
import com.bahu.buffzs.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-16
 **/
@Transactional
@Service
public class GenresServiceImpl implements GenresService {
    @Autowired
    private GenresMapper genresMapper;

    @Override
    public List<BuffGameGenres> findAll() {
        return genresMapper.findAll();

    }
}
