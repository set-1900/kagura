package com.bahu.buffzs.service;

import com.bahu.buffzs.pojo.BuffRecommend;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: XieXiang
 * @Date: 2019/11/29
 * @Version: 1.0
 **/

public interface ApkService {

    void createAndSetSignApk(String subchannelUrl, String keyword, HttpServletResponse response) throws IOException, Exception;

    void shareApk(BuffRecommend recommend, HttpServletResponse response) throws IOException, Exception;
}
