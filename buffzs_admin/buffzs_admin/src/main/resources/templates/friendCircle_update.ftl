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
                <div class="layui-card-header">修改</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(friendCircle.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">用户ID</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userId" value="${(friendCircle.userId)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form">
                                <div class="layui-form-item">
                                    <label for="" class="layui-form-label">朋友圈内容</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="content" value="${(friendCircle.content)!}" class="layui-input"/>
                                    </div>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">点赞数</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="laud" value="${(friendCircle.laud)!}" class="layui-input"/>
                                </div>
                            </div>

                            <input id="img1" type="text" name="img1" value="${(friendCircle.img1)!}" hidden/>
                            <input id="img2" type="text" name="img2" value="${(friendCircle.img2)!}" hidden/>
                            <input id="img3" type="text" name="img3" value="${(friendCircle.img3)!}" hidden/>
                            <input id="img4" type="text" name="img4" value="${(friendCircle.img4)!}" hidden/>
                            <input id="img5" type="text" name="img5" value="${(friendCircle.img5)!}" hidden/>
                            <input id="img6" type="text" name="img6" value="${(friendCircle.img6)!}" hidden/>
                            <input id="img7" type="text" name="img7" value="${(friendCircle.img7)!}" hidden/>
                            <input id="img8" type="text" name="img8" value="${(friendCircle.img8)!}" hidden/>
                            <input id="img9" type="text" name="img9" value="${(friendCircle.img9)!}" hidden/>


                            <div class="layui-form-item">
                                <div>
                                    <label class="layui-form-label" style="width: 150px">图片1</label>
                                    <div class="layui-input-inline uploadHeadImage">
                                        <div class="layui-upload-drag" id="headImg1">
                                            <i class="layui-icon"></i>
                                            <p>点击上传图片，或将图片拖拽到此处</p>
                                        </div>
                                    </div>
                                    <div class="layui-input-inline">
                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img headImage" src="${(friendCircle.img1)!}" id="demo1"
                                                 width="200" height="100">
                                            <p id="demoText1"></p>
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <label class="layui-form-label" style="width: 150px">图片2</label>
                                    <div class="layui-input-inline uploadHeadImage">
                                        <div class="layui-upload-drag" id="headImg2">
                                            <i class="layui-icon"></i>
                                            <p>点击上传图片，或将图片拖拽到此处</p>
                                        </div>
                                    </div>
                                    <div class="layui-input-inline">
                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img headImage" src="${(friendCircle.img2)!}" id="demo2"
                                                 width="200" height="100">
                                            <p id="demoText2"></p>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="layui-form-item">

                                <div>
                                    <label class="layui-form-label" style="width: 150px">图片3</label>
                                    <div class="layui-input-inline uploadHeadImage">
                                        <div class="layui-upload-drag" id="headImg3">
                                            <i class="layui-icon"></i>
                                            <p>点击上传图片，或将图片拖拽到此处</p>
                                        </div>
                                    </div>
                                    <div class="layui-input-inline">
                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img headImage" src="${(friendCircle.img3)!}" id="demo3"
                                                 width="200" height="100">
                                            <p id="demoText3"></p>
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <label class="layui-form-label" style="width: 150px">图片4</label>
                                    <div class="layui-input-inline uploadHeadImage">
                                        <div class="layui-upload-drag" id="headImg4">
                                            <i class="layui-icon"></i>
                                            <p>点击上传图片，或将图片拖拽到此处</p>
                                        </div>
                                    </div>
                                    <div class="layui-input-inline">
                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img headImage" src="${(friendCircle.img4)!}" id="demo4"
                                                 width="200" height="100">
                                            <p id="demoText4"></p>
                                        </div>
                                    </div>
                                </div>

                            </div>


                            <div class="layui-form-item">

                                <label class="layui-form-label" style="width: 150px">图片5</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg5">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img headImage" src="${(friendCircle.img5)!}" id="demo5"
                                             width="200" height="100">
                                        <p id="demoText5"></p>
                                    </div>
                                </div>

                                <label class="layui-form-label" style="width: 150px">图片6</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg6">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img headImage" src="${(friendCircle.img6)!}" id="demo6"
                                             width="200" height="100">
                                        <p id="demoText6"></p>
                                    </div>
                                </div>
                            </div>


                            <div class="layui-form-item">

                                <label class="layui-form-label" style="width: 150px">图片7</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg7">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img headImage" src="${(friendCircle.img7)!}" id="demo7"
                                             width="200" height="100">
                                        <p id="demoText7"></p>
                                    </div>
                                </div>

                                <label class="layui-form-label" style="width: 150px">图片8</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg8">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img headImage" src="${(friendCircle.img8)!}" id="demo8"
                                             width="200" height="100">
                                        <p id="demoText8"></p>
                                    </div>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label" style="width: 150px">图片9</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg9">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img headImage" src="${(friendCircle.img9)!}" id="demo9"
                                             width="200" height="100">
                                        <p id="demoText9"></p>
                                    </div>
                                </div>
                            </div>



                        </div>
                        <@save url="/friendCircle/updateSave" />
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
                elem: '#headImg1'
                , url: '/upload/image?status=friend'
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
                    document.getElementById("img1").setAttribute("value", image)
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

        layui.use(["jquery", "upload", "form", "layer", "element"], function () {
            var $ = layui.$,
                    element = layui.element,
                    layer = layui.layer,
                    upload = layui.upload,
                    form = layui.form;
            //拖拽上传
            var uploadInst = upload.render({
                elem: '#headImg2'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo2').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText2');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img2").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText2');
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
                elem: '#headImg3'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo3').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText3');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img3").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText3');
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
                elem: '#headImg4'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo4').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText4');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img4").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText4');
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
                elem: '#headImg5'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo5').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText5');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img5").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText5');
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
                elem: '#headImg6'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo6').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText6');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img6").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText6');
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
                elem: '#headImg7'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo7').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText7');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img7").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText7');
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
                elem: '#headImg8'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo8').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText8');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img8").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText8');
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
                elem: '#headImg9'
                , url: '/upload/image?status=friend'
                , size: 1024
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo9').attr('src', result); //图片链接（base64）
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
                    var demoText = $('#demoText9');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("img9").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText9');
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