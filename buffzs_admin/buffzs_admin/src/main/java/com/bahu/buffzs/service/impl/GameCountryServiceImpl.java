package com.bahu.buffzs.service.impl;


import com.bahu.buffzs.mapper.GameCountryMapper;
import com.bahu.buffzs.mapper.GameMapper;
import com.bahu.buffzs.mapper.LabelMapper;
import com.bahu.buffzs.pojo.BuffGame;
import com.bahu.buffzs.pojo.BuffGameCountry;
import com.bahu.buffzs.pojo.BuffLabel;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.GameCountryService;
import com.bahu.buffzs.service.GameService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class GameCountryServiceImpl implements GameCountryService {
    @Autowired
    private GameCountryMapper gameCountryMapper;


    @Override
    public List<BuffGameCountry> findAll() {
        return gameCountryMapper.findAll();
    }
}