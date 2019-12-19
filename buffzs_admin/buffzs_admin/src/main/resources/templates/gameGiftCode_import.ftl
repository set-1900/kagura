<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
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
                <div class="layui-card-header">导入礼包</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <#--礼包-->
                        <div class="layui-form-item">
                            <label class="layui-form-label">礼包id</label>
                            <div class="layui-input-inline">
                                <select id="unique_id" name="unique_id" class="layui-input">
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>

                        <#--上传xls文件-->
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">文件选择</label>
                            <button type="button" class="layui-btn" id="test1">
                                <i class="layui-icon">&#xe67c;</i>Excel批量入库<p id="demoText"></p>
                            </button>
                        </div>

                        </br>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>

        $(function () {
            $.ajax(
                {
                    url: "/gameGiftCode/findAll",
                    datatype: "json",
                    success: function (data) {
                        var html = "<option></option>";
                        $.each(data, function (index, item) {
                            html += "<option id=" + item.id + " value=" + item.uniqueId + ">" + item.uniqueId + "</option>";
                        });
                        $("#unique_id").html(html);
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
    </script>
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
                    label.val(a + value + ",");

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

    <script>
        layui.use('upload', function () {
            var upload = layui.upload;
            //执行实例
            var uploadInst = upload.render({
                elem: '#test1' //绑定元素
                , url: '/gameGiftCode/batchImport' //上传接口
                , accept: 'file'
                , exts: 'xlsx|xls'
                ,data: {
                    unique_id: function(){
                        return $('#unique_id').val();
                    }
                }
                , done: function (res) {
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('导入失败');
                    }
                    //上传成功
                    //打印后台传回的地址: 把地址放入一个隐藏的input中, 和表单一起提交到后台, 此处略..
                    /*   console.log(res.data.src);*/
                    /* window.parent.uploadHeadImage(res.data.src);*/
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FFB800;">导入成功!!!</span>');
                    var image = res.data;
                    document.getElementById("imgUrl").setAttribute("value", image)
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">导入失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
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