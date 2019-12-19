package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.*;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.BuffSubchannelKeyword;
import com.bahu.buffzs.pojo.dto.BuffPromotionPageDto;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.util.FileUtil;
import com.bahu.buffzs.pojo.util.MCPTool;
import com.bahu.buffzs.pojo.util.ZipUtil;
import com.bahu.buffzs.service.VersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-11
 **/

@Transactional
@Slf4j
@Service
public class VersionServiceImpl implements VersionService {
    @Autowired
    private VersionMapper versionMapper;

    @Autowired
    private ApkVersionMapper apkVersionMapper;

    @Autowired
    private KeywordMapper keywordMapper;

    @Autowired
    private SubchannelMapper subchannelMapper;

    @Autowired
    private SubchannelKeywordMapper subchannelKeywordMapper;


    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current, size == null ? 10 : size);
        List<BuffApkVersion> buffApkVersionList = versionMapper.findAll();
        PageInfo<BuffApkVersion> pageInfo = new PageInfo<>(buffApkVersionList);
        PageBean<BuffApkVersion> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffApkVersion findById(Integer id) {
        BuffApkVersion buffApkVersion = versionMapper.findById(id);
        return buffApkVersion;
    }

    @Override
    public Integer save(BuffApkVersion buffApkVersion) {
        log.info("buffApkVersion={}", buffApkVersion);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());
        if (buffApkVersion.getApkType() == 3) {
            Properties properties = System.getProperties();
            String name = properties.getProperty("os.name");
            if (buffApkVersion.getApkType() == 3 && name.indexOf("Windows") == -1) {
                String src = "/img/apkVersion/" + s + "gamePlugin.zip";
                String path = "/img/";
                String[] imgs = buffApkVersion.getDownurl().split("img");
                String path1 = path + imgs[imgs.length - 1];

                String[] imgs2 = buffApkVersion.getDownurl2().split("img");
                String path2 = path + imgs2[imgs.length - 1];

                File file1 = new File(path1);
                File file2 = new File(path2);
                if (file1.isFile() && file1.exists() && file2.isFile() && file2.exists()) {
                    List<File> srcFiles = new ArrayList<>();
                    srcFiles.add(file1);
                    srcFiles.add(file2);
                    ZipUtil.zipFile(src, srcFiles);
                    buffApkVersion.setDownurl(imgs[0] + src);
                }
                return versionMapper.save(buffApkVersion);

            } else {
                String path = "D:/img/";
                // 路径为文件且不为空则进行删除
                String src = "D:/img/apkVersion/" + s + "/gamePlugin.zip";

                String[] imgs = buffApkVersion.getDownurl().split("img");
                String path1 = path + imgs[imgs.length - 1];

                String[] imgs2 = buffApkVersion.getDownurl2().split("img");
                String path2 = path + imgs2[imgs.length - 1];

                File file1 = new File(path1);
                File file2 = new File(path2);

                if (file1.isFile() && file1.exists() && file2.isFile() && file2.exists()) {
                    List<File> srcFiles = new ArrayList<>();
                    srcFiles.add(file1);
                    srcFiles.add(file2);
                    ZipUtil.zipFile(src, srcFiles);
                    buffApkVersion.setDownurl(imgs[0] + "img/apkVersion/" + s + "/gamePlugin.zip");
                }
                return versionMapper.save(buffApkVersion);
            }
        } else {
            return versionMapper.save(buffApkVersion);
        }

    }


    @Override
    public Integer updateSave(BuffApkVersion buffApkVersion) {
        buffApkVersion.setUpdateTime(new Date());
        return versionMapper.updateSave(buffApkVersion);
    }

    @Override
    public Integer delete(Integer id) {
        BuffApkVersion version = versionMapper.findById(id);
        String url = version.getDownurl();
        if (url != null && url != ""){
            FileUtil.delFile(url);
        }
        return versionMapper.delete(id);
    }

    /*/**
    * @Author: baron.Mr
    * @Description:  后台打包
    * @Date: 2019/12/6
    * @Param: [promotionPageDto]
    * @return: java.lang.Integer
    **/
    @Override
    public Integer createApk(BuffPromotionPageDto promotionPageDto){
        String channelId = promotionPageDto.getChannelId();
        String subchannelId = promotionPageDto.getSubchannelId();
        String keywordName = promotionPageDto.getKeywordName();
        Date date = new Date();

        BuffSubchannel subchannel = subchannelMapper.findById(subchannelId);

        BuffKeyword keyword = keywordMapper.findByName(keywordName);

        // 关键字判断,无则创建
        if (keyword == null) {
            BuffKeyword keyword1 = new BuffKeyword();
            keyword1.setName(keywordName);
            keyword1.setCreateTime(new Date());
            keywordMapper.save(keyword1);
            keyword = keywordMapper.findByName(keywordName);
            // 创建关键字子渠道中间表的一条记录
            setSubchannelKeyword(date, subchannel, keyword);
        }
        // 如果根据关键字id不能从子渠道关键字中间表查询到数据则设置一条数据
        if (subchannelKeywordMapper.findBySubchannelIdAndKeywordId(subchannel.getId().toString(),keyword.getId().toString()) == null) {
            setSubchannelKeyword(date, subchannel, keyword);
        }
        String channelNum = channelId + "_" + subchannelId + "_" + keyword.getId();
        // 如果已存在这个apk,就返回已存在的apk
        BuffApkVersion judgeApk = apkVersionMapper.findByChannelNum(channelNum);
        if (judgeApk != null) {
            return 1;
        }
        // apk不存在,
        BuffApkVersion apkVersion = apkVersionMapper.findByChannelNum("0_0_0");
        //创建文件路径
        //获取本机IP
        String host = "";
        Properties properties = System.getProperties();
        String osName = properties.getProperty("os.name");
        System.out.println("当前系统是:" + osName);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String[] urlArr = apkVersion.getDownurl().split("/");
        String fileName = urlArr[urlArr.length-1];
        String srcUrl = apkVersion.getDownurl().substring(apkVersion.getDownurl().indexOf("/img"), apkVersion.getDownurl().length());
        String apkurl = "";
        String downUrl = "";
        if (osName.indexOf("Windows") == -1) {
            host = request.getServerName();
            System.out.println("域名:---" + host);
            //host = "http://api.buffzs.com";
            apkurl = "/img/apk/" + subchannel.getName() + "/" + fileName;
            downUrl = "http://" + host + apkurl;
            System.out.println("Linux---addressApk = " + downUrl);
        } else {
            System.out.println("域名:---" + request.getRequestURL());
            srcUrl = "D:" + srcUrl;
            apkurl = "D:/img/apk/" + subchannel.getName() + "/" + fileName;
            downUrl = "http://localhost:8081/img/apk/" + subchannel.getName() + "/" + fileName;
            System.out.println("Windows---addressApk = " + downUrl);
        }
        File srcFile = new File(srcUrl);
        File desFile = new File(apkurl);
        try {
            MCPTool.nioTransferCopy(srcFile, desFile);
            MCPTool.write(desFile, channelNum, null);
        } catch (Exception e) {
            System.out.println("复制文件或写入数据时出现异常");
            e.printStackTrace();
        }
        // 数据库buff_apk_version保存记录
        BuffApkVersion buffApkVersion = new BuffApkVersion();
        buffApkVersion.setName(apkVersion.getName() + channelNum);
        buffApkVersion.setCode(1);
        buffApkVersion.setVersion("1.0");
        buffApkVersion.setDownurl(downUrl);
        buffApkVersion.setCreateTime(date);
        buffApkVersion.setUpdateIfForce(0);
        buffApkVersion.setApkType(1);
        buffApkVersion.setChannelNum(channelNum);
        buffApkVersion.setUpdateTime(date);
        apkVersionMapper.save(buffApkVersion);
        return 2;
    }

    private void responseApk(HttpServletResponse response, File desFile) throws IOException {
        BufferedInputStream bis = null;
        OutputStream bos = null;
        try {
            bos = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(desFile));
            byte[] buff = new byte[4096];
            int i = 0;
            while ((i = bis.read(buff)) != -1) bos.write(buff, 0, i);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) bis.close();
            if (bos != null) bos.close();
        }
    }

    private void setSubchannelKeyword(Date date, BuffSubchannel subchannel, BuffKeyword keyword) {
        BuffSubchannelKeyword subchannelKeyword = new BuffSubchannelKeyword();
        subchannelKeyword.setSubchannelId(subchannel.getId().toString());
        subchannelKeyword.setKeywordId(keyword.getId().toString());
        subchannelKeyword.setCreateTime(date);
        subchannelKeywordMapper.save(subchannelKeyword);
    }
}
