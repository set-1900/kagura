package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.KeywordService;
import com.bahu.buffzs.service.VersionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/keyword")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @ResponseBody
    @RequestMapping(value = "/findBySubchannelId")
    public Result findBySubchannelId(@Param("subchannelId")String subchannelId) {
        List<BuffKeyword> keywords = keywordService.findBySubchannelId(subchannelId);
        return Result.success(keywords);
    }



}
