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
                <div class="layui-card-header">新增工具</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">工具名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="title" value="${(title)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">工具详情地址</label>
                            <div class="layui-input-inline">
                                <input type="text" name="detail" value="${(detail)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">工具描述</label>
                            <div class="layui-input-inline">
                                <input type="text" name="shortDescribe" value="${(shortescribe)!}" class="layui-input"/>
                            </div>
                        </div>


                        <input id="icon" type="text" name="icon" value="" hidden/>
                        <div class="layui-form-item">
                            <label class="layui-form-label">游戏工具图标</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo"
                                         width="200" height="100">
                                    <p id="demoText"></p>
                                </div>
                            </div>
                        </div>

                        <@save url="/tools/dosave" />
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

        layui.use(["jquery", "upload", "form", "layer", "element"], function () {
            var $ = layui.$,
                    element = layui.element,
                    layer = layui.layer,
                    upload = layui.upload,
                    form = layui.form;
            //拖拽上传
            var uploadInst = upload.render({
                elem: '#headImg'
                , url: '/upload/image?status=tools'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo').attr('src', result); //图片链接（base64）
                    });
                }
                , done: function (res) {
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                    //上传成功
                    //打印后台传回的地址: 把地址放入一个隐藏的input中, 和表单一起提交到后台, 此处略..
                    /*   console.log(res.data.src);*/
                    /* window.parent.uploadHeadImage(res.data.src);*/
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data
                    document.getElementById("icon").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });
            element.init();
        });



    </script>
</div>
</body>
</html>