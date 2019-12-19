<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改html模板</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改html模板</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(htmlTemplate.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">资讯ID</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name"  value="${(htmlTemplate.name)!}" lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">上传模板</label>
                                <button type="button" class="layui-btn" id="test1">
                                    <i class="layui-icon">&#xe67c;</i>选择文件<p id="demoText"></p>
                                </button>
                                <input id="templateUrl" type="text" name="templateUrl" value="${(htmlTemplate.templateUrl)!}" hidden/>
                            </div>

                        </div>
                        <@save url="/htmlTemplate/updateSave" />
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
    <script>
        layui.use(['upload','element','layer'], function(){
            var upload = layui.upload , element = layui.element;
            //执行实例
            var uploadInst = upload.render({
                elem: '#test1' //绑定元素
                ,url: '/upload/htmlTemplate' //上传接口
                ,accept: 'file'
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
                    document.getElementById("templateUrl").setAttribute("value", image)
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
</div>
</body>
</html>