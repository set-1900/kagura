package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffHtmlTemplate;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.GameService;
import com.bahu.buffzs.service.HtmlTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author： Mr.Baron
 * @date： 2019/11/25
 * @description：
 */

@Slf4j
@Controller
@RequestMapping("/htmlTemplate")
public class HtmlTemplateController {

    @Autowired
    private HtmlTemplateService htmlTemplateService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size, String name) {
        PageBean buffGameList = htmlTemplateService.findAll(current, size, name);
        ModelAndView model = new ModelAndView();
        model.setViewName("/htmlTemplate/htmlTemplate_list");
        model.addObject("htmlTemplate", buffGameList);
        return model;
    }


    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/htmlTemplate/htmlTemplate_edit");
        return model;
    }


    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave")
    public Result dosave(BuffHtmlTemplate htmlTemplate) {
        if (htmlTemplate != null) {
            htmlTemplate.setCreateTime(new Date());
            Integer i = htmlTemplateService.save(htmlTemplate);
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
        Integer i = htmlTemplateService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }


    //修改页
    @ResponseBody
    @RequestMapping(value = "/update")
    public ModelAndView editPass(Integer id) {
        BuffHtmlTemplate htmlTemplate = htmlTemplateService.findById(id);
        ModelAndView model = new ModelAndView("/htmlTemplate/htmlTemplate_update");
        model.addObject("htmlTemplate", htmlTemplate);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave")
    public Result updateSave(BuffHtmlTemplate htmlTemplate) {
        if (htmlTemplate != null) {
            Integer i = htmlTemplateService.updateSave(htmlTemplate);
            if (i > 0) {
                return Result.success("修改成功");
            }
        }
        return Result.error();
    }

    @ResponseBody
    @RequestMapping(value = "/templateList")
    public ModelAndView templateList(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean pageBean = htmlTemplateService.findAll(current, size, "");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/promotionPage/promotionPage_edit");
        modelAndView.addObject("htmlTemplate",pageBean);
        return modelAndView;
    }
}
