<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>角色列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body layui-form">
                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/goods/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(page.current)!}"  hidden/>
                            <input type="text" name="size" value="30"  hidden/>
                            <div class="layui-form-item">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="username" value="${(queryData.username)!}" placeholder="代理人名称" autocomplete="off" class="layui-input" />
                                </div>
                                <label class="layui-form-label">手机</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phone" value="${(queryData.phone)!}" placeholder="手机号码" autocomplete="off" class="layui-input" />
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>
                        </form>
                    </div>
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>角色名</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list dataPages.records as d>
                        <tr>
                            <td>${(d.name)!}</td>
                            <td>${(d.createTime?string('dd.MM.yyyy HH:mm:ss'))!}</td>
                            <td>
                                <a href="javascript:;" onclick="doDel('/role/del?pk=${(d.goodsId)!}','删除用户')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(page.total)!}" limit="${(page.size)!}" curr="${(page.current)!}" />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>