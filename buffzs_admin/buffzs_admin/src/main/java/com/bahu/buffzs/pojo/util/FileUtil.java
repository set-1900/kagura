package com.bahu.buffzs.pojo.util;


import com.alibaba.fastjson.JSONObject;
import com.bahu.buffzs.pojo.dto.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
@Api(description = "上传接口")
@Controller
public class FileUtil {

    @ResponseBody
    @ApiOperation(value = "图片上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "图片的位置comment,friend,problem,feedback,tools,banner,game,consultion,iconImg,version,advertising,tui_html", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/upload/image", method = RequestMethod.POST)
    public Result uploadImage(@ApiParam("上传的文件") MultipartFile file, HttpServletRequest request, String status) throws Exception {
        //返回上传的文件是否为空，即没有选择任何文件，或者所选文件没有内容。
        //防止上传空文件导致奔溃
        String position = "";
        if (status != null && status != "") {
            if (status.equals("comment")) {
                position = status;
            } else if (status.equals("friend")) {
                position = status;
            } else if (status.equals("problem")) {
                position = status;
            } else if (status.equals("feedback")) {
                position = status;
            } else if (status.equals("tools")) {
                position = status;
            } else if (status.equals("banner")) {
                position = status;
            } else if (status.equals("game")) {
                position = status;
            } else if (status.equals("consultion")) {
                position = status;
            } else if (status.equals("iconImg")) {
                position = status;
            } else if (status.equals("version")) {
                position = status;
            } else if (status.equals("advertising")) {
                position = status;
            } else if (status.equals("tui_html/pic")) { //推广页图片
                position = status;
            } else if (status.equals("htmlTemplate/pic")) { // 模板图片
                position = status;
            } else if (status.equals("iconUrl")) {   //  游戏火热图标
                position = status;
            }
        } else {
            log.info("error: ==", "选择文件夹");
            return Result.error();
        }

        if (file.isEmpty()) {
            log.info("error: ==", "文件为空");
            throw new NullPointerException("文件为空");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());

        // 设置文件上传后的路径
        String filePath = "/img/" + position + "/";
        // 获取文件名后缀名
        String suffix = file.getOriginalFilename();
        String prefix = suffix.substring(suffix.lastIndexOf(".") + 1);

        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String newFileName = UUID.randomUUID().toString() + randomFileName + "." + prefix;

        ///img/iconImg/2019-09-21/c5622b9b-714b-4372-aad7-487dc82c9b7e212.jpeg
        String url = filePath + s + "/" + newFileName;
        System.out.println("图片的URL: " + url);
        byte[] bytes = file.getBytes();
        uploadFile(bytes, filePath + s + "/", newFileName);
        String contextPath = request.getContextPath();
        //创建文件路径
        //获取本机IP
        String host = "";
        String addressImg = "";
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        System.out.println("当前系统是:" + name);
        if (name.indexOf("Windows") == -1) {
            host = request.getServerName();
            System.out.println("域名:---" + host);
            //host = "http://api.buffzs.com";
            addressImg = "http://" + host + contextPath + url;
            System.out.println("Linux---addressImg = " + addressImg);
        } else {
            System.out.println("域名:---" + request.getServerName());
            addressImg = "http://" + request.getServerName() + ":" + request.getServerPort() + contextPath + url;
            System.out.println("Windows---addressImg = " + addressImg);
        }
        return Result.success(addressImg);
    }


