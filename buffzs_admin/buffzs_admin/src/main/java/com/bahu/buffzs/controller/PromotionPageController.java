package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.*;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ChannelService;
import com.bahu.buffzs.service.HtmlTemplateService;
import com.bahu.buffzs.service.PromotionPageService;
import com.bahu.buffzs.service.SubchannelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : XieXiang
 * @Date : 2019/11/27
 * @Version : 1.0
 **/

@Slf4j
@Controller
@RequestMapping("/promotionPage")
public class PromotionPageController {

    @Autowired
    private PromotionPageService promotionPageService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private SubchannelService subchannelService;

    @Autowired
    private HtmlTemplateService htmlTemplateService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView findAll(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean promotionPageList = promotionPageService.findAll(current, size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/promotionPage/promotionPage_list");
        modelAndView.addObject("promotionPage", promotionPageList);
        return modelAndView;
    }

    // 新增页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit(String id) {
        ModelAndView modelAndView = null;
        try {
            modelAndView = new ModelAndView("/promotionPage/promotionPage_edit");
            List<BuffChannel> channelList = new ArrayList<>();
            List<BuffHtmlTemplate> allhtmlTemplate = htmlTemplateService.findAll();
            if (id != null) {
                BuffPromotionPage promotionPage = promotionPageService.findById(id);
                editSetModel(modelAndView, allhtmlTemplate);
                return modelAndView.addObject("promotionPage", promotionPage);
            }
            editSetModel(modelAndView, allhtmlTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            log.info(sw.toString());
        }
        return modelAndView;
    }

    private void editSetModel(ModelAndView modelAndView, List<BuffHtmlTemplate> allhtmlTemplate) {
        List<BuffChannel> channelList;
        modelAndView.addObject("htmlTemplateList", allhtmlTemplate);
        channelList = channelService.findAllChannel();
        modelAndView.addObject("channelList", channelList);
    }

    // 增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffPromotionPageDto promotionPageDto) {
        if (promotionPageDto == null) return Result.error("保存失败");
        Integer i = promotionPageService.save(promotionPageDto);
        if (i <= 0) return Result.error("保存失败");
        return Result.success("保存成功");
    }

    //修改页
    @ResponseBody
    @RequestMapping(value = "/update")
    public ModelAndView editPass(Integer id) {
        BuffPromotionPage promotionPage = promotionPageService.findById(id.toString());
        ModelAndView model = new ModelAndView("/promotionPage/promotionPage_update");
        model.addObject("promotionPage", promotionPage);
        return model;
    }

    // 修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffPromotionPage promotionPage) {
        if (promotionPage != null) {
            Integer i = promotionPageService.updateById(promotionPage);
            if (i > 0) {
                return Result.success("修改成功");
            }
        }
        return Result.error();
    }

    // 删除
    @ResponseBody
    @RequestMapping(value = "/del")
    public Result del(String id) {
        Integer i = promotionPageService.delete(id);
        if (i > 0) return Result.success("删除成功");
        return Result.error("删除失败");
    }

    /*/**
     * @Author: XieXiang
     * @Description: 根据渠道id关联查询子渠道
     * @Date: 2019/11/27
     * @Param: [channelId]
     * @return: com.bahu.buffzs.pojo.dto.Result
     **/
    @ResponseBody
    @RequestMapping(value = "/querySubchannelByChannelId")
    public Result querySubchannelByChannelId(@Param("channelId") Integer channelId) {
        List<BuffSubchannel> subchannelList = subchannelService.findByChannelId(channelId.toString());
        return Result.success(subchannelList);
    }
}
