<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增游戏服务</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏名</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" id="aaa" />
                                <input type="submit" class="layui-btn" value="搜索" id="btn"/>
                            </div>

                            <div class="layui-input-inline">
                                <select id="gameId" lay-filter="gameId" lay-verify="" lay-search="" name="gameId"></select>
                            </div>
                        </div>
                        <script>
                            layui.use(['form','layer','jquery'],function(){
                                var form = layui.form,
                                        layer = parent.layer === undefined ? layui.layer : parent.layer,
                                        $ = layui.jquery;
                                $(document).on('click', '#btn', function () {
                                    var name = document.getElementById("aaa").value;
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
                                <input type="text" name="areaId" value="${(areaId)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">服务器名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="serverName" value="${(serverName)!}" class="layui-input"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">开服时间</label>
                            <div class="layui-input-inline">
                                <input type="" name="openDate" value="${(openDate)!}" class="layui-input" id="openDate"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">是否热门</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="ifhot" id="ifhot" value="1" title="是" checked>
                                <input type="radio" name="ifhot" id="ifhot" value="0" title="否">
                            </div>
                        </div>


                        <@save url="/gameServer/dosave" />
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