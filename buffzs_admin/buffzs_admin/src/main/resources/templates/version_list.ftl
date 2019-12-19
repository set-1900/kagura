<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>版本列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/version/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(version.current)!}"  hidden/>
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
                            <th>文件名称</th>
                            <th>版本代码</th>
                            <th>版本号</th>
                            <th>更新内容说明1</th>
                            <th>更新内容说明2</th>
                            <th>更新内容说明3</th>
                            <th>更新内容说明4</th>
                            <th>更新内容说明5</th>
                            <th>下载地址</th>
                            <th>渠道号</th>
                            <th>创建时间</th>
                            <th>是否更新</th>
                            <th>apk类型</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list version.data as d>
                            <tr>
                                <td>${(d.id)!}</td>
                                <td>${(d.name)!}</td>
                                <td>${(d.code)!}</td>
                                <td>${(d.version)!}</td>
                                <td>${(d.about1)!}</td>
                                <td>${(d.about2)!}</td>
                                <td>${(d.about3)!}</td>
                                <td>${(d.about4)!}</td>
                                <td>${(d.about5)!}</td>
                                <td>${(d.downurl)!}</td>
                                <td>${(d.channelNum)!}</td>
                                <td>${(d.createTime?string('yyyy-MM-dd'))!}</td>
                                <td><#if d.updateIfForce == 0>0不需要强更,前端提示更新<#elseif d.updateIfForce == 1>1强制更新,app启动时检查</#if></td>
                                <td><#if d.apkType == 1>buffzs<#elseif d.apkType == 2>google plugin<#elseif d.apkType == 3>game plugin</#if></td>
                                <td><a class="layui-btn layui-btn-sm" lay-href="/version/update?id=${(d.id)!}" lay-id="${(d.id)!}">修改</a>
                                    <a href="javascript:;" onclick="doDel('/version/del?id=${(d.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(version.total)!}" limit="${(version.size)!}" curr="${(version.current)!}" create="/version/edit" />
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