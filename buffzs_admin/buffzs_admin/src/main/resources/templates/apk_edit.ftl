<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增推广页</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<style type="text/css">
    #menu {
        font: 12px verdana, arial, sans-serif;
    }

    #menu, #menu li {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    #menu li {
        float: left;
    }

    #menu li a {
        padding: 8px 50px;
        background: #3A4953;
        color: #fff;
        text-decoration: none;
        border-right: 1px solid #000;
    }

    #menu li a:hover {
        background: #146C9C;
        color: #fff;
        text-decoration: none;
        border-right: 1px solid #000;
    }

    #menu li a.last {
        border-right: 0; /* 去掉左侧边框 */
    }
</style>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">推广页编辑</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <div class="layui-card-header">基本信息</div>

                        <#--渠道选择-->
                        <div class="layui-form-item">
                            <label class="layui-form-label">渠道选择</label>
                            <div class="layui-input-inline">
                                <select id="channelId" lay-filter="channelId" lay-verify="" lay-search="" name="channelId">
                                    <option value=""></option>
                                    <#list channelList as m>
                                        <option value="${(m.id)!}">${(m.name)!}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="layui-input-inline">
                                <select id="subchannelId" lay-filter="subchannelId" lay-search="" name="subchannelId" value="">
                                </select>
                            </div>
                        </div>

                        <script>
                            layui.use(['form', 'layer', 'jquery'], function () {
                                var form = layui.form,
                                    layer = parent.layer === undefined ? layui.layer : parent.layer,
                                    $ = layui.jquery;
                                var provinceText = "";
                                var cityText = "";
                                var areaText = "";
                                //异步加载下拉框数据
                                //监听上级下拉框
                                form.on('select(channelId)', function (dataObj) {
                                    var va = $("#channelId").val();
                                    // document.getElementById("module").setAttribute("value", va);
                                    $("#subchannelId").empty();
                                    var html = '<option value="">请选择</option>';
                                    var value = $("#channelId").val();
                                    //异步加载下拉框数据
                                    $.post("/promotionPage/querySubchannelByChannelId", {"channelId": value}, function (data) {
                                        if (data.success)
                                            var $html = "";
                                        if (data.data != null) {
                                            $html = "<option value=''></option>";

                                            $.each(data.data, function (index, item) {
                                                $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                console.log(data.data[0]);
                                                //document.getElementById("module").setAttribute("value",data.data[0].id);
                                            });
                                            $("#subchannelId").append($html);
                                            //append后必须从新渲染
                                            form.render('select');
                                        }
                                    });
                                });
                            });
                        </script>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">关键字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keywordName" value="${(keywordName)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <@save url="/apk/dosave" />

                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function afterSubmit() {
            var tabId = location.pathname + location.search;
            parent.closeTab(tabId);
            window.top.close();
        }

        function setHtmlTemplateVal(obj) {
            var pList = $("p");
            for (var i = 0; i < pList.length; i++) {
                pList[i].innerHTML="";
            }
            document.getElementById(obj).innerHTML="<span style=\"color: #FFB800;\">已选择</span>";
            $("#hemlTemplateId").attr("value", obj);
        }
    </script>
    <script>
        layui.use(['upload', 'element', 'layer'], function () {
            var upload = layui.upload, element = layui.element;
            //执行实例
            var uploadInst = upload.render({
                elem: '#test1' //绑定元素
                , url: '/upload/image?status=tui_html/pic' //上传接口
                , accept: 'file'
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
                    demoText.html('<span style="color: #FFB800;">上传成功!!!</span>');
                    var image = res.data;
                    document.getElementById("imgUrl").setAttribute("value", image)
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
        });
    </script>
</div>
</body>
</html>