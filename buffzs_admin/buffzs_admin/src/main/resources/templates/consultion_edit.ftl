<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增资讯</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增资讯</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">标题</label>
                            <div class="layui-input-inline">
                                <input type="text" name="title" value="${(title)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">资讯类型</label>
                            <div class="layui-input-inline" style="width: auto">
                                <input type="radio" name="type" id="type" value="1" title="咨讯" checked>
                                <input type="radio" name="type" id="type" value="2" title="攻略">
                                <input type="radio" name="type" id="type" value="3" title="原创">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">游戏名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="${(name)!}" id="gameName" class="layui-input"/>
                            </div>
                            <div class="layui-input-inline">
                                <input type="submit" class="layui-btn" value="搜索" id="btn"/>
                            </div>
                            <div class="layui-input-inline">
                                <select id="gameId" lay-filter="gameId" lay-verify="" lay-search="" name="gameId"></select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">tag</label>
                            <div class="layui-input-inline" style="width: auto">
                                <input type="radio" name="tag" id="tag" value="1" title="公告" checked>
                                <input type="radio" name="tag" id="tag" value="2" title="新闻">
                                <input type="radio" name="tag" id="tag" value="3" title="新手">
                                <input type="radio" name="tag" id="tag" value="4" title="高阶">
                                <input type="radio" name="tag" id="tag" value="5" title="评测">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">资讯内容</label>
                            <div class="layui-form-text" style="width:1000px;padding:5px;">
                                <textarea placeholder="请输入内容" class="layui-textarea" id="content" style="display: none"
                                          name="content" lay-verify="content">
                                </textarea>
                            </div>
                        </div>

                        <@save url="/consultion/dosave" />
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script>
        layui.use(['form', 'layer', 'jquery'], function () {
            var form = layui.form,
                    layer = parent.layer === undefined ? layui.layer : parent.layer,
                    $ = layui.jquery;
            $(document).on('click', '#btn', function () {
                var name = document.getElementById("gameName").value;
                $html = "";
                $.post("/consultion/selectGame", {"name": name}, function (data) {
                    if (data.success)
                        if (data.data != null) {
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

        <#--富文本-->
        layui.use(['form', 'layedit', 'laydate', 'jquery'], function () {
            var form = layui.form,
                    layer = layui.layer,
                    layedit = layui.layedit,
                    $ = layui.jquery,
                    laydate = layui.laydate;

            layedit.set({
                uploadImage: {
                    url: '/upload/richText?status=consultion'
                    , type: 'post' //默认post
                }
            });

            var index = layedit.build('content', {
                tool: ['strong', 'italic', 'del', '|', 'left', 'center', 'right', 'link', 'unlink', 'face'
                    , 'image'
                ]//设置需要的控件
                , height: 400   // 设置高度
            }); //建立编辑器

            form.verify({
                content: function () {
                    layedit.sync(index)
                }
            });

            //  layedit.getContent(index);

        });

        function afterSubmit() {
            var tabId = location.pathname + location.search;
            parent.closeTab(tabId);
        }
    </script>


</div>
</body>
</html>