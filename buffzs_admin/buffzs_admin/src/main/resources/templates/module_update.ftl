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
                <div class="layui-card-header">修改模块</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(module.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">模块名字</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" required value="${(module.name)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>


                            <#--<div class="layui-form-item">
                                <label for="" class="layui-form-label">上级模块</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="" value="" class="layui-input" id="aaa" />
                                    <input type="submit" class="layui-btn" value="搜索" id="btn"/>
                                </div>

                                <div class="layui-input-inline">
                                    <select id="pid" lay-filter="pid" lay-verify="" lay-search="" name="pid">
                                        <option value="0" >首页</option>
                                    <#if buffModules ??>
                                        <#list buffModules as a>

                                                <option value="${(a.id)!}" ${(a.id==module.pid)?string("selected","")}>${(a.name)!} </option>

                                        </#list>
                                    </#if>
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
                                        $("#pid").empty();
                                        $html = "";
                                        $.post("/module/find",{"name":name},function (data) {
                                            if(data.success)
                                                if(data.data != null) {
                                                    $.each(data.data, function (index, item) {
                                                        $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                    });
                                                    console.log("html==" + $html);
                                                    $("#pid").append($html);
                                                    form.render('select');
                                                }
                                        });
                                    });
                                });
                            </script>-->

                            <input id="module" type="text" name="pid" value="" hidden/>
                            <div class="layui-form-item">
                                <label class="layui-form-label">模块</label>
                                <div class="layui-input-inline">
                                    <select id="module1" lay-filter="module1"  lay-search="" name="">
                                        <option value="0">首页</option>
                                        <#if module2 ??>
                                            <#list module1 as a>
                                                <option value="${(a.id)!}"} ${(a.id==module.pid)?string("selected","")} >${(a.name)!}</option>
                                            </#list>
                                        <#else>
                                            <#list module1 as a>
                                            <option value="${(a.id)!}"} ${(a.id==module.pid)?string("selected","")} >${(a.name)!}</option>
                                            </#list>
                                        </#if>
                                    </select>
                                </div>

                                <div class="layui-input-inline">
                                    <select id="module2" lay-filter="module2"  lay-search="" name="">
                                        <option value=""></option>
                                        <#if module2 ??>
                                            <#list module2 as a>
                                                <option value="${(a.id)!}" ${(a.id==module.id)?string("selected","")}>${(a.name)!}</option>
                                            </#list>
                                        <#else><option value=""></option></#if>
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
                                        $.post("/module/queryByPIdAndType",{"pid":value},function (data) {
                                            if(data.success)
                                                var $html = '<option value="">请选择</option>';
                                            if(data.data != null) {
                                                $.each(data.data, function (index, item) {
                                                    $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                    console.log(data.data[0]);
                                                    //document.getElementById("module").setAttribute("value",data.data[0].id);
                                                });
                                                $("#module2").append($html);
                                                //append后必须从新渲染
                                                form.render('select');
                                                // $("#module1").removeAttr("name");
                                                // $("#module2").attr("name","module");
                                            }
                                        });
                                    });

                                    form.on('select(module2)', function(dataObj){
                                        var a = $("#module2").val();
                                        document.getElementById("module").setAttribute("value",a);
                                    });
                                });
                            </script>


                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">类型</label>
                                <div class="layui-input-inline" style="width: 800px">
                                    <input type="radio" name="type" id="type" value="1" title="顶部菜单模块" ${(module.type==1)?string("checked","")}>
                                    <input type="radio" name="type" id="type" value="2" title="首页内容模块" ${(module.type==2)?string("checked","")}>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">游戏排列方式</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="sequence" id="sequence" value="0" title="竖向" ${(module.sequence==0)?string("checked","")}>
                                    <input type="radio" name="sequence" id="sequence" value="1" title="横向" ${(module.sequence==1)?string("checked","")}>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">模块的等级</label>
                                <div class="layui-input-inline" style="width: 800px">
                                    <#if module.level ??>
                                        <input type="radio" name="level" value="0" title="无" ${(module.level==0)?string("checked","")}>
                                        <input type="radio" name="level" value="1" title="1级" ${(module.level==1)?string("checked","")}>
                                        <input type="radio" name="level" value="2" title="2级" ${(module.level==2)?string("checked","")}>
                                        <input type="radio" name="level" value="3" title="3级" ${(module.level==3)?string("checked","")}>
                                    <#else>
                                        <input type="radio" name="level" value="0" title="无"  >
                                        <input type="radio" name="level" value="1" title="1级" >
                                        <input type="radio" name="level" value="2" title="2级" >
                                        <input type="radio" name="level" value="3" title="3级" >
                                    </#if>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">所属位置</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="moduleType"  value="1" title="首页"     ${(module.moduleType==1)?string("checked","")}>
                                    <input type="radio" name="moduleType"  value="2" title="海外游戏" ${(module.moduleType==2)?string("checked","")}>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">游戏图标</label>
                                <div class="layui-input-inline uploadHeadImage">
                                    <div class="layui-upload-drag" id="headImg">
                                        <i class="layui-icon"></i>
                                        <p>点击上传图片，或将图片拖拽到此处</p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img headImage" src="${(module.iconUrl)!}" id="demo"
                                             width="200" height="100">
                                        <p id="demoText"></p>
                                    </div>
                                </div>
                            </div>
                            <input id="iconUrl"   type="text" name="iconUrl"   value="${(module.iconUrl)!}" hidden/>
                        </div>
                        <@save url="/module/updateSave" />
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
                , url: '/upload/image?status=iconImg'
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
                    document.getElementById("iconUrl").setAttribute("value", image)
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