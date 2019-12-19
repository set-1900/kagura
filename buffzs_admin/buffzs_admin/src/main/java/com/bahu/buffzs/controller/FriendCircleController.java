package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffCircleOfFriends;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.FriendCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-30
 **/

@Controller
@RequestMapping("/friendCircle")
public class FriendCircleController {

    @Autowired
    private FriendCircleService friendCircleService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = friendCircleService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("friendCircle_list");
        model.addObject("friendCircle", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/friendCircle_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffCircleOfFriends buffCircleOfFriends) {
        if (buffCircleOfFriends != null) {
            buffCircleOfFriends.setAddTime(new Date());
            buffCircleOfFriends.setLaud(0);
            Integer i = friendCircleService.save(buffCircleOfFriends);
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
        BuffCircleOfFriends buffCircleOfFriends = friendCircleService.findById(id);
        ModelAndView model = new ModelAndView("/friendCircle_update");
        model.addObject("friendCircle", buffCircleOfFriends);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffCircleOfFriends buffCircleOfFriends) {
        if (buffCircleOfFriends != null) {
            Integer i = friendCircleService.updateSave(buffCircleOfFriends);
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
        Integer i = friendCircleService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