    @ResponseBody
    @ApiOperation(value = "富文本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "图片的位置comment,friend,problem,feedback,tools,banner,game,consultion", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/upload/richText", method = RequestMethod.POST)
    public String richText(@ApiParam("上传的文件") MultipartFile file, HttpServletRequest request, String status) throws Exception {
        //返回上传的文件是否为空，即没有选择任何文件，或者所选文件没有内容。
        //防止上传空文件导致奔溃
        String position = "";
        if (status != null && status != "") {
            if (status.equals("comment")) {
                position = status;
            } else if (status.equals("friend")) {
                position = status;
            } else if (status.equals("problem")) {
                position = status;
            } else if (status.equals("feedback")) {
                position = status;
            } else if (status.equals("tools")) {
                position = status;
            } else if (status.equals("banner")) {
                position = status;
            } else if (status.equals("game")) {
                position = status;
            } else if (status.equals("consultion")) {
                position = status;
            }
        } else {
            return "删除失败";
        }

        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());

        // 设置文件上传后的路径
        String filePath = "/img/" + position + "/";
        // 获取文件名后缀名
        String suffix = file.getOriginalFilename();
        String prefix = suffix.substring(suffix.lastIndexOf(".") + 1);

        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String newFileName = UUID.randomUUID().toString() + randomFileName + "." + prefix;

        ///img/iconImg/2019-09-21/c5622b9b-714b-4372-aad7-487dc82c9b7e212.jpeg
        String url = filePath + s + "/" + newFileName;
        System.out.println("图片的URL: " + url);
        byte[] bytes = file.getBytes();
        uploadFile(bytes, filePath + s + "/", newFileName);
        String contextPath = request.getContextPath();
        //创建文件路径
        //获取本机IP
        String host = "";
        String addressImg = "";
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        System.out.println("当前系统是:" + name);
        if (name.indexOf("Windows") == -1) {
            host = request.getServerName();
            System.out.println("域名:---" + host);
            //host = "http://api.buffzs.com";
            addressImg = "http://" + host + contextPath + url;
            System.out.println("Linux---addressImg = " + addressImg);
        } else {
            System.out.println("域名:---" + request.getServerName());
            addressImg = "http://" + request.getServerName() + ":" + request.getServerPort() + contextPath + url;
            System.out.println("Windows---addressImg = " + addressImg);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map.put("code", 0);//0表示成功，1失败
        map.put("msg", "上传成功");//提示消息
        map.put("data", map2);
        map2.put("src", addressImg);//图片url
        map2.put("title", newFileName);//图片名称，这个会显示在输入框里
        String result = new JSONObject(map).toString();
        return result;
    }


    //文件上传工具类服务方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }


    /**
     * apk文件上传
     *
     * @param file
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "apk文件上传")
    @RequestMapping(value = "/upload/file", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //文件上传相关代码
    public Result upload(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 文件上传后的路径
        String filePath = "/img/" + "apkVersion" + "/";

        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String newFileName = UUID.randomUUID().toString() + randomFileName + suffixName;

        // 设置文件上传后的路径
        String url = filePath + s + "/" + newFileName;
        System.out.println("文件的URL: " + url);


        String contextPath = request.getContextPath();
        //创建文件路径
        //获取本机IP
        String host = "";
        String addressImg = "";
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        System.out.println("当前系统是:" + name);
        try {
            //File targetFile = new File(filePath + s + "/");
            File targetFile = new File(filePath+s);
            /*if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
                targetFile.mkdirs();
            }*/
            //FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(url));
            //传输大文件时报错
            //byte[] bytes = file.getBytes();
            //uploadFile(bytes, filePath + s + "/", newFileName);

//            BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(url));
//            int len;
//            byte[] bytes = new byte[8 * 1024];
//            while ((len = bis.read(bytes)) != -1) {
//                bos.write(bytes, 0, len);
//            }
            if (!targetFile.exists()) {
                targetFile.mkdirs();
               }
            if (name.indexOf("Windows") == -1) {
                file.transferTo(new File(url));
            } else {
                file.transferTo(new File("D:/" + url));

            }
            //file.transferTo(new File(url));

