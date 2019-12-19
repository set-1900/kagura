package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffVpn;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.VersionService;
import com.bahu.buffzs.service.VpnService;
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
@RequestMapping("/vpn")
public class VpnController {

    @Autowired
    private VpnService vpnService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffVpnList = vpnService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("vpn_list");
        model.addObject("vpn", buffVpnList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/vpn_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffVpn buffVpn) {
        if (buffVpn != null) {
            Integer i = vpnService.save(buffVpn);
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
        BuffVpn buffVpn = vpnService.findById(id);
        ModelAndView model = new ModelAndView("/vpn_update");
        model.addObject("vpn", buffVpn);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffVpn buffVpn) {
        if (buffVpn != null) {
            Integer i = vpnService.updateSave(buffVpn);
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
        Integer i = vpnService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}
