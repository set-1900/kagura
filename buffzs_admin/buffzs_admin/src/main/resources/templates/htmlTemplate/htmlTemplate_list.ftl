<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>html模板列表</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/channel/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(channel.current)!}"  hidden/>
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
                            <col width="80">
                            <col width="120">
                            <col width="120">
                            <col width="120">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>模板名称</th>
                            <th>模板地址</th>
                            <th>创建时间</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list htmlTemplate.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.name)!}</td>
                                <td>${(d.templateUrl)!}</td>
                                <td>${(d.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/htmlTemplate/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/htmlTemplate/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(htmlTemplate.total)!}条
                    <@pager count="${(htmlTemplate.total)!}" limit="${(htmlTemplate.size)!}" curr="${(htmlTemplate.current)!}" create="/htmlTemplate/edit" />
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