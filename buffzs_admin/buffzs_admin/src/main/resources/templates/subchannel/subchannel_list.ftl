<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>子渠道列表</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/subchannel/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(subchannel.current)!}"  hidden/>
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
                            <col width="60">
                            <col width="100">
                            <col width="120">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>主渠道id</th>
                            <th>子渠道名称</th>
                            <th>子渠道链接</th>
                            <th>结算方式</th>
                            <th>扣量比例</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list subchannel.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.channelId)!}</td>
                                <td>${(d.name)!}</td>
                                <td>${(d.downloadUrl)!}</td>
                                <td>${(d.stype)!}</td>
                                <td>${(d.discount)!}</td>
                                <td>${(d.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/subchannel/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/subchannel/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(subchannel.total)!}条
                    <@pager count="${(subchannel.total)!}" limit="${(subchannel.size)!}" curr="${(subchannel.current)!}" create="/subchannel/edit" />
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