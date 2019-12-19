<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>关键字统计</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">
                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/userLoginStatistics/keywordList" method="post">

                            <div class="layui-form-item">
                                <label class="layui-form-label">渠道</label>
                                <div class="layui-input-inline">
                                    <select id="channelId" lay-filter="channelId" lay-verify="" lay-search="" name="channelId">
                                        <option value=""></option>
                                    <#list channelList as m>
                                        <option value="${(m.id)!}">${(m.name)!}</option>
                                    </#list>
                                    </select>
                                </div>
                                <label class="layui-form-label">子渠道</label>
                                <div class="layui-input-inline">
                                    <select id="subchannelId" lay-filter="subchannelId" lay-search="" name="subchannelId" value="">
                                        <option value=""></option>
                                    </select>
                                </div>

                                <label for="" class="layui-form-label">开始时间</label>
                                <div class="layui-input-inline">
                                    <input type="" name="startTime" value="${(startTime)!}" class="layui-input" id="startTime"/>
                                </div>

                                <label for="" class="layui-form-label">结束时间</label>
                                <div class="layui-input-inline">
                                    <input type="" name="endTime" value="${(endTime)!}" class="layui-input" id="endTime"/>
                                </div>

                                <div class="layui-input-inline">
                                    <input type="submit" class="layui-btn" value="查询" id="btn1"/>
                                </div>

                            </div>
                        </form>

                    </div>
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
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>关键字id</th>
                            <th>关键字名称</th>
                            <th>安装数<#if sum1 ??>( 共(${(sum1)!})  )</#if></th>
                            <th>新增账号<#if sum2 ??>( 共(${(sum2)!}) )</#if></th>
                            <th>下载次数<#if sum3 ??>( 共(${(sum3)!}) )</#if></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if list ??>
                        <#list list as d>
                            <tr>
                                <td>${(d.date)!}</td>
                                <td>${(d.createKeywordId)!}</td>
                                <td>${(d.createKeywordName)!}</td>
                                <td>${(d.addNewUserNumber)!}</td>
                                <td>${(d.addNewAccountsNumber)!}</td>
                                <td>${(d.downloadButtonNumber)!}</td>
                            </tr>
                        </#list>
                        </#if>
                        </tbody>
                    </table>
                   <#-- 共${(subchannel.total)!}条
                    <@pager count="${(subchannel.total)!}" limit="${(subchannel.size)!}" curr="${(subchannel.current)!}" create="/subchannel/edit" />-->
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

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#startTime' //指定元素
            ,type: 'datetime'
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#endTime' //指定元素
            ,type: 'datetime'
        });
    });
</script>
<script>
    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form,
                layer = parent.layer === undefined ? layui.layer : parent.layer,
                $ = layui.jquery;
        var provinceText = "";
        var cityText = "";
        var areaText = "";
        //异步加载下拉框数据
        //监听上级下拉框
        form.on('select(channelId)', function (dataObj) {
            var va = $("#channelId").val();
            // document.getElementById("module").setAttribute("value", va);
            $("#subchannelId").empty();
            var html = '<option value="">请选择</option>';
            var value = $("#channelId").val();
            //异步加载下拉框数据
            $.post("/promotionPage/querySubchannelByChannelId", {"channelId": value}, function (data) {
                if (data.success)
                    var $html = "";
                if (data.data != null) {
                    //$html = "<option value='" + value + "'></option>";
                    $html = "<option value=''></option>";
                    $.each(data.data, function (index, item) {
                        $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                        console.log(data.data[0]);
                        //document.getElementById("module").setAttribute("value",data.data[0].id);
                    });
                    $("#subchannelId").append($html);
                    //append后必须从新渲染
                    form.render('select');
                }
            });
        });


        form.on('select(subchannelId)', function (dataObj) {
            var va = $("#subchannelId").val();
            // document.getElementById("module").setAttribute("value", va);
            $("#keyword").empty();
            var html = '<option value="">请选择</option>';
            var value = $("#subchannelId").val();
            //异步加载下拉框数据
            $.post("/keyword/findBySubchannelId", {"subchannelId": value}, function (data) {
                if (data.success)
                    var $html = "";
                if (data.data != null) {
                    //$html = "<option value='" + value + "'></option>";
                    $html = "<option value=''></option>";

                    $.each(data.data, function (index, item) {
                        $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                        console.log(data.data[0]);
                        //document.getElementById("module").setAttribute("value",data.data[0].id);
                    });
                    $("#keyword").append($html);
                    //append后必须从新渲染
                    form.render('select');
                }
            });
        });
    });
</script>

</body>
</html>