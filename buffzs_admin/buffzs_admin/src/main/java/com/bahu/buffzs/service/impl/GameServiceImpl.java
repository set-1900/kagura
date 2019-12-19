package com.bahu.buffzs.service.impl;


import com.bahu.buffzs.mapper.GameMapper;
import com.bahu.buffzs.mapper.LabelMapper;
import com.bahu.buffzs.mapper.ModuleMapper;
import com.bahu.buffzs.pojo.BuffGame;
import com.bahu.buffzs.pojo.BuffLabel;
import com.bahu.buffzs.pojo.BuffModule;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.GameService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
@Transactional
public class GameServiceImpl implements GameService {
    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public PageBean findAll(Integer current, Integer size, String name) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffGame> gameList = gameMapper.findAll(name);

        for (BuffGame buffGame : gameList) {
            StringBuilder sb = new StringBuilder();
            List<BuffLabel> buffLabelList = labelMapper.findByGameId(buffGame.getId());
            if (buffLabelList.size() > 0) {
                for (int i = 0; i < buffLabelList.size(); i++) {
                    if (i < buffLabelList.size() - 1) {
                        sb.append(buffLabelList.get(i).getName() + ",");
                    } else {
                        sb.append(buffLabelList.get(i).getName());
                    }
                }
                buffGame.setLabelName(sb.toString());
            }

            StringBuilder sb2 = new StringBuilder();
            List<BuffModule> moduleList = moduleMapper.findByGameId(buffGame.getId());
            if (moduleList.size() > 0) {
                for (int i = 0; i < moduleList.size(); i++) {
                    if (i < moduleList.size() - 1) {
                        sb2.append(moduleList.get(i).getName() + ",");
                    } else {
                        sb2.append(moduleList.get(i).getName());
                    }
                }
                buffGame.setModule(sb2.toString());
            }
        }

        PageInfo<BuffGame> pageInfo = new PageInfo<>(gameList);
        PageBean<BuffGame> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(gameList);
        return pageBean;
    }

    @Override
    public Integer save(BuffGame buffGame) {
        return gameMapper.save(buffGame);
    }

    @Override
    public Integer delete(Integer id) {
        Integer a = labelMapper.deleteByGameId(id);
        int i = moduleMapper.deleteByGameId(id);

        BuffGame game = gameMapper.findById(id);
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        String path = "";
        if (name.indexOf("Windows") == -1) {
            path = "/img";
        } else {
            path = "D:/img";
        }

        String[] imgs = game.getIcon().split("img");
        File file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_h().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_v1().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_v2().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_v3().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_v4().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_v5().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getPic_v6().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        imgs = game.getDownloadUrl().split("img");
        file = new File(path + imgs[imgs.length - 1]);
        if (file.isFile() && file.exists()) {
            file.delete();
        }


        return gameMapper.delete(id);
    }


    @Override
    public BuffGame findById(Integer id) {
        BuffGame game = gameMapper.findById(id);
        List<BuffLabel> buffLabels = labelMapper.findByGameId(id);
        ArrayList<Object> list = new ArrayList<>();
        for (BuffLabel label : buffLabels) {
            list.add(label.getId());
        }
        game.setLabelId(list);

        List<BuffModule> modules = moduleMapper.findByGameId(id);
        ArrayList<Object> moduleList = new ArrayList<>();
        for (BuffModule module : modules) {
            moduleList.add(module.getId());
        }
        game.setModuleId(moduleList);
        return game;
    }

    @Override
    public Integer updateSave(BuffGame buffGame) {
        BuffGame game = gameMapper.findById(buffGame.getId());
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        String path = "";
        String[] imgs = null;
        File file = null;
        if (name.indexOf("Windows") == -1) {
            path = "/img";
        } else {
            path = "D:/img";
        }

        if (!buffGame.getIcon().equals(game.getIcon())  && StringUtils.isNotBlank(game.getIcon())  ) {
            imgs = game.getIcon().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_h().equals(game.getPic_h()) && StringUtils.isNotBlank(game.getPic_h())) {
            imgs = game.getPic_h().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_v1().equals(game.getPic_v1()) && StringUtils.isNotBlank(game.getPic_v1())) {
            imgs = game.getPic_v1().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_v2().equals(game.getPic_v2())  && StringUtils.isNotBlank(game.getPic_v2()) ) {
            imgs = game.getPic_v2().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_v3().equals(game.getPic_v3()) && StringUtils.isNotBlank(game.getPic_v3())) {
            imgs = game.getPic_v3().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_v4().equals(game.getPic_v4())  && StringUtils.isNotBlank(game.getPic_v4())) {
            imgs = game.getPic_v4().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_v5().equals(game.getPic_v5())  && StringUtils.isNotBlank(game.getPic_v5())) {
            imgs = game.getPic_v5().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getPic_v6().equals(game.getPic_v6())  && StringUtils.isNotBlank(game.getPic_v6()) ) {
            imgs = game.getPic_v6().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (!buffGame.getDownloadUrl().equals(game.getDownloadUrl())  && StringUtils.isNotBlank(game.getDownloadUrl())) {
            imgs = game.getDownloadUrl().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        return gameMapper.updateSave(buffGame);
    }

    /**
     * @param buffGame
     * @return
     */
    @Override
    public List<BuffGame> selectGameByName(BuffGame buffGame) {
        if (buffGame.getName() != null && !buffGame.getName().equals("")) {
            List<BuffGame> buffGameList = gameMapper.selectGameByName(buffGame.getName());
            if (buffGameList.size() > 0) {
                return buffGameList;
            }
        }
        return null;
    }


    /**
     * @param gameId
     * @return
     */
    @Override
    public int deleteByGameId(Integer gameId) {
        int a = gameMapper.deleteByGameId(gameId);
        return a;
    }
}