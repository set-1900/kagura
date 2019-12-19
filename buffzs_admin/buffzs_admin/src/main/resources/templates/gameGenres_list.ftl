<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>游戏类型列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/gameGenres/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(gameGenres.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden/>
                        </form>
                    </div>

                    <table class="layui-table">
                        <colgroup>
                            <col width="10">
                            <col width="10">
                            <col width="150">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>游戏类型</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list gameGenres.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.name)!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/gameGenres/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/gameGenres/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(gameGenres.total)!}" limit="${(gameGenres.size)!}" curr="${(gameGenres.current)!}" create="/gameGenres/edit" />
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