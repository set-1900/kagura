<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>充值比例列表</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/rechargeProportion/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(rechargeProportion.current)!}"  hidden/>
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
                            <col width="120">
                            <col >
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>金额(元)</th>
                            <th>B币</th>
                            <#--<th>类型</th>-->
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list rechargeProportion.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.price)!}</td>
                                <td>${(d.systemMoney)!}</td>
                                <#--<td>${(d.type)!}</td>-->
                                <td><a class="layui-btn layui-btn-sm" lay-href="/rechargeProportion/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/rechargeProportion/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(rechargeProportion.total)!}条
                    <@pager count="${(rechargeProportion.total)!}" limit="${(rechargeProportion.size)!}"
                    curr="${(rechargeProportion.current)!}" create="/rechargeProportion/edit" />
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