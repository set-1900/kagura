package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffGameIcon;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ApkService;
import com.bahu.buffzs.service.HotIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author:
 * @Date: 2019/12/2
 * @Version: 1.0
 **/

@Controller
@RequestMapping(value = "/hotIcon")
public class HotIconController {

    @Autowired
    private HotIconService hotIconService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = hotIconService.findAll(current, size );
        ModelAndView model = new ModelAndView();
        model.setViewName("hotIcon_list");
        model.addObject("hotIcon", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/hotIcon_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave")
    public Result dosave(BuffGameIcon buffGameIcon) {
        if (buffGameIcon != null) {
            Integer i = hotIconService.save(buffGameIcon);
            if (i > 0) {
                return Result.success("保存成功");
            }
        }
        return  Result.success("保存失败");
    }

    //修改页
    @ResponseBody
    @RequestMapping(value = "/update")
    public ModelAndView editPass(Integer id) {
        BuffGameIcon buffGameIcon = hotIconService.findById(id);
        ModelAndView model = new ModelAndView("/hotIcon_update");
        model.addObject("hotIcon", buffGameIcon);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave")
    public Result updateSave( BuffGameIcon buffGameIcon) {
        if (buffGameIcon != null) {
            Integer i = hotIconService.updateSave(buffGameIcon);
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
        Integer i = hotIconService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
