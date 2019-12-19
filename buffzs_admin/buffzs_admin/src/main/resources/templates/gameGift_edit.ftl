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

                        <#--<div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="uniqueId" value="${(uniqueId)!}" class="layui-input"/>
                            </div>
                        </div>-->

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏归属用户ID</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameUserid" value="${(gameUserid)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">游戏名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="" value="${(gameId)!}" class="layui-input" id="aaa" />
                                <input type="submit" class="layui-btn" value="搜索" id="btn"/>
                            </div>

                            <div class="layui-input-inline">
                                <select id="gameId" lay-filter="gameId" lay-verify="" lay-search="" name="gameId"></select>
                            </div>
                        </div>
                        <script>
                            layui.use(['form','layer','jquery'],function(){
                                var form = layui.form,
                                        layer = parent.layer === undefined ? layui.layer : parent.layer,
                                        $ = layui.jquery;
                                $(document).on('click', '#btn', function () {
                                    var name = document.getElementById("aaa").value;
                                    $html = "";
                                    $.post("/consultion/selectGame",{"name":name},function (data) {
                                        if(data.success)
                                            if(data.data != null) {
                                                $.each(data.data, function (index, item) {
                                                    $html += "<option value='" + item.id + "'>" + item.name + "</option>";
                                                });
                                                console.log("html==" + $html);
                                                $("#gameId").append($html);
                                                form.render('select');
                                            }
                                    });
                                });
                            });
                        </script>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftName" value="${(giftName)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包价值</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftWorth" value="${(giftWorth)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftContent" value="${(giftContent)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">使用说明</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftUseDesc" value="${(giftUseDesc)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">有效期限</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftExpiration" value="${(giftExpiration)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">过期时间</label>
                            <div class="layui-input-inline">
                                <input type="" name="expirationTime" value="${(expirationTime)!}" class="layui-input" id="test1"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包码数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftNum" value="${(giftNum)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包码数剩余数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="giftSurplus" value="${(giftSurplus)!}" class="layui-input"/>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">礼包状态</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="giftStatus" id="ifbanner" value="1" title="上架" checked>
                                <input type="radio" name="giftStatus" id="ifbanner" value="0" title="下架">
                            </div>
                        </div>

                        <@save url="/gameGift/dosave" />
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