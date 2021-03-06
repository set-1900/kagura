package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffFeedbackType;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.FeedbackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description: 反馈
 * @author: Mr.Baron
 * @create: 2019-10-08
 **/

@Controller
@RequestMapping("/feedbackType")
public class FeedbackTypeController {

    @Autowired
    private FeedbackTypeService feedbackTypeService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = feedbackTypeService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("feedbackType_list");
        model.addObject("feedbackType", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/feedbackType_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffFeedbackType buffFeedbackType) {
        if (buffFeedbackType != null) {
            Integer i = feedbackTypeService.save(buffFeedbackType);
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
        BuffFeedbackType buffFeedbackType = feedbackTypeService.findById(id);
        ModelAndView model = new ModelAndView("/feedbackType_update");
        model.addObject("feedbackType", buffFeedbackType);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffFeedbackType buffFeedbackType) {
        if (buffFeedbackType != null) {
            Integer i = feedbackTypeService.updateSave(buffFeedbackType);
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
        Integer i = feedbackTypeService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
