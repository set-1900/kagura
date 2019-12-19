<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body layui-form">
                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/user/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(user.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden/>
                            <div class="layui-form-item">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="username" value="${(user.username)!}" placeholder="用户名称" autocomplete="off" class="layui-input" />
                                </div>
                                <label class="layui-form-label">手机</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phone" value="${(user.phone)!}" placeholder="手机号码" autocomplete="off" class="layui-input" />
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>
                        </form>
                    </div>
                    <table class="layui-table" >
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>用户昵称</th>
                            <th>性别</th>
                            <th >省份</th>
                            <th>城市</th>
                            <th>个性签名</th>
                            <th>身份证</th>
                            <th>真实姓名</th>
                            <th>qq号码</th>
                            <th>手机号</th>
                            <th>头像</th>
                            <th>用户获得的点赞数</th>
                            <th>请求ip</th>
                            <th>buff助手app版本号</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list user.data as d>
                        <tr>
                            <td>${(d.id)!}</td>
                            <td>${(d.username)!}</td>
                            <td><#if d.sex == 1>男<#elseif d.sex == 2>女<#elseif d.sex == 0>空</#if></td>
                            <td >${(d.province)!}</td>
                            <td>${(d.cityName)!}</td>
                            <td>${(d.signature)!}</td>
                            <td>${(d.idCard)!}</td>
                            <td>${(d.realname)!}</td>
                            <td>${(d.qq)!}</td>
                            <td>${(d.phone)!}</td>
                            <td><img src="${(d.icon)!}" style="width: 50px"/></td>
                            <td>${(d.praise)!}</td>
                            <td>${(d.ip)!}</td>
                            <td>${(d.version)!}</td>
                   <#--         <td>
                                <a lay-href="/user/update?id=${(d.id)!}" lay-id="${(d.id)!}" class="layui-btn layui-btn-sm">修改</a>
                                <a href="javascript:;" onclick="doDel('/user/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                            </td>-->
                        </tr>
                        </#list>
                        </tbody>
                    </table>共${(user.total)!}条
                    <@pager count="${(user.total)!}" limit="${(user.size)!}" curr="${(user.current)!}" create="/user/edit" />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>