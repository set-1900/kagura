package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: buffzs_admin
 * @description: 导航控制类
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/

@Slf4j
@Controller
@RequestMapping("/module")
public class ModuleController {
    protected static final Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent( @RequestParam("current") Integer current, @RequestParam("size") Integer size ,Integer moduleType) {
        PageBean buffModuleList = moduleService.findAll(current, size ,moduleType);
        ModelAndView model = new ModelAndView();
        model.setViewName("module_list");
        model.addObject("module", buffModuleList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/module_edit");
  /*      List<BuffModule> moduleList = moduleService.find();
        model.addObject("module",moduleList);*/

        List<BuffModule> modules = moduleService.queryByPIdAndType(0,1);
        model.addObject("module",modules);
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffModule buffModule) {
        if (buffModule != null) {
            Integer i = moduleService.save(buffModule);
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
        BuffModule buffModule = moduleService.findById(id);
        ModelAndView model = new ModelAndView("/module_update");
        model.addObject("module", buffModule);

        List<BuffModule> buffModules = moduleService.find();
        model.addObject("buffModules", buffModules);

        List<BuffModule> modules = moduleService.queryByPId(0);
        model.addObject("module1",modules);

        List<BuffModule> buffModules1 = null;
        if (buffModule.getPid() != 0){
            buffModules1 = moduleService.queryByPId(buffModule.getPid());
        }
        model.addObject("module2", buffModules1);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffModule buffModule ) {
        if (buffModule != null) {
            Integer i = moduleService.updateSave(buffModule);
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
        Integer i = moduleService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    /**
    * @Description:
    * @Param: [pid]
    * @return: com.bahu.buffzs.pojo.dto.Result
    * @Author: Mr.Baron
    * @Date: 2019/9/17
    */
    @ResponseBody
    @RequestMapping(value = "/queryByPId")
    public Result queryByPId(Integer pid) {
        List<BuffModule> moduleList = moduleService.queryByPId(pid);
        return Result.success(moduleList);
    }

    @ResponseBody
    @RequestMapping(value = "/find")
    public Result findByName(String name ) {
        List<BuffModule> moduleList = moduleService.findByName(name);
        return Result.success(moduleList);
    }

    /**
     *
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryByPIdAndType")
    public Result queryByPIdAndType(Integer pid) {
        List<BuffModule> moduleList = moduleService.queryByPIdAndType(pid,1);
        return Result.success(moduleList);
    }
}
