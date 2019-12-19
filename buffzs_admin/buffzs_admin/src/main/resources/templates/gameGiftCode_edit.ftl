<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">新增版本</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="uniqueId" value="${(uniqueId)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameId" value="${(gameId)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">领取渠道id</label>
                            <div class="layui-input-inline">
                                <input type="text" name="channelId" value="${(channelId)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftCode" value="${(giftCode)!}" class="layui-input"/>
                            </div>
                        </div>

                        <@save url="/gameGiftCode/dosave" />
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
                elem: '#test1' //指定元素
                ,type: 'datetime'
            });
        });
    </script>
</div>
</body>
</html>