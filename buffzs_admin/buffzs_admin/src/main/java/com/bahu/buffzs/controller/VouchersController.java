package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffVouchers;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.VouchersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description: 代金券管理
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/vouchers")
public class VouchersController {

    @Autowired
    private VouchersService vouchersService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffVpnList = vouchersService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("vouchers/vouchers_list");
        model.addObject("vouchers", buffVpnList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("vouchers/vouchers_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffVouchers buffVouchers) {
        if (buffVouchers != null) {
            Integer i = vouchersService.save(buffVouchers);
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
        BuffVouchers buffVouchers = vouchersService.findById(id);
        ModelAndView model = new ModelAndView("vouchers/vouchers_update");
        model.addObject("vouchers", buffVouchers);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffVouchers buffVouchers) {
        if (buffVouchers != null) {
            Integer i = vouchersService.updateSave(buffVouchers);
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
        Integer i = vouchersService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
