package com.bahu.buffzs.pojo.util;

import java.io.File;
import java.util.Properties;

/**
 * @Description: 打包工具: 将文件赋值到指定路径,再将channelNum打入拷贝包中,再根据请求host生成链接
 * @Author: XieXiang
 * @Date: 2019/12/11
 * @Version: 1.0
 **/

public class Packaging {
    private String channelNum;
    private String srcUrl;
    private String host;
    private String desUrl;
    private String link;
    private File desFile;

    public Packaging(String channelNum, String srcUrl, String host, String desUrl) {
        this.channelNum = channelNum;
        this.srcUrl = srcUrl;
        this.host = host;
        this.desUrl = desUrl;
    }

    public String getLink() {
        return link;
    }

    public File getDesFile() {
        return desFile;
    }

    public Packaging invoke() throws Exception {
        Properties properties = System.getProperties();
        String os = properties.getProperty("os.name");
        if (os.indexOf("Windows") == -1) {
            link = "http://" + host + desUrl;
            this.link = link;
        } else {
            srcUrl = "d:" + srcUrl;
            link = "http://localhost:8081" + desUrl;
            desUrl = "d:" + desUrl;
            this.link = link;
        }
        desFile = new File(desUrl);
        // 复制到目标文件夹
        MCPTool.nioTransferCopy(new File(srcUrl), desFile);
        // 打包注释
        MCPTool.write(desFile, channelNum, null);
        return this;
    }
}
