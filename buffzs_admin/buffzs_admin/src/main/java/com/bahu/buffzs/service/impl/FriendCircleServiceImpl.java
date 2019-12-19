package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.FriendCircleMapper;
import com.bahu.buffzs.mapper.VersionMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffCircleOfFriends;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.service.FriendCircleService;
import com.bahu.buffzs.service.VersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Transactional
@Service
public class FriendCircleServiceImpl implements FriendCircleService {
    @Autowired
    private FriendCircleMapper friendCircleMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffCircleOfFriends>  buffApkVersionList =  friendCircleMapper.findAll();
        PageInfo<BuffCircleOfFriends> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffCircleOfFriends> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffCircleOfFriends findById(Integer id) {
        BuffCircleOfFriends buffApkVersion = friendCircleMapper.findById(id);
        return buffApkVersion;
    }

    @Override
    public Integer save(BuffCircleOfFriends buffCircleOfFriends) {
        return friendCircleMapper.save(buffCircleOfFriends);
    }

    @Override
    public Integer updateSave(BuffCircleOfFriends buffCircleOfFriends) {
        return friendCircleMapper.updateSave(buffCircleOfFriends);
    }

    @Override
    public Integer delete(Integer id) {
        BuffCircleOfFriends circleOfFriends = friendCircleMapper.findById(id);

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

        if (StringUtils.isNotBlank(circleOfFriends.getImg1())){
            imgs = circleOfFriends.getImg1().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (StringUtils.isNotBlank(circleOfFriends.getImg2())){
            imgs = circleOfFriends.getImg2().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (StringUtils.isNotBlank(circleOfFriends.getImg3())){
            imgs = circleOfFriends.getImg3().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (StringUtils.isNotBlank(circleOfFriends.getImg4())){
            imgs = circleOfFriends.getImg4().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (StringUtils.isNotBlank(circleOfFriends.getImg5())){
            imgs = circleOfFriends.getImg5().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }


        if (StringUtils.isNotBlank(circleOfFriends.getImg6())){
            imgs = circleOfFriends.getImg6().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        if (StringUtils.isNotBlank(circleOfFriends.getImg7())){
            imgs = circleOfFriends.getImg7().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }


        if (StringUtils.isNotBlank(circleOfFriends.getImg8())){
            imgs = circleOfFriends.getImg8().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }


        if (StringUtils.isNotBlank(circleOfFriends.getImg9())){
            imgs = circleOfFriends.getImg9().split("img");
            file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }

        return friendCircleMapper.delete(id);
    }
}
