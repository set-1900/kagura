<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>充值比例修改</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改充值比例</div>
                <div class="layui-card-body">

                    <div class="layui-form">
                        <input type="text" name="id" value="${(rechargeProportion.id)!}" hidden/>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">金额(元)</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="price" value="${(rechargeProportion.price?c)!}" class="layui-input" lay-verify="required"/>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">B币</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="systemMoney" value="${(rechargeProportion.systemMoney?c)!}" class="layui-input" lay-verify="required"/>
                                </div>
                            </div>
                        </div>

                        <#--<div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">类型</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="type" value="${(rechargeProportion.type)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>-->

                        <@save url="/rechargeProportion/updateSave" />
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