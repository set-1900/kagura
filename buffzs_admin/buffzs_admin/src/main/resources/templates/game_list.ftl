<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>游戏列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/game/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(game.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden id="size"/>
                            <div class="layui-form-item">
                                <label class="layui-form-label">名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${(name)!}" autocomplete="off" class="layui-input" id="name"/>
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>
                        </form>
                    </div>

                    <table class="layui-table">
                        <colgroup>
                            <col width="50">
                            <col width="100">
                            <col width="150">
                            <col width="150">
                            <col width="150">
                            <col width="150">
                            <col width="80">
                            <col width="150">
                            <col width="150">
                            <col width="150">
                            <col width="150">
                            <col width="100">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>游戏ID</th>
                            <th>游戏名称</th>
                            <th>游戏图标</th>
                            <th>游戏标签</th>
                            <th>描述</th>
                            <th>游戏版本号</th>
                            <th>游戏包大小(MB)</th>
                            <th>游戏下载地址</th>
                            <#--<th>游戏类别名称</th>-->
                            <th>游戏包名</th>
                            <th>模块名称</th>
                            <th>游戏状态</th>
                            <th></th>
                            <#--<th>游戏介绍详情</th>-->
                        </tr>
                        </thead>
                        <tbody>
                        <#list game.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.name)!}</td>
                                <td><img src=${(d.icon)!}></td>
                                <td>${(d.labelName)!}</td>
                                <td>${(d.shortDescribe)!}</td>
                                <td>${(d.version)!}</td>
                                <td>${(d.size)!}</td>
                                <td>${(d.downloadUrl)!}</td>
                                <#--<td>${(d.genresName)!}</td>-->
                                <td>${(d.packageName)!}</td>
                                <td>${(d.module)!}</td>
                                <td>
                                    <#if d.gameStatus == 1>上架<#elseif d.gameStatus == 0>下架<#else></#if>
                                </td>
                                <#--<td>${(d.describe)!}</td>-->
                                <td><a class="layui-btn layui-btn-sm" lay-href="/game/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/game/del?id=${(d.id)!}','删除游戏')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(game.total)!}条
                    <@pager count="${(game.total)!}" limit="${(game.size)!}" curr="${(game.current)!}" create="/game/edit" />

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function update(url, msg) {
        layer.confirm("确认"+msg+"吗？", {btn:['确定', '取消']}, function (index) {
            layer.close(index);
            $.get(url, function(data){


            })
        })
    }
</script>

</body>
</html>