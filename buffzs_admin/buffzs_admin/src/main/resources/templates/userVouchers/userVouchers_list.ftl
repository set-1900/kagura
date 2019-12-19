<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户领取代金券列表</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/userVouchers/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(userVouchers.current)!}"  hidden/>
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
                            <col width="150">
                            <col width="150">
                            <col width="150">
                            <col width="150">
                            <col width="150">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>用户ID</th>
                            <th>代金券ID</th>
                            <th>使用状态</th>
                            <th>领取时间</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list userVouchers.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.userId)!}</td>
                                <td>${(d.vouchersId)!}</td>
                                <td>${(d.type==0)?string('未使用','已使用')!}</td>
                                <td>${(d.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/userVouchers/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/userVouchers/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(userVouchers.total)!}条
                    <@pager count="${(userVouchers.total)!}" limit="${(userVouchers.size)!}" curr="${(userVouchers.current)!}" create="/userVouchers/edit" />
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


    var rArray = new Array();
        <#list userVouchers.data as d>
            rArray.push("${d?js_string}");//必须这么写
        </#list>
    console.log(rArray[0]);
</script>

</body>
</html>