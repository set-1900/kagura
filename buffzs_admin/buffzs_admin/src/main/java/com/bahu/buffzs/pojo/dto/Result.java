package com.bahu.buffzs.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "api接口通用返回对象")
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "响应码")
    private Integer code; //响应码

    @ApiModelProperty(value = "响应标记")
    private Boolean success; //响应标记

    @ApiModelProperty(value = "响应信息")
    private String message; //响应信息

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @ApiModelProperty(value = "返回数据")
    private T data; //返回数据

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result();
        result.setSuccess(true);
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result();
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> error(T data) {
        Result<T> result = new Result();
        result.setSuccess(false);
        result.setData(data);
        return result;
    }

    public Result(Boolean success, Integer code, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result(Boolean success, Integer code, T data) {
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public Result() {
    }

    public Result(Boolean success, Integer code, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public Result( String message) {
        this.success = success;
    }
}
