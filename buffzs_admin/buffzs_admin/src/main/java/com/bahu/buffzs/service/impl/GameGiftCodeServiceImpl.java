package com.bahu.buffzs.service.impl;

import com.bahu.buffzs.mapper.GameGiftCodeMapper;
import com.bahu.buffzs.mapper.GameGiftMapper;
import com.bahu.buffzs.pojo.BuffGameGift;
import com.bahu.buffzs.pojo.BuffGameGiftCode;
import com.bahu.buffzs.pojo.dto.PageBean;
import com.bahu.buffzs.pojo.util.ExcelUtils;
import com.bahu.buffzs.service.GameGiftCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-10
 **/
@Slf4j
@Transactional
@Service
public class GameGiftCodeServiceImpl implements GameGiftCodeService {

    @Autowired
    private GameGiftCodeMapper gameGiftCodeMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GameGiftMapper gameGiftMapper;

    @Override
    public PageBean findAll(Integer current, Integer size) {
        PageHelper.startPage(current == null ? 1 : current,size == null ? 10 : size);
        List<BuffGameGiftCode>  buffGameGiftCode =  gameGiftCodeMapper.findAll();
        PageInfo<BuffGameGiftCode> pageInfo = new PageInfo<>(buffGameGiftCode);
        PageBean<BuffGameGiftCode> pageBean = new PageBean<>();
        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setTotalPages(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return pageBean;
    }

    @Override
    public BuffGameGiftCode findById(Integer id) {
        BuffGameGiftCode buffGameGiftCode = gameGiftCodeMapper.findById(id);
        return buffGameGiftCode;
    }

    @Override
    public Integer save(BuffGameGiftCode buffGameGiftCode) {
        return gameGiftCodeMapper.save(buffGameGiftCode);
    }

    @Override
    public Integer updateSave(BuffGameGiftCode buffGameGiftCode) {
        return gameGiftCodeMapper.updateSave(buffGameGiftCode);
    }

    @Override
    public Integer delete(Integer id) {
        return gameGiftCodeMapper.delete(id);
    }

    /*/**
    * @Author: XieXiang
    * @Description:  读取excel文件,批量入库
    * @Date: 2019/12/18
    * @Param: [file, unique_id]
    * @return: void
    **/
    @Override
    public void batchImport(MultipartFile file, String unique_id) throws Exception {
        List<List<String>> lists = ExcelUtils.readTable(file.getInputStream(), file.getOriginalFilename());
        BuffGameGift gameGift = gameGiftMapper.findByUniqueId(Integer.parseInt(unique_id));
        // 获取数据库链接对象
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        // 设置手动提交事务
        conn.setAutoCommit(false);
        // 预处理语句集
        PreparedStatement pstm = conn.prepareStatement("insert into buff_game_gift_code (unique_id, game_id, gift_code, status) values ("
                + gameGift.getUniqueId() + "," + gameGift.getGameId() + ", ?, ?)");
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < lists.size(); i++) {
                pstm.setString(1, lists.get(i).get(0));
                Double d = Double.parseDouble(lists.get(i).get(1));
                pstm.setInt(2, d.intValue());
                pstm.addBatch();
                // 5000条数据插入一次
                if (i % 5000 == 0) {
                    pstm.executeBatch();
                    conn.commit();
                }
            }
            // 最后不足5000条的数据
            pstm.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            log.info("批量插入数据耗时: {}", end - start);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null)
            pstm.close();
            if (conn != null)
            conn.close();
        }
    }

}
