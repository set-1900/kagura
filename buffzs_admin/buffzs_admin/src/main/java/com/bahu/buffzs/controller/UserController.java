package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffArea;
import com.bahu.buffzs.pojo.BuffBanner;
import com.bahu.buffzs.pojo.BuffUser;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.BannerService;
import com.bahu.buffzs.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size,String username,String phone) {
        PageBean user = userService.findAll(current, size,username,phone);
        ModelAndView model = new ModelAndView();
        model.setViewName("user_list");
        model.addObject("user", user);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        Result area = userService.findArea();
        ModelAndView model = new ModelAndView("/user_edit");
        model.addObject("area",area);
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffUser buffUser) {
        if (buffUser != null) {
            Integer i = userService.save(buffUser);
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
        BuffUser buffUser = userService.findById(id);
        ModelAndView model = new ModelAndView("/user_update");
        model.addObject("user", buffUser);

        Result area = userService.findArea();
        model.addObject("area",area);

        Result city = userService.findCity(buffUser.getProvince());
        model.addObject("city",city);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffUser buffUser) {
        if (buffUser != null) {
            Integer i = userService.updateSave(buffUser);
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
        Integer i = userService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    /**
     * 查询市
     * @param
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "查询市")
    @ApiImplicitParam(name = "name", value = "省名称", required = true, paramType = "query", dataType = "String")
    @RequestMapping(value = "/findCity", method = RequestMethod.POST)
    public Result<BuffArea> findCity(@RequestParam String name) {
        return userService.findCity(name);
    }


}
