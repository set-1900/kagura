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
                <div class="layui-card-header">新增游戏标签</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">标签名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="${(name)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">标签颜色</label>
                            <div class="layui-input-block">
                                <input type="radio" name="color" value="#F35858" title="红色" checked/>
                                <input type="radio" name="color" value="#62BCF8" title="蓝色">
                                <input type="radio" name="color" value="#F8AF40" title="黄色">
                                <input type="radio" name="color" value="#C281F6" title="紫色">
                                <input type="radio" name="color" value="#7DE244" title="绿色">
                            </div>
                        </div>

                        <@save url="/label/dosave" />
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
</div>
</body>
</html>