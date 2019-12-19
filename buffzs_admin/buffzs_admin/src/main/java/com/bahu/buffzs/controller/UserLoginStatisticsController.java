package com.bahu.buffzs.controller;

import com.bahu.buffzs.mapper.ChannelMapper;
import com.bahu.buffzs.pojo.BuffChannel;
import com.bahu.buffzs.pojo.BuffKeyword;
import com.bahu.buffzs.pojo.BuffSubchannel;
import com.bahu.buffzs.pojo.dto.*;
import com.bahu.buffzs.pojo.util.ExcelUtils;
import com.bahu.buffzs.service.ChannelService;
import com.bahu.buffzs.service.KeywordService;
import com.bahu.buffzs.service.SubchannelService;
import com.bahu.buffzs.service.UserLoginStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： Mr.Baron
 * @date： 2019/10/22
 * @description：用户统计
 */

@Slf4j
@Controller
@RequestMapping("/userLoginStatistics")
public class UserLoginStatisticsController {

    @Autowired
    private UserLoginStatisticsService userLoginStatisticsService;
    @Autowired
    private SubchannelService subchannelService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private KeywordService keywordService;
    @Autowired
    private ChannelMapper channelMapper;

    /**
     * 用户登录统计查询
     *
     * @param date
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public String agent(String date) {
        List<UserLoginStatistics> list = userLoginStatisticsService.findAll(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += "<tr> <td id=date" + i + " value=" + sdf.format(list.get(i).getDate()) + ">" +
                    sdf.format(list.get(i).getDate()) + "</td><td><a id= " + i +
                    " onclick=\"allChannelData(this)\" class='name'>全渠道</a></td> <td>" + list.get(i).getAddNewUserNumber() + "</td> " +
                    "<td>" + list.get(i).getAddNewAccountsNumber() + "</td> <td>" + list.get(i).getActiveUserNumber() + "</td> " +
                    "<td>" + list.get(i).getActiveAccountsNumber() + "</td> <td>" + list.get(i).getStartNumber() + "</td> </tr>";
        }
        log.info("================================str {}", str);
        return str;
    }

    /**
     * 用户统计中的  根据  渠道  , 子渠道 , 关键查询
     *1
     * @param channel
     * @param subchannel
     * @param keyword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/keyword/list")
    public ModelAndView keyword(String channel, String subchannel, String keyword) {
        List<UserLoginStatistics> userLoginStatistics = userLoginStatisticsService.findAllByKeyword(channel, subchannel, keyword);
        ModelAndView model = new ModelAndView();
        model.setViewName("userLoginStatistics_list");
        model.addObject("userLoginStatistics", userLoginStatistics);
        List<BuffChannel> channelList = channelMapper.findAll();
        model.addObject("channelList", channelList);
        return model;
    }

    /**
     * 跳转到关键字统计页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/keyword")
    public ModelAndView keyword() {
        ModelAndView model = new ModelAndView();
        List<BuffChannel> channelList = channelService.findAllChannel();
        model.setViewName("statistics/keywordStatistics_list");
        model.addObject("channelList", channelList);
        return model;
    }

    /**
     * ---------------------------------------
     * 关键字统计查询
     *
     * @param channelId
     * @param subchannelId
     * @param startTime
     * @param endTime
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/keywordList")
    public ModelAndView list(String channelId, String subchannelId, String startTime, String endTime) {
        List<KeywordStatisticsDto> list = userLoginStatisticsService.findBySubchannelId(subchannelId, startTime, endTime);
        ModelAndView model = new ModelAndView();
        model.setViewName("statistics/keywordStatistics_list");
        model.addObject("list", list);

        List<BuffChannel> channelList = channelService.findAllChannel();
        model.addObject("channelList", channelList);
        int a = 0;
        int b = 0;
        int c = 0;

        String date = startTime + " 到 " + endTime;
        for (KeywordStatisticsDto keywordStatisticsDto : list) {
            keywordStatisticsDto.setDate(date);
            a += keywordStatisticsDto.getAddNewUserNumber();
            b += keywordStatisticsDto.getAddNewAccountsNumber();
            c += keywordStatisticsDto.getDownloadButtonNumber();
        }

        model.addObject("sum1", a);
        model.addObject("sum2", b);
        model.addObject("sum3", c);
        return model;
    }


    /**
     * 跳转到游戏统计页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/gameStatistics")
    public ModelAndView gameStatistics() {
        ModelAndView model = new ModelAndView();
        model.setViewName("statistics/gameStatistics_list");
        return model;
    }

    /**
     * ---------------------------------------
     * 游戏点击统计查询
     *
     * @param gameId    游戏
     * @param startTime
     * @param endTime
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/game")
    public ModelAndView game(Integer current, Integer size, String gameId, String startTime, String endTime) {
        log.info("startTime = " + startTime);
        log.info("endTime = " + endTime);
        PageBean<StatisticsDto> list = userLoginStatisticsService.findByGameName(gameId, startTime, endTime, current, size);
        String date = startTime + " 到 " + endTime;
        List<StatisticsDto> statisticsDtoList = (List<StatisticsDto>) list.getData();
        int a = 0;
        int b = 0;
        if (StringUtils.isNotEmpty(startTime) && StringUtils.isNotEmpty(endTime)) {
            for (StatisticsDto statisticsDto : statisticsDtoList) {
                statisticsDto.setDate(date);
                a += statisticsDto.getGameClickCount();
                b += statisticsDto.getGameDownloadCount();
            }
        } else {
            for (StatisticsDto statisticsDto : statisticsDtoList) {
                a += statisticsDto.getGameClickCount();
                b += statisticsDto.getGameDownloadCount();
            }
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("statistics/gameStatistics_list");
        model.addObject("list", list);
        model.addObject("sum1", a);
        model.addObject("sum2", b);
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/querySubchannelByChannelId")
    public Result querySubchannelByChannelId(@Param("channelId") Integer channelId) {
        List<BuffSubchannel> subchannelList = subchannelService.findByChannelId(channelId.toString());
        return Result.success(subchannelList);
    }

    @ResponseBody
    @RequestMapping(value = "/querykeywordBySubchannelId")
    public Result querykeywordBySubchannelId(String subchannelId) {
        List<BuffKeyword> keywordList = keywordService.findBySubchannelId(subchannelId);
        return Result.success(keywordList);
    }

    @ResponseBody
    @RequestMapping(value = "/allChannelData")
    public String allChannelData(String date, String channelId) {
        if (channelId == null || "".equals(channelId)) {
            return userLoginStatisticsService.findAllChannel(date, null);
        } else {
            return userLoginStatisticsService.findAllChannel(date, channelId);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/allChannel")
    public List<BuffChannel> allChannel() {
        return channelMapper.findAll();
    }

    /**
     * 用户统计中的  根据  渠道  , 子渠道 , 关键查询
     *
     * @param channel
     * @param subchannel
     * @param keyword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list2")
    public String list2(String channel, String subchannel, String keyword) {
        List<UserLoginStatistics> list = userLoginStatisticsService.findAllByKeyword(channel, subchannel, keyword);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += "<tr> <td id=date" + i + " value=" + sdf.format(list.get(i).getDate()) + ">" +
                    sdf.format(list.get(i).getDate()) + "</td><td><a id= " + i +
                    " onclick=\"allChannelData(this)\">全渠道</a></td> <td>" + list.get(i).getAddNewUserNumber() + "</td> " +
                    "<td>" + list.get(i).getAddNewAccountsNumber() + "</td> <td>" + list.get(i).getActiveUserNumber() + "</td> " +
                    "<td>" + list.get(i).getActiveAccountsNumber() + "</td> <td>" + list.get(i).getStartNumber() + "</td> </tr>";
        }
        log.info("================================str {}", str);
        return str;
    }

    /**
    * @Author: XieXiang
    * @Description:  用户统计导出
    * @Date: 2019/12/19
    * @Param: [channel, subchannel, keyword]
    * @return: java.lang.String
    **/
    @ResponseBody
    @RequestMapping(value = "/export")
    public void export(String channelId, String subchannelId, String keyword, HttpServletResponse response) {
        if (channelId.equals("") || channelId.equals("null")) channelId = null;
        if (subchannelId.equals("") || subchannelId.equals("null")) subchannelId = null;
        if (keyword.equals("") || keyword.equals("null")) keyword = null;
        List<UserLoginStatistics> list = userLoginStatisticsService.findAllByKeyword(channelId, subchannelId, keyword);
        // 表头
        List<String> head = new ArrayList<>();
        // 表体
        List<List<String>> body = new ArrayList<>();
        head.add("日期");
        head.add("渠道");
        head.add("新增用户数量");
        head.add("新增账号数量");
        head.add("活跃用户数量");
        head.add("活跃账号数量");
        head.add("启动次数");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (UserLoginStatistics statistics : list) {
            List<String> row = new ArrayList<>();
            row.add(sdf.format(statistics.getDate()));
            if (channelId == null) row.add("全渠道");
            else row.add(statistics.getName());
            row.add(statistics.getAddNewUserNumber());
            row.add(statistics.getAddNewAccountsNumber());
            row.add(statistics.getActiveUserNumber());
            row.add(statistics.getActiveAccountsNumber());
            row.add(statistics.getStartNumber());
            body.add(row);
        }
        String fileName = "用户统计报表.xls";
        HSSFWorkbook workbook = ExcelUtils.expExcel(head, body);
        ExcelUtils.outFile(workbook, fileName, response);
    }

}
