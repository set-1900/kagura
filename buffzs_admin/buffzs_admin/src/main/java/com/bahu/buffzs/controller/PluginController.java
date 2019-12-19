package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.CommentService;
import com.bahu.buffzs.service.PluginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author： Mr.Baron
 * @date： 2019/10/25
 * @description：
 */

@Slf4j
@Controller
@RequestMapping("/plugin")
public class PluginController {

    @Autowired
    private PluginService piuginService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = piuginService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("plugin_list");
        model.addObject("plugin", buffBannerList);
        return model;
    }
}
