package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffUserVouchers;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.UserVouchersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description: 用户领取代金券管理
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/userVouchers")
public class UserVouchersController {

    @Autowired
    private UserVouchersService userVouchersService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffVpnList = userVouchersService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("userVouchers/userVouchers_list");
        model.addObject("userVouchers", buffVpnList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("userVouchers/userVouchers_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave", method = RequestMethod.POST)
    public Result dosave(BuffUserVouchers buffUserVouchers) {
        if (buffUserVouchers != null) {
            Integer i = userVouchersService.save(buffUserVouchers);
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
        BuffUserVouchers buffUserVouchers = userVouchersService.findById(id);
        ModelAndView model = new ModelAndView("userVouchers/userVouchers_update");
        model.addObject("userVouchers", buffUserVouchers);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave", method = RequestMethod.POST)
    public Result updateSave(BuffUserVouchers buffUserVouchers) {
        if (buffUserVouchers != null) {
            Integer i = userVouchersService.updateSave(buffUserVouchers);
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
        Integer i = userVouchersService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
