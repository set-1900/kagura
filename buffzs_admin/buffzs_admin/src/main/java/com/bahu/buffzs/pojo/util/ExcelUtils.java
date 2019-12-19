package com.bahu.buffzs.pojo.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 报表工具
 * @Author: XieXiang
 * @Date: 2019/12/13
 * @Version: 1.0
 **/

public class ExcelUtils {

    //**********************************************导出start
    static final short borderpx = 1;

    /**
     * 导出excel表格
     * @param head  excel表个的表头
     * @param body  excel表的数据体
     */
    public static HSSFWorkbook expExcel(List<String> head, List<List<String>> body) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell= null;
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(setFontStyle(workbook, "黑体", (short) 14));
        sheet.createFreezePane(0,1,0,1);

        for (int i = 0; i<head.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(head.get(i));
            cell.setCellStyle(cellStyle);
        }

        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        cellStyle2.setFont(setFontStyle(workbook, "宋体", (short) 12));
        for (int i = 0; i < body.size(); i++) {
            row = sheet.createRow(i + 1);
            List<String> paramList = body.get(i);
            for (int p = 0; p < paramList.size(); p++) {
                cell = row.createCell(p);
                cell.setCellValue(paramList.get(p));
                cell.setCellStyle(cellStyle2);
            }
        }
        for (int i = 0, isize = head.size(); i < isize; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }



    /**
     * 文件输出
     * @param workbook 填充好的workbook
     * @param path 如果需要缓存生成的临时文件在项目中就是存放的位置，不需要的话就是导出文件的名称
     */
    public static void outFile(HSSFWorkbook workbook,String path,HttpServletResponse response) {
        SimpleDateFormat fdate=new SimpleDateFormat("yyyyMMddHHmmss");
        //拼接最终需要导出的文件名称或存放的路径、名称
        path = path.substring(0, path.lastIndexOf(".")) + fdate.format(new Date()) + path.substring(path.lastIndexOf("."));
        System.out.println(path);
        OutputStream os=null;
        //File file = null; 如果需要在项目里面存储导出的excle表格的话，需要用这个方法
        try {
            //file = new File(path); 如果需要在项目里面存储导出的excle表格的话，需要用这个方法
            //String filename = file.getName(); 如果需要在项目里面存储导出的excle表格的话，需要用这个方法
            String filename = path; //不存储生成的临时excle文件，用该方法
            //os = new FileOutputStream(file); 生成临时文件放到项目路径上，本项目不需要
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf8"));
            System.out.println(response.getHeader("Content-Disposition"));
            os= new BufferedOutputStream(response.getOutputStream());
            // response返回输出流在浏览器端不会下载文件,转而直接返回成文件
            //os = new BufferedOutputStream(new FileOutputStream(path));
            workbook.write(os);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.flush();//冲刷出流，将所有缓冲的数据强制发送到目的地。
            os.close(); //冲刷并关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 设置字体样式
     * @author xiexiang
     * @param workbook 工作簿
     * @param name 字体类型
     * @param height 字体大小
     * @return HSSFFont
     */
    private static HSSFFont setFontStyle(HSSFWorkbook workbook, String name, short height) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints(height);
        font.setFontName(name);
        return font;
    }


    /**
    * @Author: XieXiang
    * @Description: 获取xls文件的内容
    *   适用于第一行是标题行的excel，例如
    *   姓名   年龄  性别  身高
    *   张三   25  男   175
    *   李四   22  女   160
    * @Date: 2019/12/17
    * @Param: []
    * @return: void
    **/
    public static List<List<String>> readTable(InputStream in, String fileName) throws Exception {
        Workbook wb = null;
        /*if ("xls".equals(fileName.substring(fileName.indexOf(".") + 1))) {
            wb = new HSSFWorkbook(in);
        } else if ("xlsx".equals(fileName.substring(fileName.indexOf(".") + 1))) {
            wb = new XSSFWorkbook(in);
        } else {
            throw new Exception("当前文件不是excel文件");
        }*/
        wb = WorkbookFactory.create(in);
        Sheet sheet = wb.getSheetAt(0);
        // 表头数据
        List<String> head = new ArrayList<>();
        // 表体数据
        List<List<String>> body = new ArrayList<>();
        // 获取sheet中的行数
        int rowNum = sheet.getLastRowNum() + 1;
        for (int i = 0; i < rowNum; i++) {
            // 第一行为标题数据,后面的为具体数据
            if (i > 0) {
                Row row = sheet.getRow(i);
                // 每一行数据
                List<String> rowData = new ArrayList<>();
                for (int j= 0; j < row.getLastCellNum(); j++) {
                    rowData.add(row.getCell(j).toString());
                }
                body.add(rowData);
            }
        }
        return body;
    }

    public static void main(String[] args) {
        try {
            List<List<String>> lists = readTable(new FileInputStream("C:\\Users\\Windows\\Documents\\渠道统计报表20191217111127.xls"), "渠道统计报表20191217111127.xls");
            for (List<String> list : lists) {
                System.out.println(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //**********************************************导出end
}
