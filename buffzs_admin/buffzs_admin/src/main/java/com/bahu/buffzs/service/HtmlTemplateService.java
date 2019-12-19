package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffHtmlTemplate;
import com.bahu.buffzs.pojo.dto.PageBean;

import java.util.List;

public interface HtmlTemplateService {

    PageBean findAll(Integer current, Integer size ,String name);

    List<BuffHtmlTemplate> findAll();

    BuffHtmlTemplate findById(Integer id);

    Integer save(BuffHtmlTemplate htmlTemplate);

    Integer updateSave(BuffHtmlTemplate htmlTemplate);

    Integer delete(Integer id);
}
