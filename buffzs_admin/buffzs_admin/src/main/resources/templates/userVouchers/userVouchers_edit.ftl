<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户领取代金券新增</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label class="layui-form-label">用户ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userId" value="${(userId)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">代金券ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="vouchersId" value="${(vouchersId)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">使用状态</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="type"  value="0" title="未使用" checked>
                                <input type="radio" name="type"  value="1" title="已使用">
                            </div>
                        </div>

                        <@save url="/userVouchers/dosave" />
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