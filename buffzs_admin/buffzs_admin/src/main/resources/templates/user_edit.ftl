<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增用户</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增用户</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">用户昵称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="username" value="${(username)!}" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">性别</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="sex" id="sex" value="1" title="男" checked>
                                    <input type="radio" name="sex" id="sex" value="2" title="女">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">省份</label>
                                <div class="layui-input-inline">
                                    <select id="province" lay-filter="province" lay-verify="province" lay-search=""  name="province">
                                        <option value=""></option>
                                          <#list area.data as m>
                                            <option value="${(m.name)!}">${(m.name)!}</option>
                                          </#list>
                                    </select>
                                </div>

                                <label for="" class="layui-form-label">城市</label>
                                <div class="layui-input-inline">
                                    <select id="city" lay-filter="city" lay-verify="required" lay-search="" name="city">
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
                                    form.on('select(province)', function(dataObj){
                                        var html = '<option value="">请选择</option>';
                                        var value = $("#province").val();

                                        //异步加载下拉框数据
                                        $.post("/user/findCity",{"name":value},function (data) {
                                            if(data.success)
                                                var $html = "";
                                            if(data.data != null) {
                                                $.each(data.data, function (index, item) {
                                                    $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                });
                                                $("#city").append($html);
                                                //append后必须从新渲染
                                                form.render('select');

                                            }
                                        });

                                    });
                                });
                            </script>


                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">个性签名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="signature" value="${(signature)!}" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">身份证</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="idCard" value="${(idCard)!}" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">真实姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="realname" value="${(realname)!}" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">qq号码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="qq" value="${(qq)!}" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">手机号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phone" value="${(phone)!}" class="layui-input"/>
                                </div>
                            </div>


                        <input id="icon" type="text" name="icon" value="" hidden/>
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-inline uploadHeadImage">
                                <div class="layui-upload-drag" id="headImg">
                                    <i class="layui-icon"></i>
                                    <p>点击上传图片，或将图片拖拽到此处</p>
                                </div>
                            </div>
                            <div class="layui-input-inline">
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo1" width="200" height="100">
                                    <p id="demoText"></p>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">用户类型</label>
                            <div class="layui-input-inline" style="width: 800px">
                                <input type="radio" name="userType"  value="1" title="buffzs"        >
                                <input type="radio" name="userType"  value="2" title="微信"           >
                                <input type="radio" name="userType"  value="3" title="QQ"           >
                                <input type="radio" name="userType"  value="4" title="微博"          >
                            </div>
                        </div>

                        <@save url="/user/dosave" />
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
                    var image = res.data
                    document.getElementById("icon").setAttribute("value",image)
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