<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>插件列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/plugin/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(plugin.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden/>
                         <#--   <div class="layui-form-item">
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
                            <th>插件介绍</th>
                            <th>dizhi</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list plugin.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.introduction)!}</td>

                                <td><a class="layui-btn layui-btn-sm" lay-href="/plugin/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/plugin/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(plugin.total)!}" limit="${(plugin.size)!}" curr="${(plugin.current)!}" create="/plugin/edit" />
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