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
                        <input type="text" name="id" value="${(gameGift.id)!}" hidden/>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="uniqueId" value="${(gameGift.uniqueId)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏归属用户ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameUserid" value="${(gameGift.gameUserid)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameId" value="${(gameGift.gameId)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏名字</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameName" value="${(gameGift.gameName)!}" class="layui-input"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftName" value="${(gameGift.giftName)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包价值</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftWorth" value="${(gameGift.giftWorth)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftContent" value="${(gameGift.giftContent)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">使用说明</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftUseDesc" value="${(gameGift.giftUseDesc)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">有效期限</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftExpiration" value="${(gameGift.giftExpiration)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">过期时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="expirationTime" value="${(gameGift.expirationTime?string('yyyy-MM-dd HH:mm:ss'))!}" class="layui-input" id="test1"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包码数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftNum" value="${(gameGift.giftNum)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包码数剩余数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftSurplus" value="${(gameGift.giftSurplus)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包状态</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="giftStatus"  value="1" title="1上架" ${(gameGift.giftStatus=='1')?string("checked","")}>
                                <input type="radio" name="giftStatus"  value="0" title="0下架" ${(gameGift.giftStatus=='0')?string("checked","")}>
                            </div>
                        </div>
                        <@save url="/gameGift/updateSave" />
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