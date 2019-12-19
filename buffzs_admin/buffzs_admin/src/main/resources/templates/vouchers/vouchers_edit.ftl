<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>代金券新增</title>
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
                            <label class="layui-form-label">面值(元)</label>
                            <div class="layui-input-inline">
                                <input type="text" name="value" value="${(value)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">总数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sum" value="${(sum)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">剩余数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="surplusSum" value="${(surplusSum)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">超过可用</label>
                            <div class="layui-input-inline">
                                <input type="text" name="money" value="${(money)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">过期时间</label>
                            <div class="layui-input-inline">
                                <input type="" name="expirationTime" value="${(expirationTime)!}" class="layui-input" id="expirationTime"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">说明</label>
                            <div class="layui-input-block">
                                <input type="text" name="vouchersExplain" value="${(vouchersExplain)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <@save url="/vouchers/dosave" />
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

        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#expirationTime' //指定元素
                ,type: 'datetime'
            });
        });
    </script>
</div>
</body>

</html>