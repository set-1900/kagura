package com.bahu.buffzs.mapper;

import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffHtmlTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Mapper
public interface HtmlTemplateMapper {
     List<BuffHtmlTemplate> findAll() ;

    BuffHtmlTemplate findById(Integer id);

    Integer save(BuffHtmlTemplate htmlTemplate);

    Integer updateSave(BuffHtmlTemplate htmlTemplate);

    Integer delete(Integer id);
}
