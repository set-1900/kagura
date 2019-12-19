<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>子渠道新增</title>
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
                            <label class="layui-form-label">主渠道</label>
                            <div class="layui-input-inline">
                                <select name="channelId" class="layui-input">
                                    <option value="" ></option>
                                        <#list channelList as a>
                                            <option value="${(a.id)!}">${(a.name)!}</option>
                                        </#list>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">子渠道名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="${(name)!}" class="layui-input" lay-verify="required"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">子渠道域名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="downloadUrl" value="${(downloadUrl)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">结算方式</label>
                            <div class="layui-input-inline">
                                <input type="text" name="stype" value="${(stype)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">扣量比例</label>
                            <div class="layui-input-inline">
                                <input type="text" name="discount" value="${(discount)!}" class="layui-input"/>
                            </div>
                        </div>

                        <@save url="/subchannel/dosave" />
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