package com.bahu.buffzs.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author： Mr.Baron
 * @date： 2019/10/30
 * @description：
 */
@Data
public class BuffAdminUser implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private String code;
    private Integer roleId;
}
