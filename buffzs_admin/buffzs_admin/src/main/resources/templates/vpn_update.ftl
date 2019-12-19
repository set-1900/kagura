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
                <div class="layui-card-header">修改VPN</div>
                <div class="layui-card-body">

                    <div class="layui-form">
                        <input type="text" name="id" value="${(vpn.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">ip</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="ip" value="${(vpn.ip)!}" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">国家</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="country" value="${(vpn.country)!}" class="layui-input"/>
                                </div>
                            </div>

                        </div>
                        <@save url="/vpn/updateSave" />
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