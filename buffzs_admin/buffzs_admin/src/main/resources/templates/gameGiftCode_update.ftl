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
                <div class="layui-card-header">修改</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(gameGiftCode.id)!}" hidden/>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="uniqueId" value="${(gameGiftCode.uniqueId)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameId" value="${(gameGiftCode.gameId)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">领取渠道id</label>
                            <div class="layui-input-inline">
                                <input type="text" name="channelId" value="${(gameGiftCode.channelId)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftCode" value="${(gameGiftCode.giftCode)!}" class="layui-input"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">领取状态</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="status"  value="1" title="已领取" ${(gameGiftCode.status=='1')?string("checked","")}>
                                <input type="radio" name="status"  value="0" title="未领取" ${(gameGiftCode.status=='0')?string("checked","")}>
                            </div>
                        </div>
                        <@save url="/gameGiftCode/updateSave" />
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