<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>代金券列表</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/vouchers/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(vouchers.current)!}"  hidden/>
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
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>价值(元)</th>
                            <th>总数量</th>
                            <th>剩余数量</th>
                            <th>超过可用</th>
                            <th>说明</th>
                            <th>过期时间</th>
                            <th>创建时间</th>
                            <th>创建人</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list vouchers.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.value)!}</td>
                                <td>${(d.sum)!}</td>
                                <td>${(d.surplusSum)!}</td>
                                <td>${(d.money)!}</td>
                                <td>${(d.vouchersExplain)!}</td>
                                <td>${(d.expirationTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td>${(d.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td>${(d.creator)!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/vouchers/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/vouchers/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(vouchers.total)!}条
                    <@pager count="${(vouchers.total)!}" limit="${(vouchers.size)!}" curr="${(vouchers.current)!}" create="/vouchers/edit" />
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