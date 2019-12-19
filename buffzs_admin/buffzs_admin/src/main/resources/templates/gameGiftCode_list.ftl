<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>版本列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-input-inline">
                        <input type="submit" class="layui-btn" lay-href="/redirect/view?viewName=gameGiftCode_import" value="批量导入" id="import"/>
                    </div>
                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/gameGiftCode/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(gameGiftCode.current)!}" hidden/>
                            <input type="text" name="size" value="10" hidden/>
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
                            <th>自增id</th>
                            <th>礼包ID</th>
                            <th>游戏ID</th>
                            <th>领取渠道ID</th>
                            <th>礼包码</th>
                            <th>领取状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list gameGiftCode.data as d>
                        <tr>
                            <td>${(d.id?c)!}</td>
                            <td>${(d.uniqueId)!}</td>
                            <td>${(d.gameId)!}</td>
                            <td>${(d.channelId)!}</td>
                            <td>${(d.giftCode)!}</td>
                            <td>
                                <#if d.status == '0'>
                                    <span>未领取</span>
                                </#if>
                                <#if d.status == '1'>
                                    <span>已领取</span>
                                </#if>
                            </td>
                            <td><a class="layui-btn layui-btn-sm" lay-href="/gameGiftCode/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                <a href="javascript:;" onclick="doDel('/gameGiftCode/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(gameGiftCode.total?c)!}" limit="${(gameGiftCode.size?c)!}" curr="${(gameGiftCode.current?c)!}" create="/gameGiftCode/edit" />
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

    function addRow() {
        var t = document.getElementById("t1");
        var row = t.insertRow(t.rows.length);
        var cell1 = row.insertCell(0);
        cell1.innerHTML = document.getElementById("t2").value;
        var cell2 = row.insertCell(1);
        cell2.innerHTML = document.getElementById("t3").value;
    }
</script>

</body>
</html>