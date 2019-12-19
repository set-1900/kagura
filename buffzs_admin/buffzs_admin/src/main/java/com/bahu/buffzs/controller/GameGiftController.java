package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffGameGift;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.GameGiftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @program: buffzs_admin
 * @description: 游戏
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/
@Slf4j
@Controller
@RequestMapping("/gameGift")
public class GameGiftController {
    @Autowired
    private GameGiftService gameGiftService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = gameGiftService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("gameGift_list");
        model.addObject("gameGift", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/gameGift_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffGameGift buffGameGift) {
        if (buffGameGift != null) {
            Integer i = gameGiftService.save(buffGameGift);
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
        BuffGameGift buffGameGift = gameGiftService.findById(id);
        ModelAndView model = new ModelAndView("/gameGift_update");
        model.addObject("gameGift", buffGameGift);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffGameGift buffGameGift) {
        if (buffGameGift != null) {
            Integer i = gameGiftService.updateSave(buffGameGift);
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
        Integer i = gameGiftService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

}
