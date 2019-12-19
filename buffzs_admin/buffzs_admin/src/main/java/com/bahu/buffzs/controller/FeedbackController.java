package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffFeedback;
import com.bahu.buffzs.pojo.BuffFeedbackType;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.FeedbackService;
import com.bahu.buffzs.service.FeedbackTypeService;
import com.bahu.buffzs.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @program: buffzs_admin
 * @description: 反馈
 * @author: Mr.Baron
 * @create: 2019-10-08
 **/

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private FeedbackTypeService feedbackTypeService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = feedbackService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("feedback_list");
        model.addObject("feedback", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/feedback_edit");
        List<BuffFeedbackType> feedbackTypeList = feedbackTypeService.findAll();
        model.addObject("feedbackType",feedbackTypeList);
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffFeedback buffFeedback) {
        if (buffFeedback != null) {
            buffFeedback.setAddTime(new Date());
            Integer i = feedbackService.save(buffFeedback);
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
        BuffFeedback buffFeedback = feedbackService.findById(id);
        ModelAndView model = new ModelAndView("/feedback_update");
        model.addObject("feedback", buffFeedback);
        List<BuffFeedbackType> feedbackTypeList = feedbackTypeService.findAll();
        model.addObject("feedbackType", feedbackTypeList);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffFeedback buffFeedback) {
        if (buffFeedback != null) {
            Integer i = feedbackService.updateSave(buffFeedback);
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
        Integer i = feedbackService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
