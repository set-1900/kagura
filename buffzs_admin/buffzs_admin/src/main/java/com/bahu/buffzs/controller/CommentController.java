package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffComment;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.CommentService;
import com.bahu.buffzs.service.VersionService;
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
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = commentService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("comment_list");
        model.addObject("comment", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/comment_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffComment buffComment) {
        if (buffComment != null) {
            Integer i = commentService.save(buffComment);
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
        BuffComment buffComment = commentService.findById(id);
        ModelAndView model = new ModelAndView("/comment_update");
        model.addObject("comment", buffComment);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffComment buffComment) {
        if (buffComment != null) {
            Integer i = commentService.updateSave(buffComment);
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
        Integer i = commentService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
