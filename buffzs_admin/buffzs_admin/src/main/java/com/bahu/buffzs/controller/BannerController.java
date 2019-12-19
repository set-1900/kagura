package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.BannerService;
import com.bahu.buffzs.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private ModuleService moduleService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size,  BuffBanner buffBanner) {
        PageBean buffBannerList = bannerService.findAll(current, size ,buffBanner);
        ModelAndView model = new ModelAndView();
        model.setViewName("banner_list");
        model.addObject("banner", buffBannerList);

        List<BuffModule> moduleList = moduleService.queryByPIdAndType(null, 1);
        model.addObject("moduleList", moduleList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/banner_edit");
        List<BuffModule> moduleList = moduleService.queryByPIdAndType(null, 1);
        model.addObject("moduleList", moduleList);
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave")
    public Result dosave(BuffBanner buffBanner) {
        if (buffBanner != null) {
            Integer i = bannerService.save(buffBanner);
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
        BuffBanner buffBanner = bannerService.findById(id);
        ModelAndView model = new ModelAndView("/banner_update");
        model.addObject("banner", buffBanner);

        List<BuffModule> moduleList = moduleService.queryByPIdAndType(null, 1);
        model.addObject("moduleList", moduleList);

        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave")
    public Result updateSave(BuffBanner buffBanner) {
        if (buffBanner != null) {
            Integer i = bannerService.updateSave(buffBanner);
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
        Integer i = bannerService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
