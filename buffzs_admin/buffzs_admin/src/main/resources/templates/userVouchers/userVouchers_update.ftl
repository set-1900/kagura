<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户领取代金券修改</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">用户领取代金券修改</div>
                <div class="layui-card-body">

                    <div class="layui-form">
                        <input type="text" name="id" value="${(userVouchers.id?c)!}" hidden/>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">用户ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userId" value="${(userVouchers.userId?c)!}" class="layui-input"
                                       lay-verify="required"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">代金券ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="vouchersId" value="${(userVouchers.vouchersId?c)!}"
                                       class="layui-input"
                                       lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">使用状态</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="type" value="0"
                                       title="未使用" ${(userVouchers.type==0)?string("checked","")}>
                                <input type="radio" name="type" value="1"
                                       title="已使用" ${(userVouchers.type==1)?string("checked","")}>
                            </div>
                        </div>

                        <@save url="/userVouchers/updateSave" />
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