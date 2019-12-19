<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评论列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/comment/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(comment.current)!}"  hidden/>
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
                            <th>评论的用户id</th>
                            <th>评论类型</th>
                            <th>评论主题id</th>
                            <th>目标的用户id</th>
                            <th>添加时间</th>
                            <th>点赞数</th>
                            <th>评论内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list comment.data as d>
                            <tr>
                                <td>${(d.fromUid)!}</td>
                                <td>
                                     <#if d.topicType == 1>游戏</#if>
                                     <#if d.topicType == 2>文章</#if>
                                     <#if d.topicType == 3>提问</#if>
                                     <#if d.topicType == 4>资讯</#if>
                                     <#if d.topicType == 5>朋友圈</#if>
                                     <#if d.topicType == 6>回复</#if>
                                </td>
                                <td>${(d.topicId)!}</td>
                                <td>${(d.toUid)!}</td>
                                <td>${(d.addTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                <td>${(d.laud)!}</td>
                                <td>${(d.content)!}</td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/comment/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/comment/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(comment.total)!}" limit="${(comment.size)!}" curr="${(comment.current)!}" create="/comment/edit" />
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