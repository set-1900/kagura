<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑订单</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">编辑订单</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="orderNo" value="${(dbData.orderNo)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">真实名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="realname" value="${(dbData.realname)!}" required
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>
                            <label for="" class="layui-form-label">商户账号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" value="${(dbData.username)!}" required
                                       lay-verify="required"
                                       class="layui-input"/>
                            </div>
                        </div>
                        <#if !dbData?? || !dbData.password?? || dbData.password="">
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">商户密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password" required lay-verify="required"
                                       class="layui-input"/>
                            </div>
                        </div>
                        </#if>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">代理人</label>
                            <div class="layui-input-inline">
                                <select name="agentId" class="layui-input">
                                    <#list agents as a>
                                        <option value="${(a.agentId)!}" ${((dbData.agentId)==(a.agentId))?string("selected","")}>${(a.username)!}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">手机号码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone" value="${(dbData.phone)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">行业</label>
                            <div class="layui-input-inline">
                                <input type="text" name="trade" value="${(dbData.trade)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">费率</label>
                            <div class="layui-input-inline">
                                <input type="text" name="rate" value="${(dbData.rate)!}" value="${(dbData.realname)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">余额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="balance" value="${(dbData.balance)!}" value="${(dbData.realname)!}" class="layui-input"/>
                            </div>
                        </div>
                        <@save url="/customer/dosave" />
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