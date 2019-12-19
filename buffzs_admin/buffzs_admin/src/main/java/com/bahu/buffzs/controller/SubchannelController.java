package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ChannelService;
import com.bahu.buffzs.service.SubchannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author : XieXiang
 * @Date : 2019/11/27
 * @Version : 1.0
 **/

@Controller
@RequestMapping("/subchannel")
public class SubchannelController {

    @Autowired
    private SubchannelService subchannelService;
    @Autowired
    private ChannelService channelService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView findAll(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffSubchannelList = subchannelService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("/subchannel/subchannel_list");
        model.addObject("subchannel", buffSubchannelList);
        return model;
    }

    // 新增页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        List<BuffChannel> channelList = channelService.findAllChannel();
        ModelAndView model = new ModelAndView();
        model.setViewName("/subchannel/subchannel_edit");
        model.addObject("channelList", channelList);
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffSubchannel subchannel) {
        if (subchannel != null) {
            subchannel.setCreateTime(new Date());
            Integer i = subchannelService.save(subchannel);
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
        BuffSubchannel subchannel = subchannelService.findById(id.toString());
        ModelAndView model = new ModelAndView("/subchannel/subchannel_update");
        model.addObject("subchannel", subchannel);

        List<BuffChannel> channelList = channelService.findAllChannel();
        model.addObject("channelList", channelList);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffSubchannel subchannel) {
        if (subchannel != null) {
            Integer i = subchannelService.updateSave(subchannel);
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
        Integer i = subchannelService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
