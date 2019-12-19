<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>模块列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/module/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(module.current)!}"  hidden/>
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
                            <th>顶部导航分类名称</th>
                            <th>上级导航</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list module.data as d>
                            <tr>
                                <td>${(d.name)!}</td>
                                <td>${(d.pName)!}</td>
                                <td>
                                    <a lay-href="/navigation/update?id=${(d.id)!}" lay-id="${(d.id)!}" class="layui-btn layui-btn-sm">修改</a>
                                    <a href="javascript:;" onclick="doDel('/navigation/del?id=${(d.id)!}','删除模块')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(module.total)!}" limit="${(module.size)!}" curr="${(module.current)!}" create="/navigation/edit" />
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