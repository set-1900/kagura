<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>游戏区服列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/gameServer/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(gameServer.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden/>
                            <#--<div class="layui-form-item">
                                <label class="layui-form-label">名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${(name)!}" autocomplete="off" class="layui-input" />
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>-->
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
                            <th>id</th>
                            <th>游戏</th>
                            <th>所属大区</th>
                            <th>服务器名</th>
                            <th>开服时间</th>
                            <th>是否热门</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list gameServer.data as d>
                            <tr>
                                <td>${(d.serverId)!}</td>
                                <td>${(d.gameName)!}</td>
                                <td>${(d.areaId)!}</td>
                                <td>${(d.serverName)!}</td>
                                <td>${(d.openDate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td><#if d.ifhot == '0'>否<#elseif d.ifhot == '1'>是</#if></td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/gameServer/update?id=${(d.serverId)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/gameServer/del?id=${(d.serverId)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(gameServer.total)!}" limit="${(gameServer.size)!}" curr="${(gameServer.current)!}" create="/gameServer/edit" />
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function afterSubmit() {
        var tabId = location.pathname + location.search;
        parent.closeTab(tabId);
    }
</script>

</body>
</html>