            if (name.indexOf("Windows") == -1) {
                host = request.getServerName();
                System.out.println("域名:---" + host);
                //host = "http://api.buffzs.com";
                addressImg = "http://" + host + contextPath + url;
                System.out.println("Linux---addressImg = " + addressImg);
            } else {
                System.out.println("域名:---" + request.getServerName());
                addressImg = "http://" + request.getServerName() + ":" + request.getServerPort() + contextPath + url;
                System.out.println("Windows---addressImg = " + addressImg);
            }
        } catch (Exception e) {
            log.info("Exception: ==", e);
            e.printStackTrace();
        }
        return Result.success(addressImg);



        /*if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = "D:/img/aaaa/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filePath + fileName);
        return Result.success(filePath + fileName);*/

    }

    /**
     * apk文件上传
     *
     * @param file
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "html模板上传")
    @RequestMapping(value = "/upload/htmlTemplate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //文件上传相关代码
    public Result uploadHtml(MultipartFile file , HttpServletRequest request ) throws Exception {
        String filePath = "/img/htmlTemplate/";
        Result result = uploadFile2(file, request, filePath);
        return result;
    }


    //文件上传工具类服务方法22
    public  Result uploadFile2(MultipartFile file, HttpServletRequest request ,String filePath) throws Exception {
        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String newFileName = UUID.randomUUID().toString() + randomFileName + suffixName;

        // 设置文件上传后的路径   filePath / time / UUID fileName
        String url = filePath + s + "/" + newFileName;

        String contextPath = request.getContextPath();
        //创建文件路径
        //获取本机IP
        String host = "";
        String addressImg = "";
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        System.out.println("当前系统是:" + name);
        try {
            File targetFile = new File(filePath+s);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            if (name.indexOf("Windows") == -1) {
                file.transferTo(new File(url));
                host = request.getServerName();
                addressImg = "http://" + host + contextPath + url;
                System.out.println("Linux---addressImg = " + addressImg);
            } else {
                file.transferTo(new File("D:/" + url));
                System.out.println("域名:---" + request.getServerName());
                addressImg = "http://" + request.getServerName() + ":" + request.getServerPort() + contextPath + url;
                System.out.println("Windows---addressImg = " + addressImg);
            }
        } catch (Exception e) {
            log.info("Exception: ==", e.toString());
            e.printStackTrace();
        }
        return Result.success(addressImg);
    }




    //文件下载相关代码
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "FileUploadTests.java";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
    //多文件上传

    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    // 获取文件名
                    String fileName = file.getOriginalFilename();
                    // 获取文件的后缀名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    // 文件上传后的路径
                    String filePath = "E://003/";
                    // 解决中文问题，liunx下中文路径，图片显示问题
                    fileName = UUID.randomUUID() + suffixName;
                    File dest = new File(filePath + fileName);
                    // 检测是否存在目录
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdirs();
                    }

                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }


    /**
     * 获取某个文件夹下的所有文件
     *
     * @param fileNameList 存放文件名称的list
     * @param path 文件夹的路径
     * @return
     */
    public static void getAllFileName(String path,ArrayList<String> fileNameList) {
        //ArrayList<String> files = new ArrayList<String>();
        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
//              System.out.println("文     件：" + tempList[i]);
                //fileNameList.add(tempList[i].toString());
                fileNameList.add(tempList[i].getName());
            }
            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
            }
        }

        return;
    }

    /**
     * 删除文件
     * @param filePathAndName
     *            String 文件路径及名称 如c:/fqf.txt
     * @return boolean
     */
    public static void delFile(String filePathAndName) {
        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        String path = "";
        if (name.indexOf("Windows") == -1) {
            path = "/img";
        } else {
            path = "D:/img";
        }
        try {
            String[] imgs = filePathAndName.split("img");
            File file = new File(path + imgs[imgs.length - 1]);
            if (file.isFile() && file.exists()) {
                file.delete();
                log.info("-----删除文件---path is" + filePathAndName);
            }
        } catch (Exception e) {
            log.info("-----删除文件操作出错---path is" + filePathAndName);
            e.printStackTrace();
        }
    }

}

