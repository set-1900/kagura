<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/order/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(page.current)!}"  hidden/>
                            <input type="text" name="size" value="30"  hidden/>
                            <div class="layui-form-item">
                                <label class="layui-form-label">商户订单号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="orderId" value="${(queryData.orderId)!}" placeholder="商户订单号" autocomplete="off" class="layui-input" />
                                </div>
                                <label class="layui-form-label">商户名称</label>
                                <div class="layui-input-inline">
                                    <select name="uid" class="layui-input">
                                        <option value=""></option>
                                        <#list customers as a>
                                            <option value="${(a.uid)!}" ${(queryData.uid==a.uid)?string("selected","")}>${(a.username)!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <label class="layui-form-label">订单金额</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="price" value="${(queryData.price)!}" placeholder="订单金额" autocomplete="off" class="layui-input" />
                                </div>
                                <label class="layui-form-label">真实金额</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="realprice" value="${(queryData.realprice)!}" placeholder="真实金额" autocomplete="off" class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">订单状态</label>
                                <div class="layui-input-inline">
                                    <select name="status"  class="layui-input" >
                                        <option value=""></option>
                                        <option value="1">支付成功</option>
                                        <option value="2">支付失败</option>
                                        <option value="3">未支付</option>
                                    </select>
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>
                        </form>
                    </div>
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th><input type="checkbox"></th>
                            <th>平台订单号</th>
                            <th>商户订单号</th>
                            <th>商户名称</th>
                            <th>订单金额</th>
                            <th>真实金额</th>
                            <th>订单状态</th>
                            <th>通知地址</th>
                            <th>返回地址</th>
                            <th>更新时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list dataPages.records as d>
                        <tr>
                            <td><input type="checkbox" data-id="${(d.orderNo)!}"></td>
                            <td>${(d.orderNo)!}</td>
                            <td>${(d.orderId)!}</td>
                            <td>${(d.customerName)!}</td>
                            <td>${(d.price)!}</td>
                            <td>${(d.realprice)!}</td>
                            <td>
                                <#if d.status==1>支付成功
                                <#elseif d.status==2>支付失败
                                <#elseif d.status==3>待支付
                                </#if>
                            </td>
                            <td>${(d.notifyUrl)!}</td>
                            <td>${(d.returnUrl)!}</td>
                            <td>${(d.updateTime?string('dd.MM.yyyy HH:mm:ss'))!}</td>
                            <td>
                                <#if role?? && role == "admin">
                                    <a lay-href="/order/toedit?pk=${(d.orderNo)!}" lay-id="${(d.orderNo)!}" class="layui-btn layui-btn-sm">编辑</a>
                                    <a href="javascript:;" onclick="doDel('/order/del?pk=${(d.orderNo)!}','删除订单')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(page.total)!}" limit="${(page.size)!}" curr="${(page.current)!}" />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>