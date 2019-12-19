<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/promotionPage/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(promotionPage.current)!}"  hidden/>
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
                            <col width="120">
                            <col width="80">
                            <col width="120">
                            <col width="120">
                            <col width="80">
                            <col width="120">
                            <col width="80">
                            <col width="120">
                            <col width="80">
                            <col width="120">
                            <col width="80">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>推广页名称</th>
                            <th>推广页地址</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th>主渠道id</th>
                            <th>主渠道名称</th>
                            <th>子渠道id</th>
                            <th>子渠道名称</th>
                            <th>关键字id</th>
                            <th>关键字名称</th>
                            <th>推广链接</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list promotionPage.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.name)!}</td>
                                <td>${(d.url)!}</td>
                                <td>${(d.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td>${(d.updateTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td>${(d.channelId)!}</td>
                                <td>${(d.channelName)!}</td>
                                <td>${(d.subchannelId)!}</td>
                                <td>${(d.subchannelName)!}</td>
                                <td>${(d.keywordId)!}</td>
                                <td>${(d.keywordName)!}</td>
                                <td>${(d.promotionUrl)!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/promotionPage/edit?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/promotionPage/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(promotionPage.total)!}条
                    <@pager count="${(promotionPage.total)!}" limit="${(promotionPage.size)!}" curr="${(promotionPage.current)!}" create="/promotionPage/edit" />
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