package com.bahu.buffzs.pojo.util;

import com.bahu.buffzs.mapper.ApkVersionMapper;
import com.bahu.buffzs.pojo.BuffApkVersion;
import com.bahu.buffzs.service.ApkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static freemarker.log._Log4jOverSLF4JTester.test;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/12/10
 * @Version: 1.0
 **/

@Slf4j
@Controller
@RequestMapping("/apkUtils")
public class ApkUtils {

    @Autowired
    private ApkVersionMapper apkVersionMapper;

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()));
        String oldDownurl = "http://admin-test.buffzs.com/img/apk/buff/buff/8_8_49_20191206105326.apk";
        String srcUrl = oldDownurl.substring(oldDownurl.indexOf("/img"), oldDownurl.length());
        System.out.println("srcUrl: " + srcUrl);
        String desUrl = srcUrl.substring(0, srcUrl.lastIndexOf("/") + 1) + "1_2_3" + "_" + new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()) + ".apk";
        System.out.println("desUrl: " + desUrl);
    }

    @RequestMapping("/updateApk")
    public String updateApk() throws Exception {
        String channelNum = "";
        String oldDownurl = "";
        String srcUrl = "";
        String desUrl = "";
        String link = "";
        // 1.查找母包
        BuffApkVersion baseApk = apkVersionMapper.findByChannelNum("0_0_0");
        Properties properties = System.getProperties();
        // 2.将表中downurl移到oldDownurl
        Integer i = apkVersionMapper.updateOldDownurl();
        log.info("oldDownurl更新了 " + i + " 条数据!!!");
        // 3.查询出所有要替换的apk
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String host = request.getServerName();
        List<BuffApkVersion> apkList = apkVersionMapper.findChangeApk();
        for (BuffApkVersion apkVersion : apkList) {
            channelNum = apkVersion.getChannelNum();
            oldDownurl = apkVersion.getOldDownurl();
            srcUrl = baseApk.getDownurl();
            srcUrl = srcUrl.substring(srcUrl.indexOf("/img"), srcUrl.length());
            // 获取原始url
            desUrl = oldDownurl.substring(oldDownurl.indexOf("/img"), oldDownurl.length());
            desUrl = desUrl.substring(0, desUrl.lastIndexOf("/") + 1);
            desUrl += channelNum + "_" + new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()) + ".apk";
            // 4.重打包
            Packaging packaging = new Packaging(channelNum, srcUrl, host, desUrl).invoke();
            link = packaging.getLink();
            // 5.设置新的downurl
            apkVersionMapper.updateDownurl(link, channelNum);
            // 6.将oldDownurl对应的老apk删除
            // if (srcUrl != null) FileUtil.delFile(srcUrl);
        }
        // 7.将所有oldDown删掉
        // Integer y = apkVersionMapper.deleteOldDownurl();
        // log.info("删除掉了oldDownurl " + i + " 个!!!");
        return "成功 OR 失败, 需自己看!!!";
    }

}
