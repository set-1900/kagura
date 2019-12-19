package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffGameGenres;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.GameGenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/gameGenres")
public class GameGenresController {

    @Autowired
    private GameGenresService gameGenresService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = gameGenresService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("gameGenres_list");
        model.addObject("gameGenres", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/gameGenres_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffGameGenres buffGameGenres) {
        if (buffGameGenres != null) {

            Integer i = gameGenresService.save(buffGameGenres);
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
        BuffGameGenres buffGameGenres = gameGenresService.findById(id);
        ModelAndView model = new ModelAndView("/gameGenres_update");
        model.addObject("gameGenres", buffGameGenres);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffGameGenres buffGameGenres) {
        if (buffGameGenres != null) {
            Integer i = gameGenresService.updateSave(buffGameGenres);
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
        Integer i = gameGenresService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
