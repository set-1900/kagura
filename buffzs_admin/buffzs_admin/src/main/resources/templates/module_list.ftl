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
                            <input type="text" name="size" value="10"  hidden id="size"/>
                         <#--   <div class="layui-form-item">
                                <label class="layui-form-label">名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${(name)!}" autocomplete="off" class="layui-input" id="name"/>
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>-->
                        </form>
                    </div>


                    <div class="layui-col-md12">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/module/list?current=1&size=10">
                            <input type="submit" class="layui-btn" value="所有"/>
                        </a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/module/list?current=1&size=10&moduleType=1">
                            <input type="submit" class="layui-btn" value="首页"/>
                        </a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/module/list?current=1&size=10&moduleType=2">
                            <input type="submit" class="layui-btn" value="海外游戏"/>
                        </a>
                    </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>模块名称</th>
                            <th>类型</th>
                            <th>游戏排列方式</th>
                            <th>横向显示等级</th>
                            <th>所属位置</th>
                            <th>横向模块图标地址</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list module.data as d>
                            <tr>
                                <td>${(d.name)!}</td>
                                <td><#if d.type==1>顶部菜单模块<#elseif d.type==2>首页内容模块<#elseif d.type==0>0</#if></td>
                                <td><#if d.sequence==0>竖向<#elseif d.sequence==1>横向</#if></td>
                                <td>${(d.level)!}</td>
                                <td>
                                    <#if d.moduleType ??>
                                        <#if d.moduleType==1>首页<#elseif d.moduleType==2>海外游戏<#else> </#if>
                                    </#if>
                                </td>
                                <td><img src=${(d.iconUrl)!}></td>
                                <td>
                                    <a lay-href="/module/update?id=${(d.id)!}" lay-id="${(d.id)!}" class="layui-btn layui-btn-sm">修改</a>
                                    <a href="javascript:;" onclick="doDel('/module/del?id=${(d.id)!}','删除模块')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>

                    </table>共${(module.total)!}条
                    <@pager count="${(module.total)!}" limit="${(module.size)!}" curr="${(module.current)!}" create="/module/edit" />
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