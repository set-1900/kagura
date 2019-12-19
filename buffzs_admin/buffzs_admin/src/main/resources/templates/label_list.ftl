<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>标签列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/label/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(label.current)!}"  hidden/>
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
                            <th>标签名称</th>
                            <th>标签颜色</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list label.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.name)!}</td>
                                <td>
                                    <#if d.color == "#F35858">红色
                                    <#elseif d.color == "#62BCF8">蓝色
                                    <#elseif d.color == "#F8AF40">黄色
                                    <#elseif d.color == "#C281F6">紫色
                                    <#elseif d.color == "#7DE244">绿色
                                    <#else>
                                    </#if>
                                </td>
                                </td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/label/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/label/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(label.total)!}" limit="${(label.size)!}" curr="${(label.current)!}" create="/label/edit" />
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