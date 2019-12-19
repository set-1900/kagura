<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>用户登录统计</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">
                    <div>
                        <div class="layui-col-md12">
                            <input type="text" name="" value="" id="" hidden/>
                            <#--渠道选择-->
                            <div class="layui-form-item">
                                <label class="layui-form-label">渠道</label>
                                <div class="layui-input-inline">
                                    <select id="channelId" lay-filter="channelId" lay-verify="" lay-search=""
                                            name="channel">
                                        <option value=""></option>
                                    </select>
                                </div>

                                <label class="layui-form-label">子渠道</label>
                                <div class="layui-input-inline">
                                    <select id="subchannelId" lay-filter="subchannelId" lay-search=""
                                            name="subchannel" value="">
                                    </select>
                                </div>

                                <label class="layui-form-label">关键字</label>
                                <div class="layui-input-inline">
                                    <select id="keyword" lay-filter="keyword" lay-search="" name="keyword">
                                    </select>
                                </div>
                                <input type="submit" class="layui-btn" value="查询" id="btn1"/>
                                <input type="submit" class="layui-btn" value="导出" id="btn2"/>
                                </br>
                            </div>
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
                                        $.post("/userLoginStatistics/querySubchannelByChannelId", {"channelId": value}, function (data) {
                                            if (data.success)
                                                var $html = "";
                                            if (data.data != null) {
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
                                    //异步加载下拉框数据
                                    //监听上级下拉框
                                    form.on('select(subchannelId)', function (dataObj) {
                                        var va = $("#subchannelId").val();
                                        // document.getElementById("module").setAttribute("value", va);
                                        $("#keyword").empty();
                                        var html = '<option value="">请选择</option>';
                                        var value = $("#subchannelId").val();
                                        //异步加载下拉框数据
                                        $.post("/userLoginStatistics/querykeywordBySubchannelId", {"subchannelId": value}, function (data) {
                                            if (data.success)
                                                var $html = "";
                                            if (data.data != null) {
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

                        </div>

                        <div class="layui-col-md12">
                            <form class="layui-form" id="dataForm" action="/userLoginStatistics/list" method="post">
                                <input type="text" name="date" value="1" id="aaa" hidden/>
                            </form>
                        </div>
                    </div>
                    <table class="layui-table">

                        <thead>
                        <tr>
                            <th style="width:150px">日期</th>
                            <th>渠道</th>
                            <th>新增用户数量</th>
                            <th>新增账号数量</th>
                            <th>活跃用户数量</th>
                            <th>活跃账号数量</th>
                            <th>启动次数</th>
                            <#--<th>次日活跃</th>
                            <th>七日活跃</th>
                            <th>十五日活跃</th>
                            <th>三十日活跃</th>-->
                        </tr>
                        </thead>
                        <tbody id="tbody">
                        <#--<#list userLoginStatistics as d>
                            <tr>
                                <td id="date${(d_index)!}"
                                    value="${(d.date?string('yyyy-MM-dd'))!}">${(d.date?string('yyyy-MM-dd'))!}</td>
                                <td><a id="${(d_index)!}" onclick="allChannelData(this)">全渠道</a></td>
                                <td>${(d.addNewUserNumber)!}</td>
                                <td>${(d.addNewAccountsNumber)!}</td>
                                <td>${(d.activeUserNumber)!}</td>
                                <td>${(d.activeAccountsNumber)!}</td>
                                <td>${(d.startNumber)!}</td>
                                &lt;#&ndash;<td>${(d.nextActive)!}</td>
                                <td>${(d.sevenActive)!}</td>
                                <td>${(d.fifteenActive)!}</td>
                                <td>${(d.thirtyActive)!}</td>&ndash;&gt;
                            </tr>
                        </#list>-->
                        </tbody>
                    </table>
                    <#--<@pager count="${(userLoginStatistics.total)!}" limit="${(userLoginStatistics.size)!}" curr="${(userLoginStatistics.current)!}" create="/userLoginStatistics/edit" />-->
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // 页面打开后查询页面第一个下拉框的数据
    $(function () {
        $.ajax(
            {
                url: "/userLoginStatistics/allChannel",
                datatype: "json",
                success: function (data) {
                    var html = "<option></option>";
                    $.each(data, function (index, item) {
                        html += "<option value=" + item.id + ">" + item.name + "</option>";
                    })
                    $("#channelId").html(html);
                    // layui框架重新渲染
                    // 原因: Layui会对select、checkbox、radio等原始元素隐藏，从而进行美化修饰处理。
                    // 但这需要依赖于form组件，所以你必须加载 form，并且执行一个实例。
                    // 值得注意的是：导航的Hover效果、Tab选项卡等同理（它们需依赖 element 模块）
                    layui.use(['form'], function () {
                        var form = layui.form;
                        form.render();
                    });
                }
            }
        )
    });

    // 页面打开后执行查询本月所有数据
    $(function () {
        $.ajax(
            {
                url: "/userLoginStatistics/list",
                datatype: "json",
                success: function (data) {
                    $("#tbody").html(data);
                    // layui框架重新渲染
                    // 原因: Layui会对select、checkbox、radio等原始元素隐藏，从而进行美化修饰处理。
                    // 但这需要依赖于form组件，所以你必须加载 form，并且执行一个实例。
                    // 值得注意的是：导航的Hover效果、Tab选项卡等同理（它们需依赖 element 模块）
                    layui.use(['form'], function () {
                        var form = layui.form;
                        form.render();
                    });
                }
            }
        )
    });

    // 查询按钮
    $("#btn1").click(
        function () {
            $.ajax(
                {
                    url: "/userLoginStatistics/list2",
                    data: {
                        "channel": $("#channelId").val(),
                        "subchannel": $("#subchannelId").val(),
                        "keyword": $("#keyword").val(),
                    },
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        $("#tbody").html(data);
                    }
                }
            );
        }
    );

    // 导出按钮
    $("#btn2").click(
        function () {
            var channelId = $("#channelId").val();
            var subchannelId = $("#subchannelId").val();
            var keyword = $("#keyword").val();
            var url = "/userLoginStatistics/export?channelId=" + channelId + "&subchannelId=" + subchannelId + "&keyword=" + keyword;
            window.open(url);
        }
    );

    // 下拉框改变事件
    layui.use(['form', 'layer'], function () {

        var form = layui.form;

        var layer = layui.layer;

        form.on('select(channelId)', function (data) {
            //触发内容
            $(".name").html($("#channelId").find("option:selected").text());
        });

    });

</script>

<script>
    function afterSubmit() {
        var tabId = location.pathname + location.search;
        parent.closeTab(tabId);
    }

    // 点击全渠道后查询全渠道数据
    function allChannelData(obj) {
        var date = "date" + obj.id;
        var v = document.getElementById(date).getAttribute("value")
        $.ajax(
            {
                url: "/userLoginStatistics/allChannelData",
                data: {
                    "date": v,
                    "channelId": $("#channelId").val()
                },
                async: true,
                type: "POST",
                datatype: "json",
                success: function (data) {
                    //在这里面输入任何合法的js语句
                    layer.open({
                        type: 1 //Page层类型
                        , area: ['700px', '500px']
                        , title: '全渠道数据 ' + v
                        , shade: 0.6 //遮罩透明度
                        , maxmin: false //允许全屏最小化
                        , anim: 5 //0-6的动画形式，-1不开启
                        , content: data
                    });
                }
            }
        );
    }

    //esc 关闭窗口
    $(document).ready(function () {
    }).keydown(
        function (e) {
            if (e.which === 27) {
                layer.closeAll();
            }
        }
    );
</script>

</body>
</html>