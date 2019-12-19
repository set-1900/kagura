<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改游戏服务</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="serverId" value="${(gameServer.serverId)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">游戏名</label>
                                <div class="layui-input-inline">
                                    <input type="text" value="${(gameServer.gameName)!}"  class="layui-input" id="aaa"/>
                                    <input type="submit" class="layui-btn" value="搜索" id="btn"/>
                                </div>
                                <div class="layui-input-inline">
                                    <select id="gameId" lay-filter="gameId" lay-verify="" lay-search="" name="gameId">
                                        <option value="${(gameServer.gameId)!}">${(gameServer.gameName)!}</option>
                                    </select>
                                </div>
                            </div>
                            <script>
                                layui.use(['form','layer','jquery'],function(){
                                    var form = layui.form,
                                            layer = parent.layer === undefined ? layui.layer : parent.layer,
                                            $ = layui.jquery;
                                    $(document).on('click', '#btn', function () {
                                        var name = document.getElementById("aaa").value;
                                        $("#gameId").empty();
                                        $html = "";
                                        $.post("/game/selectGame",{"name":name},function (data) {
                                            if(data.success)
                                                if(data.data != null) {
                                                    $.each(data.data, function (index, item) {
                                                        $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                    });
                                                    console.log("html==" + $html);
                                                    $("#gameId").append($html);
                                                    form.render('select');
                                                }
                                        });
                                    });
                                });
                            </script>


                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">所属大区</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="areaId"  value="${(gameServer.areaId)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">服务器名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="serverName"  value="${(gameServer.serverName)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">开服时间</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="openDate"  value="${(gameServer.openDate?string('yyyy-MM-dd HH:mm:ss'))!}"
                                           lay-verify="required" class="layui-input" id="openDate"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">是否热门</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="ifhot"  value="1" title="是" ${(gameServer.ifhot=='1')?string("checked","")}>
                                    <input type="radio" name="ifhot"  value="0" title="否" ${(gameServer.ifhot=='0')?string("checked","")}>
                                </div>
                            </div>

                        </div>
                        <@save url="/gameServer/updateSave" />
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
                elem: '#openDate' //指定元素
                ,type: 'datetime'
            });
        });
    </script>
</div>
</body>
</html>