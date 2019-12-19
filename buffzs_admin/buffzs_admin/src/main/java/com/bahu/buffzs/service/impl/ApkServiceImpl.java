package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.*;
import com.bahu.buffzs.pojo.*;
import com.bahu.buffzs.pojo.util.MCPTool;
import com.bahu.buffzs.pojo.util.Packaging;
import com.bahu.buffzs.service.ApkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/11/29
 * @Version: 1.0
 **/

@Transactional
@Slf4j
@Service
public class ApkServiceImpl implements ApkService {

    @Autowired
    private KeywordMapper keywordMapper;

    @Autowired
    private ApkVersionMapper apkVersionMapper;

    @Autowired
    private SubchannelMapper subchannelMapper;

    @Autowired
    private SubchannelKeywordMapper subchannelKeywordMapper;

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private RecommendMapper recommendMapper;

    @Autowired
    private VersionMapper versionMapper;

    /*/**
     * @Author: XieXiang
     * @Description:  分享页下载功能
     * @Date: 2019/12/6
     * @Param: [recommend, response]
     * @return: void
     **/
    @Override
    public void shareApk(BuffRecommend recommend, HttpServletResponse response) throws Exception {
        log.info("recommend={}", recommend);
        BuffChannel channel = channelMapper.findById(8);
        BuffSubchannel subchannel = subchannelMapper.findById("8");
        Date date = new Date();
        String keywordName = "";
        // 一. 打包时注释信息: 推荐信息,手机号,用户id,设备id为null时为8_8_1, 否则为8_8_加密信息保存后的关键字id
        String channelNum = "8_8_1";
        if ((recommend != null && recommend.getPhone() != null) && !recommend.getPhone().equals("")
                && (recommend != null && recommend.getUserId() != null) && !recommend.getUserId().equals("")
                && (recommend != null && recommend.getModulId() != null) && !recommend.getModulId().equals("")) {
            keywordName = recommend.getPhone() + recommend.getPhone() + recommend.getPhone();
            keywordName = DigestUtils.md5DigestAsHex(keywordName.getBytes());
            // 关键字不存在,则创建
            BuffKeyword keyword = keywordMapper.findByName(keywordName);
            // 关键字判断,无则创建
            if (keyword == null) {
                BuffKeyword keyword1 = new BuffKeyword();
                keyword1.setName(keywordName);
                keyword1.setCreateTime(date);
                keywordMapper.save(keyword1);
                keyword = keywordMapper.findByName(keywordName);
                // 创建关键字子渠道中间表的一条记录
                setSubchannelKeyword(date, subchannel, keyword);
            }
            // 如果根据关键字id不能从子渠道关键字中间表查询到数据则设置一条数据
            if (subchannelKeywordMapper.findBySubchannelIdAndKeywordId(subchannel.getId().toString(), keyword.getId().toString()) == null) {
                setSubchannelKeyword(date, subchannel, keyword);
            }
            channelNum = "8_8_" + keyword.getId();
        }
        // 二. apk存在时,直接返回
        BuffApkVersion apkVersion = apkVersionMapper.findByChannelNum(channelNum);
        String srcUrl = "";
        if (apkVersion != null) {
            srcUrl = apkVersion.getDownurl();
            // linux:/img/apk/xxx.apk;   windows:d:/img/apk/xxx.apk
            srcUrl = srcUrl.substring(srcUrl.indexOf("/img"), srcUrl.length());
            if (srcUrl.indexOf("localhost") == 1) srcUrl = "d:" + srcUrl;
            //responseApk(response, new File(srcUrl));
            // 不返回流,使用重定向
            response.sendRedirect(apkVersion.getDownurl());
            return;
        }
        // apk不存在时
        apkVersion = apkVersionMapper.findByChannelNum("0_0_0");
        // 获取当前系统, window系统生成下载链接为:http://localhost:8081/img/apk/8_8_加密_yyyyMMddHH.apk
        // linux系统生成下载链接为:http://域名/img/apk/8_8_加密.apk
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取访问域名
        String host = request.getServerName();
        srcUrl = apkVersion.getDownurl();
        srcUrl = srcUrl.substring(srcUrl.indexOf("/img"), srcUrl.length());
        String desUrl = "";
        String link = "";
        String date1 = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        String fileName = channelNum + "_" + date1 + ".apk";
        desUrl = "/img/apk/" + channel.getName() + "/" + subchannel.getName() + "/" + fileName;
        // 打包
        Packaging packaging = new Packaging(channelNum, srcUrl, host, desUrl).invoke();
        link = packaging.getLink();
        File desFile = packaging.getDesFile();
        // 三. 分享记录表记录一条数据
        recommend.setChannelNum(keywordName);
        recommend.setCreateTime(date);
        recommendMapper.save(recommend);
        // apk表添加一条记录,并返回apk包的流
        createApkVersion(response, date, channelNum, apkVersion, link, desFile);
    }

