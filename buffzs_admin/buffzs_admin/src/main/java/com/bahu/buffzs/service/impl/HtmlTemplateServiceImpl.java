package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.HtmlTemplateMapper;
import com.bahu.buffzs.pojo.BuffHtmlTemplate;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.util.FileUtil;
import com.bahu.buffzs.service.HtmlTemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Transactional
@Slf4j
@Service
public class HtmlTemplateServiceImpl implements HtmlTemplateService {
    @Autowired
    private HtmlTemplateMapper htmlTemplateMapper;


    @Override
    public PageBean findAll(Integer current, Integer size, String name) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffHtmlTemplate> list = htmlTemplateMapper.findAll();
        PageInfo<BuffHtmlTemplate> pageInfo = new PageInfo<>(list);
        PageBean<BuffHtmlTemplate> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public List<BuffHtmlTemplate> findAll() {
        return htmlTemplateMapper.findAll();
    }

    @Override
    public BuffHtmlTemplate findById(Integer id) {
        BuffHtmlTemplate htmlTemplate = htmlTemplateMapper.findById(id);
        return htmlTemplate;
    }

    @Override
    public Integer save(BuffHtmlTemplate htmlTemplate) {
        htmlTemplate.setCreateTime(new Date());
        return htmlTemplateMapper.save(htmlTemplate);
    }


    @Override
    public Integer updateSave(BuffHtmlTemplate htmlTemplate) {
        BuffHtmlTemplate template = htmlTemplateMapper.findById(htmlTemplate.getId());
        if (!template.getTemplateUrl().equals(htmlTemplate.getTemplateUrl())){
            String path = "";
            Properties properties = System.getProperties();
            String name = properties.getProperty("os.name");
            String[] imgs = template.getTemplateUrl().split("img");
            if (name.indexOf("Windows") == -1) {
                path = "/img/";
                path = path + imgs[imgs.length - 1];
                File file = new File(path);
                if (file.isFile() && file.exists()) {
                    file.delete();
                }else {
                    log.info(template.getTemplateUrl() + "=====不是文件或文件不存在");
                }
            }else {
                 path = "D:/img/" + imgs[imgs.length - 1];
                File file = new File(path);
                if (file.isFile() && file.exists()) {
                    file.delete();
                }else {
                    log.info(template.getTemplateUrl() + "=====不是文件或文件不存在");
                }
            }
        }
        return htmlTemplateMapper.updateSave(htmlTemplate);
    }

    @Override
    public Integer delete(Integer id) {
        BuffHtmlTemplate htmlTemplate = htmlTemplateMapper.findById(id);
        String templateUrl = htmlTemplate.getTemplateUrl();
        String imgUrl = htmlTemplate.getImgUrl();
        if (templateUrl != null)
        FileUtil.delFile(templateUrl);
        if (imgUrl != null)
        FileUtil.delFile(imgUrl);
        return htmlTemplateMapper.delete(id);
    }
}
