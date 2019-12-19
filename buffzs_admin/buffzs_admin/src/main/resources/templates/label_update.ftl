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
                <div class="layui-card-header">修改标签</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(label.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">标签名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name"  value="${(label.name)!}" lay-verify="required" class="layui-input"/>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">标签颜色</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="color" value="#F35858" title="红色" ${(label.color=="#F35858")?string("checked","")}/>
                                    <input type="radio" name="color" value="#62BCF8" title="蓝色" ${(label.color=="#62BCF8")?string("checked","")}>
                                    <input type="radio" name="color" value="#F8AF40" title="黄色" ${(label.color=="#F8AF40")?string("checked","")}>
                                    <input type="radio" name="color" value="#C281F6" title="紫色" ${(label.color=="#C281F6")?string("checked","")}>
                                    <input type="radio" name="color" value="#7DE244" title="绿色" ${(label.color=="#7DE244")?string("checked","")}>
                                </div>
                            </div>

                        </div>
                        <@save url="/label/updateSave" />
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