    /*/**
     * @Author: XieXiang
     * @Description:  推广页打包
     * @Date: 2019/12/6
     * @Param: [subchannelUrl, name, response]
     * @return: void
     **/
    @Override
    public void createAndSetSignApk(String subchannelUrl, String name, HttpServletResponse response) throws Exception {
        log.info("subchannelUrl={}", subchannelUrl);
        log.info("name={}", name);
        Date date = new Date();
        BuffSubchannel subchannel = subchannelMapper.findByUrl(subchannelUrl);
        BuffKeyword keyword = keywordMapper.findByName(name);

        BuffChannel channel = channelMapper.findById(subchannel.getChannelId());
        String channelName = channel.getName();
        // 关键字判断,无则创建
        if (keyword == null) {
            BuffKeyword keyword1 = new BuffKeyword();
            keyword1.setName(name);
            keyword1.setCreateTime(new Date());
            keywordMapper.save(keyword1);
            keyword = keywordMapper.findByName(name);
            // 创建关键字子渠道中间表的一条记录
            setSubchannelKeyword(date, subchannel, keyword);
        }
        // 如果根据关键字id不能从子渠道关键字中间表查询到数据则设置一条数据
        if (subchannelKeywordMapper.findBySubchannelIdAndKeywordId(subchannel.getId().toString(), keyword.getId().toString()) == null) {
            setSubchannelKeyword(date, subchannel, keyword);
        }
        String channelNum = subchannel.getChannelId() + "_" + subchannel.getId() + "_" + keyword.getId();
        // 如果已存在这个apk,就返回已存在的apk
        BuffApkVersion judgeApk = apkVersionMapper.findByChannelNum(channelNum);
        if (judgeApk != null) {
            String downUrl = judgeApk.getDownurl();
            String fileName = downUrl.substring(downUrl.lastIndexOf("/"), downUrl.length());
            String responseUrl = "/img/apk/" + channelName + "/" + subchannel.getName() + fileName;
            if (downUrl.contains("localhost"))
                responseUrl = "D:/img/apk/" + channelName + "/" + subchannel.getName() + fileName;
            //responseApk(response, new File(responseUrl));
            // 不返回流,使用重定向
            response.sendRedirect(downUrl);
            return;
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
        //String fileName = urlArr[urlArr.length-1];
        // 用渠道号 + 时间日期   作为文件名称 3_1_36_20191205.apk
        String yyyyMMdd = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        String fileName = channelNum + "_" + yyyyMMdd + ".apk";
        String srcUrl = apkVersion.getDownurl().substring(apkVersion.getDownurl().indexOf("/img"), apkVersion.getDownurl().length());
        String apkurl = "";
        String downUrl = "";
        if (osName.indexOf("Windows") == -1) {
            host = request.getServerName();
            System.out.println("域名:---" + host);
            //host = "http://api.buffzs.com";
            apkurl = "/img/apk/" + channelName + "/" + subchannel.getName() + "/" + fileName;
            downUrl = "http://" + host + apkurl;
            System.out.println("Linux---addressApk = " + downUrl);
        } else {
            System.out.println("域名:---" + request.getRequestURL());
            srcUrl = "D:" + srcUrl;
            apkurl = "D:/img/apk/" + channelName + "/" + subchannel.getName() + "/" + fileName;
            downUrl = "http://localhost:8081/img/apk/" + channelName + "/" + subchannel.getName() + "/" + fileName;
            System.out.println("Windows---addressApk = " + downUrl);
        }
        File srcFile = new File(srcUrl);
        File desFile = new File(apkurl);
        MCPTool.nioTransferCopy(srcFile, desFile);
        MCPTool.write(desFile, channelNum, null);
        // 数据库buff_apk_version保存记录
        createApkVersion(response, date, channelNum, apkVersion, downUrl, desFile);
    }

    /*/**
     * @Author: XieXiang
     * @Description:  数据库buff_apk_version保存记录, 并返回apk包
     * @Date: 2019/12/5
     * @Param: [response, date, channelNum, apkVersion, downUrl, desFile]
     * @return: void
     **/
    private void createApkVersion(HttpServletResponse response, Date date, String channelNum, BuffApkVersion apkVersion, String downUrl, File desFile) throws IOException {
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
        //        responseApk(response, desFile);
        // 不返回流,使用重定向
        response.sendRedirect(downUrl);
    }

    private void setSubchannelKeyword(Date date, BuffSubchannel subchannel, BuffKeyword keyword) {
        BuffSubchannelKeyword subchannelKeyword = new BuffSubchannelKeyword();
        subchannelKeyword.setSubchannelId(subchannel.getId().toString());
        subchannelKeyword.setKeywordId(keyword.getId().toString());
        subchannelKeyword.setCreateTime(date);
        subchannelKeywordMapper.save(subchannelKeyword);
    }

    private void responseApk(HttpServletResponse response, File srcFile) throws IOException {
        BufferedInputStream bis = null;
        OutputStream bos = null;
        try {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(srcFile.getName(), "UTF-8"));
            bos = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(srcFile));
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
}
