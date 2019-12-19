package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffConsultion;
import com.bahu.buffzs.pojo.BuffGame;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ConsultionService;
import com.bahu.buffzs.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description: 资讯中心控制
 * @author: Mr.Baron
 * @create: 2019-09-26
 **/

@Controller
@RequestMapping("/consultion")
public class ConsultionController {

    @Autowired
    private ConsultionService consultionService;

    @Autowired
    private GameService gameService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffConsultionList = consultionService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("consultion_list");
        model.addObject("consultion", buffConsultionList);
        return model;
    }


    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/consultion_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave")
    public Result dosave(BuffConsultion buffConsultion) {
        if (buffConsultion != null) {
            Integer i = consultionService.save(buffConsultion);
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
        BuffConsultion buffConsultion = consultionService.findById(id);
        ModelAndView model = new ModelAndView("/consultion_update");
        model.addObject("consultion", buffConsultion);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave")
    public Result updateSave(BuffConsultion buffConsultion) {
        if (buffConsultion != null) {
            Integer i = consultionService.updateSave(buffConsultion);
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
        Integer i = consultionService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }


    //查询游戏
    @ResponseBody
    @RequestMapping(value = "/selectGame")
    public Result selectGame(BuffGame buffGame) {
        List<BuffGame> buffGameList = gameService.selectGameByName(buffGame);
        return Result.success(buffGameList);
    }

    //查询游戏
    @ResponseBody
    @RequestMapping(value = "/selectGame1")
    public Result selectGame(String name) {
        BuffGame buffGame = new BuffGame();
        buffGame.setName(name);
        List<BuffGame> buffGameList = gameService.selectGameByName(buffGame);
        return Result.success(buffGameList);
    }
}
