package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffGameServer;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.GameServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description: 游戏区服控制类
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/
@Slf4j
@Controller
@RequestMapping("/gameServer")
public class GameServerController {
    @Autowired
    private GameServerService gameServerService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffGameList = gameServerService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("gameServer_list");
        model.addObject("gameServer", buffGameList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/gameServer_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave")
    public Result dosave(BuffGameServer buffGameServer) {
        if (buffGameServer != null) {
            Integer i = gameServerService.save(buffGameServer);
            if (i > 0) {
                return Result.success("保存成功");
            }
        }
        return Result.success("保存失败");
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/del")
    public Result del(Integer id) {
        Integer i = gameServerService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    //修改页
    @ResponseBody
    @RequestMapping(value = "/update")
    public ModelAndView editPass(Integer id) {
        BuffGameServer buffGameServer = gameServerService.findById(id);
        ModelAndView model = new ModelAndView("/gameServer_update");
        model.addObject("gameServer", buffGameServer);
        return model;
    }

    //保存修改
    @ResponseBody
    @RequestMapping(value = "/updateSave")
    public Result updateSave(BuffGameServer buffGameServer) {
        if (buffGameServer != null) {
            Integer i = gameServerService.updateSave(buffGameServer);
            if (i > 0) {
                return Result.success("修改成功");
            }
        }
        return Result.error();
    }


}
