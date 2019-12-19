package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffRechargeProportion;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.RechargeProportionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description: 充值比例管理
 * @author: Mr.Baron
 * @create: 2019-12-13
 **/

@Controller
@RequestMapping("/rechargeProportion")
public class RechargeProportionController {

    @Autowired
    private RechargeProportionService rechargeProportionService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffVpnList = rechargeProportionService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("rechargeProportion/rechargeProportion_list");
        model.addObject("rechargeProportion", buffVpnList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("rechargeProportion/rechargeProportion_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffRechargeProportion buffRechargeProportion) {
        if (buffRechargeProportion != null) {
            Integer i = rechargeProportionService.save(buffRechargeProportion);
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
        BuffRechargeProportion buffRechargeProportion = rechargeProportionService.findById(id);
        ModelAndView model = new ModelAndView("rechargeProportion/rechargeProportion_update");
        model.addObject("rechargeProportion", buffRechargeProportion);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffRechargeProportion buffRechargeProportion) {
        if (buffRechargeProportion != null) {
            Integer i = rechargeProportionService.updateSave(buffRechargeProportion);
            if (i > 0) {
                return Result.success("修改成功");
            }
        }
        return Result.error("修改失败");
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/del")
    public Result del(Integer id) {
        Integer i = rechargeProportionService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
