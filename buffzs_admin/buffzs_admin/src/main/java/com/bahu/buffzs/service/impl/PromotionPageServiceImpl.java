package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.ChannelMapper;
import com.bahu.buffzs.mapper.HtmlTemplateMapper;
import com.bahu.buffzs.mapper.PromotionPageMapper;
import com.bahu.buffzs.mapper.SubchannelMapper;
import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffHtmlTemplate;
import com.bahu.buffzs.pojo.BuffPromotionPage;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.util.ContextLoadsUtils;
import com.bahu.buffzs.pojo.util.FileUtil;
import com.bahu.buffzs.service.PromotionPageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @Description :
 * @Author : XieXiang
 * @Date : 2019/11/27
 * @Version : 1.0
 **/

@Transactional
@Service
public class PromotionPageServiceImpl implements PromotionPageService {

    @Autowired
    private PromotionPageMapper promotionPageMapper;

    @Autowired
    private HtmlTemplateMapper htmlTemplateMapper;

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private SubchannelMapper subchannelMapper;

    @Override
    public BuffPromotionPage findById(String id) {
        return promotionPageMapper.findById(id);
    }

    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 1 : size);
        List<BuffPromotionPage> promotionPageList = promotionPageMapper.findAll(current, size);
        PageInfo<BuffPromotionPage> pageInfo = new PageInfo<>(promotionPageList);
        PageBean<BuffPromotionPage> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    /*/**
    * @Author: XieXiang
    * @Description: 将模板中的"HTMLTEMPLATE"替换成用户图片,再将替换后的模板保存并保存模板信息
    * @Date: 2019/12/3
    * @Param: [buffPromotionPageDto]
    * @return: java.lang.Integer
    **/
    @Override
    public Integer save(BuffPromotionPageDto buffPromotionPageDto) {
        BuffPromotionPage promotionPage = new BuffPromotionPage();
        BeanUtils.copyProperties(buffPromotionPageDto, promotionPage);
        Date date2 = new Date();
        BuffChannel channel = channelMapper.findById(Integer.parseInt(promotionPage.getChannelId()));
        BuffSubchannel subchannel = subchannelMapper.findById(promotionPage.getSubchannelId());
        BuffHtmlTemplate htmlTemplate = htmlTemplateMapper.findById(Integer.parseInt(buffPromotionPageDto.getHemlTemplateId()));
        //创建文件路径
        //获取本机IP
        String host = "";
        String addressImg = "";
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        System.out.println("当前系统是:" + name);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String templateUrl = htmlTemplate.getTemplateUrl();
        String[] urlArr = templateUrl.split("/");
        String filname = urlArr[urlArr.length-1];
        String srcUrl = templateUrl.substring(templateUrl.indexOf("/img"), templateUrl.length());
        String desUrl = "";
        // 使用渠道名称 + 子渠道名称作为生成地址替换原来时间
        String subchanneName = subchannel.getName();
        if (name.indexOf("Windows") == -1) {
            host = request.getServerName();
            System.out.println("域名:---" + host);
            //host = "http://api.buffzs.com";
            addressImg = "http://" + host + "/img/tui_html";
            desUrl = "/img/tui_html/" + channel.getName() + "/" + subchanneName;
            System.out.println("Linux---addressImg = " + addressImg);
        } else {
            System.out.println("域名:---" + request.getServerName());
            addressImg = "http://" + request.getServerName() + ":" + request.getServerPort() + "/img/tui_html";
            desUrl = "D:\\img\\tui_html/" + channel.getName() + "/" + subchanneName;
            srcUrl = "D:" + srcUrl;
            System.out.println("Windows---addressImg = " + addressImg);
        }
        String fileName = buffPromotionPageDto.getName() + ".html";
        ContextLoadsUtils.MakeHtml2(srcUrl, buffPromotionPageDto.getImgUrl(),desUrl , fileName, subchanneName);
        // 推广页下载地址: 域名+渠道名称+子渠道名称+文件名
        promotionPage.setUrl(addressImg + "/" + channel.getName() + "/" + subchanneName + "/" + fileName);
        promotionPage.setCreateTime(date2);
        promotionPage.setUpdateTime(date2);
        promotionPage.setChannelName(channel.getName());
        promotionPage.setSubchannelName(subchanneName);
        // 推广页推广地址: 域名+子渠道名称+文件名
        promotionPage.setPromotionUrl(subchannel.getDownloadUrl() + "/" + subchanneName + "/" + fileName);
        promotionPage.setImgUrl(buffPromotionPageDto.getImgUrl());
        return promotionPageMapper.save(promotionPage);
    }

    @Override
    public Integer updateById(BuffPromotionPage buffPromotionPage) {
        return promotionPageMapper.updateById(buffPromotionPage);
    }

    @Override
    public Integer delete(String id) {
        BuffPromotionPage promotionPage = promotionPageMapper.findById(id);
        String downUrl = promotionPage.getUrl();
        String imgUrl = promotionPage.getImgUrl();
        if (downUrl != null) FileUtil.delFile(downUrl);
        if (imgUrl != null) FileUtil.delFile(imgUrl);
        return promotionPageMapper.deleteById(id);
    }
}
