<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>代金券修改</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">代金券修改</div>
                <div class="layui-card-body">

                    <div class="layui-form">
                        <input type="text" name="id" value="${(vouchers.id)!}" hidden/>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">金额(元)</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="value" value="${(vouchers.value?c)!}" class="layui-input"
                                           lay-verify="required"/>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">说明</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="vouchersExplain" value="${(vouchers.vouchersExplain)!}"
                                           class="layui-input" lay-verify="required"/>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">超过可用</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="money" value="${(vouchers.money?c)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">总量</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="sum" value="${(vouchers.sum?c)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">剩余数量</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="surplusSum" value="${(vouchers.surplusSum?c)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">过期时间</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="expirationTime" value="${(vouchers.expirationTime?string('yyyy-MM-dd HH:mm:ss'))!}" class="layui-input" id="expirationTime"/>
                                </div>
                            </div>
                        </div>

                        <@save url="/vouchers/updateSave" />
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