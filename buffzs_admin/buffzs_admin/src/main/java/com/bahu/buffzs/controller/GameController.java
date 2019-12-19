package com.bahu.buffzs.controller;

import com.bahu.buffzs.mapper.LabelMapper;
import com.bahu.buffzs.pojo.*;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.service.*;
import lombok.extern.slf4j.Slf4j;
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
 * @description: 游戏
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/
@Slf4j
@Controller
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private GenresService genresService;

    @Autowired
    private GameCountryService gameCountryService;

    @Autowired
    private PluginService pluginService;

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private  HotIconService hotIconService;

    @ResponseBody
    @RequestMapping(value = "/list" )
    public ModelAndView agent(@RequestParam("current") Integer current, @RequestParam("size") Integer size, String name) {
        PageBean buffGameList = gameService.findAll(current, size,name);
        ModelAndView model = new ModelAndView();
        model.setViewName("game_list");
        model.addObject("game", buffGameList);
        return model;
    }

    //增加页
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("/game_edit");
        List<BuffLabel> buffLabelList = labelService.findAll();
        List<BuffGameGenres> genresList = genresService.findAll();
        List<BuffModule> moduleList = moduleService.queryByPIdAndType(null, 2);
        List<BuffGameCountry> buffGameCountryList = gameCountryService.findAll();
        model.addObject("labelList", buffLabelList);
        model.addObject("genresList", genresList);
        model.addObject("moduleList", moduleList);
        model.addObject("countryList", buffGameCountryList);
        List<BuffGameIcon> gameIcons = hotIconService.findAll();
        model.addObject("gameIcons", gameIcons);
        return model;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "/dosave")
    public Result dosave(BuffGame buffGame) {
        String module = buffGame.getModule();
        buffGame.setModule("0");
        if (buffGame != null) {
            buffGame.setIfquestion(0);
            buffGame.setPluginid(0);

            Integer i = gameService.save(buffGame);

            String[] s = buffGame.getLabel().split(",");
            if (s.length == 1) {
                labelService.save(buffGame.getId(), s[0]);
            } else {
                for (String s1 : s) {
                    labelService.save(buffGame.getId(), s1);
                }
            }

            String[] modules = module.split(",");
            if (modules.length == 1) {
                moduleService.saveGameModule(buffGame.getId(), modules[0]);
            } else {
                for (String s2 : modules) {
                    moduleService.saveGameModule(buffGame.getId(), s2);
                }
            }
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
        Integer i = gameService.delete(id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    //修改页
    @ResponseBody
    @RequestMapping(value = "/update")
    public ModelAndView editPass(Integer id) {
        BuffGame buffGame = gameService.findById(id);
        String label = "";


        ModelAndView model = new ModelAndView("/game_update");
        model.addObject("game", buffGame);

        List<BuffLabel> buffLabels = labelMapper.findByGameId(id);
        model.addObject("gameLabel", buffLabels);
        for (BuffLabel buffLabel : buffLabels) {
            label += buffLabel.getId() + ",";
        }
        buffGame.setLabel(label);

        List<BuffLabel> labelList = labelService.findAll();
        model.addObject("label", labelList);
        ;

        List<BuffGameGenres> genresList = genresService.findAll();
        model.addObject("genresList", genresList);


        List<BuffModule> moduleList = moduleService.queryByPId(0);
        model.addObject("module1", moduleList);


        //BuffModule byId = moduleService.findById(buffGame.getModule());
        //model.addObject("byId", byId);

        List<BuffGameCountry> buffGameCountryList = gameCountryService.findAll();
        model.addObject("countryList", buffGameCountryList);


        /*List<BuffModule> buffModules1 = null;
        if (byId.getPid() != 0) {
            buffModules1 = moduleService.queryByPId(byId.getPid());
        }
        model.addObject("module2", buffModules1);*/


        String module = "";
        List<BuffModule> modules = moduleService.findByGameId(id);
        model.addObject("gameLabel", buffLabels);
        for (BuffModule buffModule : modules) {
            module += buffModule.getId() + ",";
        }
        buffGame.setModule(module);

        List<BuffModule> buffModuleList = moduleService.queryByPIdAndType(null, 2);
        model.addObject("gameModule", buffModuleList);

        List<BuffGameIcon> gameIcon = hotIconService.findAll();
        model.addObject("gameIcon", gameIcon);

        return model;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateSave")
    public Result updateSave(BuffGame buffGame) {
        Integer i = null;
        Integer a = null;
        Integer b = null;
        Integer c = null;

        if (buffGame != null) {
            i = gameService.updateSave(buffGame);
            a = gameService.deleteByGameId(buffGame.getId());
            c = moduleService.deleteByGameId(buffGame.getId());
        }

        if (buffGame.getLabel() != null && buffGame.getLabel() != ""){
            String[] s = buffGame.getLabel().split(",");
            if (s.length == 1) {
                labelService.save(buffGame.getId(), s[0]);
            } else {
                for (String s1 : s) {
                    labelService.save(buffGame.getId(), s1);
                }

            }
        }


        String module = buffGame.getModule();
        if (module != null && module != ""){
            String[] modules = module.split(",");
            if (modules.length == 1) {
                moduleService.saveGameModule(buffGame.getId(), modules[0]);
            } else {
                for (String s2 : modules) {
                    moduleService.saveGameModule(buffGame.getId(), s2);
                }
            }
        }


        if (i != null && a != null &&  c != null) {
            return Result.success("修改成功");
        }
        return Result.error();
    }



    @ResponseBody
    @RequestMapping(value = "/selectLabel")
    public Result selectLabel() {
        List<BuffLabel> buffLabelList = labelService.findAll();
        return Result.success(buffLabelList);
    }


    @ResponseBody
    @RequestMapping(value = "/selectGenres")
    public Result selectGenres() {
        List<BuffGameGenres> buffLabelList = genresService.findAll();
        return Result.success(buffLabelList);
    }

    @ResponseBody
    @RequestMapping(value = "/text")
    public ModelAndView text() {
        ModelAndView model = new ModelAndView("/text1");
        return model;
    }

    //查询游戏
    @ResponseBody
    @RequestMapping(value = "/selectGame")
    public Result selectGame(BuffGame buffGame) {
        List<BuffGame> buffGameList = gameService.selectGameByName(buffGame);
        return Result.success(buffGameList);
    }


}
