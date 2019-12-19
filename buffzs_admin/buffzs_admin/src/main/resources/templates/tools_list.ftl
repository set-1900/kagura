<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工具列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/tools/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(tools.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden/>
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
                            <th>工具名称</th>
                            <th>游戏工具图片</th>
                            <th>工具详情地址</th>
                            <th>工具描述</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list tools.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.title)!}</td>
                                <td><img src=${(d.icon)!}></td>
                                <td>${(d.detail)!}</td>
                                <td>${(d.shortDescribe)!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/tools/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/tools/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(tools.total)!}" limit="${(tools.size)!}" curr="${(tools.current)!}" create="/tools/edit" />
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

    function addRow(){
        var t=document.getElementById("t1");
        var row=t.insertRow(t.rows.length);
        var cell1=row.insertCell(0);
        cell1.innerHTML=document.getElementById("t2").value;
        var cell2=row.insertCell(1);
        cell2.innerHTML=document.getElementById("t3").value;
    }
</script>

</body>
</html>