package com.bahu.buffzs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 跳转页面专用方法
 * @Author: XieXiang
 * @Date: 2019/12/17
 * @Version: 1.0
 **/

@Slf4j
@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @ResponseBody
    @RequestMapping("/view")
    public ModelAndView redirect(String viewName) {
        ModelAndView mv = new ModelAndView(viewName);
        return mv;
    }
}
