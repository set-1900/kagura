package com.bahu.buffzs.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
//        if (StringUtils.isNotBlank(principal)) {
//            String[] principals = principal.split(",");
//            if (principals != null && principals.length == 2) {
//                String username = principals[0];
//                String role = principals[1];
//                mav.addObject("username", username);
//                mav.addObject("role", role);
//            }
//        }
        mav.addObject("username", principal);
        return mav;
    }

    @RequestMapping("main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView("main");
        return mav;
    }


}
