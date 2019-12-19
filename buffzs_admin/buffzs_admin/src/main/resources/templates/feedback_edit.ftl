<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增ssssssssss</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增fank</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">反馈类型</label>
                            <div class="layui-input-inline">
                                <select name="feedbackType" class="layui-input">
                                    <option value="" ></option>
                                        <#list feedbackType as f>
                                            <option value="${(f.id)!}">${(f.name)!}</option>
                                        </#list>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">反馈内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="content" value="${(content)!}" class="layui-input" />
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">邮箱或者qq</label>
                            <div class="layui-input-inline">
                                <input type="text" name="contact" value="${(contact)!}" class="layui-input" />
                            </div>
                        </div>

                        <input id="img" type="text" name="img" value="" hidden/>
                        <input id="img1" type="text" name="img1" value="" hidden/>
                        <input id="img2" type="text" name="img2" value="" hidden/>

                        <div class="layui-form-item">
                            <label class="layui-form-label">反馈图片1</label>
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

                        <div class="layui-form-item">
                            <label class="layui-form-label">反馈图片2</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg0">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo0"
                                         width="200" height="100">
                                    <p id="demoText0"></p>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">反馈图片3</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg1">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo1"
                                         width="200" height="100">
                                    <p id="demoText1"></p>
                                </div>
                            </div>
                        </div>


                        <@save url="/feedback/dosave" />
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

    <script type="text/javascript">
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
                , url: '/upload/image?status=feedback'
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
                    var image = res.data;
                    document.getElementById("img").setAttribute("value", image)
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

        layui.use(["jquery", "upload", "form", "layer", "element"], function () {
            var $ = layui.$,
                    element = layui.element,
                    layer = layui.layer,
                    upload = layui.upload,
                    form = layui.form;
            //拖拽上传
            var uploadInst = upload.render({
                elem: '#headImg0'
                , url: '/upload/image?status=feedback'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo0').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText0');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img1").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText0');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });
            element.init();
        });

        layui.use(["jquery", "upload", "form", "layer", "element"], function () {
            var $ = layui.$,
                    element = layui.element,
                    layer = layui.layer,
                    upload = layui.upload,
                    form = layui.form;
            //拖拽上传
            var uploadInst = upload.render({
                elem: '#headImg1'
                , url: '/upload/image?status=feedback'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText1');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img2").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText1');
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