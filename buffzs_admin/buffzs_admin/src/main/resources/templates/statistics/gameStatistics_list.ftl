<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>游戏点击统计</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">
                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/userLoginStatistics/game" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(list.current)!}"  hidden/>
                            <input type="text" id="size" name="size" value="10"  hidden/>
                            <div class="layui-form-item">

                                <label class="layui-form-label">游戏id</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="gameId" value="${(gameId)!}" autocomplete="off"
                                           class="layui-input" id="name"/>
                                </div>
                                <label for="" class="layui-form-label">开始时间</label>
                                <div class="layui-input-inline">
                                    <input type="" name="startTime" value="${(startTime)!}" class="layui-input"
                                           id="startTime"/>
                                </div>
                                <label for="" class="layui-form-label">结束时间</label>
                                <div class="layui-input-inline">
                                    <input type="" name="endTime" value="${(endTime)!}" class="layui-input"
                                           id="endTime"/>
                                </div>

                                <input type="submit" class="layui-btn" value="查询" id="btn1"/>

                                <#--<button class="layui-btn" lay-submit="" lay-filter="submit">查询</button>-->
                            </div>
                        </form>
                    </div>

                    <table class="layui-table">
                        <colgroup>
                            <col width="80">
                            <col width="50">
                            <col width="80">
                            <col width="80">
                            <col width="80">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>游戏id</th>
                            <th>游戏名称</th>
                            <th>游戏详情点击次数<#if sum1 ??>( 共(${(sum1)!}) )</#if></th>
                            <th>游戏下载次数<#if sum2 ??>( 共(${(sum2)!}) )</#if></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if list ??>
                        <#list list.data as d>
                            <tr>
                                <td>${(d.date)!}</td>
                                <td>${(d.gameId)!}</td>
                                <td>${(d.gameName)!}</td>
                                <td>${(d.gameClickCount)!}</td>
                                <td>${(d.gameDownloadCount)!}</td>
                            </tr>
                        </#list>
                        </#if>
                        </tbody>
                    </table>
                    共${(list.total)!}条
                 <#--<@pager count="${(list.total)!}" limit="${(list.size)!}" curr="${(list.current)!}" create="" />-->
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

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#startTime' //指定元素
            , type: 'datetime'
        });
    });

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#endTime' //指定元素
            , type: 'datetime'
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

        form.on('submit(submit)', function (data) {
            var current = document.getElementById("pageCurr").value;
            var size = document.getElementById("size").value;
            var startTime = document.getElementById("startTime").value;
            var endTime = document.getElementById("endTime").value;
            $.post("/userLoginStatistics/game", {"current":current,"size":size,"startTime":startTime,"endTime":endTime}, function (re) {
                if (re.success){
                    layer.msg(re.message);
                }
                console.log(re);
                layer.msg(re.message);
        })
    });
</script>

</body>
</html>