package com.bahu.buffzs.pojo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ContextLoadsUtils {
    public static void main(String[] args) {
        String filePath = "E:\\about\\mobile.html";
        String text ="http://admin-test.buffzs.com/img/apkVersion/2019-11-20/75e35c99-ff5a-4bf7-973b-a616c43a91b7997.apk";
        String disrPath = "E:\\about\\templates";
        String fileName = "tmp";
        MakeHtml(filePath,text,disrPath,fileName);
    }


    /**
    * filePath 模板地址; text 用户上传图片保存地址; disrPath 生成推广页保存地址; fileName 推广页名称
    **/
    public static void MakeHtml(String filePath,String customerPicAdd,String disrPath,String fileName ){
        try {
            System.out.print(filePath);
            String templateContent = "";
            FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
//            System.out.print(templateContent);
//把模板页面上的 ###text### 替换成 title 里的内容
            templateContent = templateContent.replaceAll("HTMLTEMPLATE", customerPicAdd);
            //System.out.print(templateContent);

            String fileame = fileName;
            fileame = disrPath+"/" + fileame;// 生成的html文件保存路径。
            System.out.println("文件路径" + fileame);
            File file = new File(fileame);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
            System.out.print("文件输出路径:");
            System.out.print(fileame);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    /**
     * filePath 模板地址; customerPicAdd 替换图片地址; disrPath 生成推广页保存地址; fileName 推广页名称
     **/
    public static void MakeHtml2(String filePath,String customerPicAdd,String disrPath,String fileName, String subchannelName){
        try {
            System.out.print(filePath);
            String templateContent = "";
            FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
//            System.out.print(templateContent);
//把模板页面上的 ###text### 替换成 title 里的内容
            templateContent = templateContent.replace("HTMLTEMPLATE", customerPicAdd).replace("SUBCHANNELNAME", subchannelName);
            //System.out.print(templateContent);

            String fileame = fileName;
            fileame = disrPath+"/" + fileame;// 生成的html文件保存路径。
            System.out.println("文件路径" + fileame);
            File file = new File(fileame);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
            System.out.print("文件输出路径:");
            System.out.print(fileame);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}

