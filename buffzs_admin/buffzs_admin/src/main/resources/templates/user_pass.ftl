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
                        <input type="text" name="id" value="${(id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">原密码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="oldpassword" required
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>
                            <label for="" class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="password" value="" required
                                       lay-verify="required"
                                       class="layui-input"/>
                            </div>
                            <label for="" class="layui-form-label">重复密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="repassword" value="" required
                                       lay-verify="required"
                                       class="layui-input"/>
                            </div>
                        </div>
                        <@save url="/user/repass" />
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