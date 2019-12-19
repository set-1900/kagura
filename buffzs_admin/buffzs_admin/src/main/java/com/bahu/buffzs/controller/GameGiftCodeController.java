package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffGameGift;
import com.bahu.buffzs.pojo.BuffGameGiftCode;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.GameGiftCodeService;
import com.bahu.buffzs.service.GameGiftService;
import com.bahu.buffzs.service.VersionService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Controller
@RequestMapping("/gameGiftCode")
public class GameGiftCodeController {

    @Autowired
    private GameGiftCodeService gameGiftCodeService;

    @Autowired
    private GameGiftService gameGiftService;


    @ResponseBody
    @RequestMapping(value = "/list")
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageBean buffBannerList = gameGiftCodeService.findAll(current, size);
        ModelAndView model = new ModelAndView();
        model.setViewName("gameGiftCode_list");
        model.addObject("gameGiftCode", buffBannerList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/gameGiftCode_edit");
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave" ,method = RequestMethod.POST)
    public Result dosave(BuffGameGiftCode buffGameGiftCode) {
        if (buffGameGiftCode != null) {
            buffGameGiftCode.setStatus("0");
            Integer i = gameGiftCodeService.save(buffGameGiftCode);
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
        BuffGameGiftCode buffGameGiftCode = gameGiftCodeService.findById(id);
        ModelAndView model = new ModelAndView("/gameGiftCode_update");
        model.addObject("gameGiftCode", buffGameGiftCode);
        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave",method = RequestMethod.POST)
    public Result updateSave(BuffGameGiftCode buffGameGiftCode) {
        if (buffGameGiftCode != null) {
            Integer i = gameGiftCodeService.updateSave(buffGameGiftCode);
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
        Integer i = gameGiftCodeService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    /**
    * @Author: XieXiang
    * @Description:  批量导入
    * @Date: 2019/12/18
    * @Param: [file, unique_id]
    * @return: com.bahu.buffzs.pojo.dto.Result
    **/
    @ResponseBody
    @RequestMapping(value = "/batchImport")
    public Result batchImport(@ApiParam("上传的文件") MultipartFile file, String unique_id) throws Exception {
        String filename = file.getOriginalFilename();
        gameGiftCodeService.batchImport(file, unique_id);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "/findAll")
    public List<BuffGameGift> findAll() {
        return gameGiftService.findAll();
    }

}
