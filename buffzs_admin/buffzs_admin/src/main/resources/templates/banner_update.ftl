<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改横幅</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改横幅</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(banner.id?c)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">资讯 / 游戏 ID</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="consultionId"  value="${(banner.consultionId)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">横幅所属模块名称</label>
                                <div class="layui-input-inline">
                                    <select name="moduleId"  class="layui-input" >
                                        <option  value="0" ${(banner.moduleId==0)?string("selected","")}>首页</option>
                                        <option  value="1" ${(banner.moduleId==1)?string("selected","")}>加速插件</option>
                                        <option  value="2" ${(banner.moduleId==2)?string("selected","")}>福利</option>
                                        <option  value="3" ${(banner.moduleId==3)?string("selected","")}>爆款</option>
                                        <option  value="4" ${(banner.moduleId==4)?string("selected","")}>二次元</option>

                                        <option  value="10001" ${(banner.moduleId==10001)?string("selected","")}>朋友圈</option>
                                        <option  value="10002" ${(banner.moduleId==10002)?string("selected","")}>充值</option>
                                        <option  value="10003" ${(banner.moduleId==10003)?string("selected","")}>开服表</option>
                                        <option  value="10004" ${(banner.moduleId==10004)?string("selected","")}>海外游戏</option>
                                    </select>
                                </div>
                            </div>

                            <input id="imageUrl" type="text" name="imageUrl" value="${(banner.imageUrl)!}" hidden/>

                            <div class="layui-form-item">
                                <label class="layui-form-label">更换横幅</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <img class="layui-upload-img headImage" src="${(banner.imageUrl)!}" id="demo1" width="200" height="100">
                                    <p id="demoText"></p>
                                <#--                 <img src="${(banner.imageUrl)!}" />-->
                                <#-- <input type="text" name="imageUrl" value="${(banner.imageUrl)!}"
                                    lay-verify="required" class="layui-input"/>-->
                                </div>
                            </div>

                            <div class="layui-input-inline">
                                <div class="layui-input-inline" style="width: 800px">
                                    <input type="radio" name="type" id="type" value="1" title="游戏"   ${(banner.type==1)?string("checked","")}>
                                    <input type="radio" name="type" id="type" value="2" title="资讯"   ${(banner.type==2)?string("checked","")}>
                                    <input type="radio" name="type" id="type" value="3" title="活动"   ${(banner.type==3)?string("checked","")}>
                                </div>
                            </div>

                        </div>

                        <@save url="/banner/updateSave" />
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
                , url: '/upload/image?status=banner'
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
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("imageUrl").setAttribute("value",image)
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