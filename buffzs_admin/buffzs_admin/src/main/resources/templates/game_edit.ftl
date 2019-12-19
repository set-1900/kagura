<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增游戏页</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增游戏</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="${(name)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <input id="label" type="text" name="label" value="" hidden/>
                            <label class="layui-form-label">游戏标签</label>
                            <div class="layui-input-block">
                                <#list labelList as a>
                                      <input type="checkbox" lay-filter="number"  name="like" title="${(a.name)!}" value="${(a.id)!}">
                                </#list>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏描述</label>
                            <div class="layui-input-inline">
                                <input type="text" name="shortDescribe" value="${(shortDescribe)!}"
                                       class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">版本号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="version" value="${(version)!}" class="layui-input"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏包大小</label>
                            <div class="layui-input-inline">
                                <input type="text" name="size" value="${(size)!}" class="layui-input"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏下载地址</label>
                            <button type="button" class="layui-btn" id="test1">
                                <i class="layui-icon">&#xe67c;</i>选择文件
                            </button>
                            <p id="demoText"></p>
                            <div style="height: 20px;"></div>
                            <div class="layui-progress layui-progress-big" lay-showPercent="yes" lay-filter="progressBar">
                                <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>

                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                </div>
                            </div>
                            <input id="downloadUrl" type="text" name="downloadUrl" value="" hidden/>
                        </div>
                        <script>
                            layui.use(['upload','element','layer'], function(){
                                var upload = layui.upload , element = layui.element;
                                //执行实例
                                var uploadInst = upload.render({
                                    elem: '#test1' //绑定元素
                                    ,url: '/upload/file' //上传接口
                                    ,accept: 'file'
                                    //,auto: false // 设置不自动提交
                                    ,progress: function(e , percent) {
                                        console.log("进度：" + percent + '%');
                                        element.progress('progressBar',percent  + '%');
                                    }
                                    ,done: function(res){
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
                                        document.getElementById("downloadUrl").setAttribute("value", image)
                                    }
                                    ,error: function(){
                                        //演示失败状态，并实现重传
                                        var demoText = $('#demoText');
                                        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                                        demoText.find('.demo-reload').on('click', function () {
                                            uploadInst.upload();
                                        });
                                    }
                                });
                            });
                        </script>


                        <div class="layui-form-item">
                            <label class="layui-form-label">游戏类别</label>
                            <div class="layui-input-inline">
                                <select name="genres" class="layui-input">
                                    <option value="" ></option>
                                        <#list genresList as a>
                                            <option value="${(a.id)!}">${(a.name)!}</option>
                                        </#list>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏包名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="packageName" value="${(packageName)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <input id="label" type="text" name="module" value="" hidden/>
                            <label class="layui-form-label">模块</label>
                            <div class="layui-input-block">
                                <#list moduleList as a>
                                    <input type="checkbox" lay-filter="number1"  name="like" title="${(a.name)!}" value="${(a.id)!}">
                                </#list>
                            </div>
                        </div>
                        <script type="text/javascript">

                            layui.use(['form', 'laydate'], function () {
                                var $ = layui.$//Jquery
                                        , form = layui.form;//表单

                                //监听复选框
                                form.on('checkbox(number1)', function (data) {
                                    var module = $('input[name="module"]'),
                                            value = data.value,
                                            array = module.val().split(",");
                                    if (data.elem.checked) {
                                        var a = module.val();
                                        module.val( a + value + ",");

                                    } else {
                                        var newnumber = "";
                                        for (var i = 0; i < array.length; i++) {
                                            var str = array[i];
                                            newnumber += (str != value && str != "" && str != null) ? str + "," : "";
                                        }
                                        label.val(newnumber);

                                    }
                                    console.log(value)
                                });


                            });
                        </script>

                        <#--<input id="module" type="text" name="module" value="" hidden/>
                        <div class="layui-form-item">
                            <label class="layui-form-label">模块</label>
                            <div class="layui-input-inline">
                                <select id="module1" lay-filter="module1" lay-verify="required" lay-search=""  name="">
                                    <option value=""></option>
                                          <#list moduleList as m>
                                            <option value="${(m.id)!}">${(m.name)!}</option>
                                          </#list>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select id="module2" lay-filter="module2"  lay-search="" name="">

                                </select>
                            </div>
                        </div>
                        <script>
                            layui.use(['form','layer','jquery'],function(){
                                var form = layui.form,
                                layer = parent.layer === undefined ? layui.layer : parent.layer,
                                $ = layui.jquery;
                                var provinceText = "";
                                var cityText = "";
                                var areaText = "";
                                //异步加载下拉框数据
                                //监听上级下拉框
                                form.on('select(module1)', function(dataObj){
                                    var va = $("#module1").val();
                                    document.getElementById("module").setAttribute("value",va);
                                    $("#module2").empty();
                                    var html = '<option value="">请选择</option>';
                                    var value = $("#module1").val();
                                    //异步加载下拉框数据
                                    $.post("/module/queryByPId",{"pid":value},function (data) {
                                        if(data.success)
                                            var $html = "";
                                            if(data.data != null) {
                                                $.each(data.data, function (index, item) {
                                                    $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                    console.log(data.data[0]);
                                                    document.getElementById("module").setAttribute("value",data.data[0].id);
                                                });
                                                $("#module2").append($html);
                                                //append后必须从新渲染
                                                form.render('select');
                                            }
                                    });
                                });

                                form.on('select(module2)', function(dataObj){
                                    var a = $("#module2").val();
                                    document.getElementById("module").setAttribute("value",a);
                                });
                            });
                        </script>-->

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏介绍详情</label>
                            <div class="layui-form-text" style="width:500px;padding:5px;">
                                <textarea placeholder="请输入内容" class="layui-textarea" id="detailDescribe" style="display: none"
                                          name="detailDescribe" lay-verify="detailDescribe">
                                </textarea>
                            </div>
                        </div>
         <#--               <div class="layui-form-item">
                            <label for="" class="layui-form-label">插件</label>
                            <div class="layui-input-inline">
                                <select name="pluginid" class="layui-input">
                                    <option value=""></option>
                                        <#list pluginList as a>
                                            <option value="${(a.id)!}">${(a.name)!}</option>
                                        </#list>
                                </select>
                            </div>
                        </div>-->

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">横幅推荐</label>
                                <#--<input type="text" name="ifbanner" value="${(ifbanner)!}" class="layui-input"/>-->
                                <div class="layui-input-inline">
                                    <input type="radio" name="ifbanner" id="ifbanner" value="0" title="否" checked>
                                    <input type="radio" name="ifbanner" id="ifbanner" value="1" title="是">
                                </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">插件</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="pluginid" id="pluginid" value="0" title="否" checked>
                                <input type="radio" name="pluginid" id="pluginid" value="1" title="是">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">游戏所属国家或地区</label>
                            <div class="layui-input-inline">
                                <select name="countryId" class="layui-input">
                                        <#list countryList as a>
                                            <option value="${(a.id)!}">${(a.country)!}</option>
                                        </#list>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏的等级</label>
                            <div class="layui-input-inline" style="width: 800px">
                                <input type="radio" name="level" value="0" title="0" >
                                <input type="radio" name="level" value="1" title="1级" >
                                <input type="radio" name="level" value="2" title="2级" >
                                <input type="radio" name="level" value="3" title="3级" >
                            </div>
                        </div>

                        <div class="layui-form-item" id="haiWaiLevel">
                            <label for="" class="layui-form-label">海外等级</label>
                            <div class="layui-input-block">
                                <input type="radio" name="haiWaiLevel" value="0" title="0" >
                                <input type="radio" name="haiWaiLevel" value="1" title="1级" >
                                <input type="radio" name="haiWaiLevel" value="2" title="2级" >
                                <input type="radio" name="haiWaiLevel" value="3" title="3级" >
                            </div>
                        </div>

                        <div class="layui-form-item" id="haiWaiLevel">
                            <label for="" class="layui-form-label">火热图标</label>
                            <div class="layui-input-block">
                                <input type="radio" name="iconId" value="" title="无">
                                <#if gameIcons ?? >
                                    <#list gameIcons as a>
                                        <input type="radio" name="iconId" value="${(a.id)!}" title="${(a.name)!}">
                                    </#list>
                                </#if>
                            </div>
                        </div>

                        <div class="layui-form-item" id="haiWaiLevel">
                            <label for="" class="layui-form-label">游戏状态</label>
                            <div class="layui-input-block">
                                <input type="radio" name="gameStatus" value="1" title="上架" checked>
                                <input type="radio" name="gameStatus" value="0" title="下架">
                            </div>
                        </div>

                        <input id="icon" type="text" name="icon" value="" hidden/>
                        <input id="pic_h" type="text" name="pic_h" value="" hidden/>
                        <input id="pic_v1" type="text" name="pic_v1" value="" hidden/>
                        <input id="pic_v2" type="text" name="pic_v2" value="" hidden/>
                        <input id="pic_v3" type="text" name="pic_v3" value="" hidden/>
                        <input id="pic_v4" type="text" name="pic_v4" value="" hidden/>
                        <input id="pic_v5" type="text" name="pic_v5" value="" hidden/>
                        <input id="pic_v6" type="text" name="pic_v6" value="" hidden/>


                        <div class="layui-form-item">
                            <label class="layui-form-label" style="width: 150px">游戏图标</label>
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

                            <label class="layui-form-label" style="width: 150px">游戏横向宣传图</label>
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
                            <label class="layui-form-label" style="width: 150px">游戏宣传图竖屏1</label>
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

                            <label class="layui-form-label" style="width: 150px">游戏宣传图竖屏2</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg2">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo2"
                                         width="200" height="100">
                                    <p id="demoText2"></p>
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label class="layui-form-label" style="width: 150px">游戏宣传图竖屏3</label>
                            <div class="layui-input-inline uploadHeadImage">
                            <div class="layui-upload-drag" id="headImg3">
                                <i class="layui-icon"></i>
                                <p>点击上传图片，或将图片拖拽到此处</p>
                            </div>
                            </div>
                            <div class="layui-input-inline">
                            <div class="layui-upload-list">
                                <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo3"
                                     width="200" height="100">
                                <p id="demoText3"></p>
                            </div>
                            </div>


                            <label class="layui-form-label" style="width: 150px">游戏宣传图竖屏4</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg4">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo4"
                                         width="200" height="100">
                                    <p id="demoText4"></p>
                                </div>
                            </div>
                        </div>



                        <div class="layui-form-item">

                            <label class="layui-form-label" style="width: 150px">游戏宣传图竖屏5</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg5">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo5"
                                         width="200" height="100">
                                    <p id="demoText5"></p>
                                </div>
                            </div>


                            <label class="layui-form-label" style="width: 150px">游戏宣传图竖屏6</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg6">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo6"
                                         width="200" height="100">
                                    <p id="demoText6"></p>
                                </div>
                            </div>
                            
                        </div>

                        <@save url="/game/dosave" />
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">

        layui.use(['form', 'laydate'], function () {
            var $ = layui.$//Jquery
                    , form = layui.form;//表单

            //监听复选框
            form.on('checkbox(number)', function (data) {
                var label = $('input[name="label"]'),
                       value = data.value,
                        array = label.val().split(",");
                if (data.elem.checked) {
                    var a = label.val();
                    label.val( a + value + ",");

                } else {
                    var newnumber = "";
                    for (var i = 0; i < array.length; i++) {
                        var str = array[i];
                        newnumber += (str != value && str != "" && str != null) ? str + "," : "";
                    }
                    label.val(newnumber);

                }
                console.log(value)
            });




        });
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
                , url: '/upload/image?status=game'
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

        layui.use(["jquery", "upload", "form", "layer", "element"], function () {
            var $ = layui.$,
                    element = layui.element,
                    layer = layui.layer,
                    upload = layui.upload,
                    form = layui.form;
            //拖拽上传
            var uploadInst = upload.render({
                elem: '#headImg0'
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_h").setAttribute("value", image)
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
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_v1").setAttribute("value", image)
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
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_v2").setAttribute("value", image)
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
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_v3").setAttribute("value", image)
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
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_v4").setAttribute("value", image)
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
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_v5").setAttribute("value", image)
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
                , url: '/upload/image?status=game'
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
                    document.getElementById("pic_v6").setAttribute("value", image)
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


    </script>

    <#--富文本-->
    <script>
        layui.use(['form', 'layedit', 'laydate', 'jquery'], function(){
        var form = layui.form,
                layer = layui.layer,
                layedit = layui.layedit,
                $ = layui.jquery,
                laydate = layui.laydate;

        layedit.set({
            uploadImage: {
                url: '/upload/image?status=game' //接口url
                ,type: 'post' //默认post
            }
        });

        var index  = layedit.build('detailDescribe',{
            tool: [
                //'strong', 'italic', 'del', '|',
                'left', 'center', 'right'
                // , 'link', 'unlink','image', 'face'
            ]//设置需要的控件
                    //height: 280 //设置高度
        }); //建立编辑器

        form.verify({
            detailDescribe:function () {
                layedit.sync(index)
            }
        });
       // layedit.getContent(index);
        })
    </script>


</div>
</body>
</html>