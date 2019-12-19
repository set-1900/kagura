package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffRecommend;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ApkService;
import com.bahu.buffzs.service.ChannelService;
import com.bahu.buffzs.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: apk 打包
 * @Author: XieXiang
 * @Date: 2019/11/29
 * @Version: 1.0
 **/

@Controller
@RequestMapping(value = "/apk")
public class ApkController {

    @Autowired
    private ApkService apkService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private VersionService versionService;

    @RequestMapping(value = "/shareApk")
    public void shareApk(BuffRecommend recommend, HttpServletResponse response) throws Exception {
        apkService.shareApk(recommend, response);
    }

    @ResponseBody
    @RequestMapping(value = "/createAndSetSignApk")
    public void createAndSetSignApk(String url, HttpServletResponse response) throws Exception {
        int index = url.indexOf("?");
        // 子渠道链接剪切规则:
        // 前: http://fffyx.52091w.com/360_pc/promotion1.html?xxx
        // 后: http://fffyx.52091w.com
        String subchannelUrl = url.substring(0, url.lastIndexOf("/"));
        subchannelUrl = subchannelUrl.substring(0, subchannelUrl.lastIndexOf("/"));
        String keyword = url.substring(index + 1, url.length());
        apkService.createAndSetSignApk(subchannelUrl, keyword, response);
    }

    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/apk_edit");
        List<BuffChannel> allChannel = channelService.findAllChannel();
        model.addObject("channelList", allChannel);
        return model;
    }

    /**
     * 打包
     *
     * @param current
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = versionService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("apk_list");
        model.addObject("version", buffBannerList);
        return model;
    }

    // 增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffPromotionPageDto promotionPageDto) {
        Integer i = versionService.createApk(promotionPageDto);
        if (i == 1) return Result.error("已经存在");
        return Result.success("保存成功");
    }
}
