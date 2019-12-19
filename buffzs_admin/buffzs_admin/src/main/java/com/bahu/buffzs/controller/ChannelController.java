package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = channelService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("channel_list");
        model.addObject("channel", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/channel_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffChannel buffChannel) {
        if (buffChannel != null) {
            buffChannel.setCreateTime(new Date());
            Integer i = channelService.save(buffChannel);
            if (i > 0) {
                return Result.success("保存成功");
            }
        }
        return Result.success("保存失败");
    }

    //修改页
    @ResponseBody
    @RequestMapping(value = "/update")
    public ModelAndView editPass(Integer id) {
        BuffChannel buffChannel = channelService.findById(id);
        ModelAndView model = new ModelAndView("/channel_update");
        model.addObject("channel", buffChannel);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffChannel buffChannel) {
        if (buffChannel != null) {
            Integer i = channelService.updateSave(buffChannel);
            if (i > 0) {
                return Result.success("修改成功");
            }
        }
        return Result.error();
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/del")
    public Result del(Integer id) {
        Integer i = channelService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
