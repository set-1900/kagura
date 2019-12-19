<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>版本列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/gameGift/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(gameGift.current)!}" hidden/>
                            <input type="text" name="size" value="10" hidden/>
                        <#--<div class="layui-form-item">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="${(name)!}" autocomplete="off" class="layui-input" />
                            </div>
                            <input type="submit" class="layui-btn" value="搜索" />
                        </div>-->
                        </form>
                    </div>

                    <table class="layui-table">
                        <colgroup>
                            <col width="50">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>自增id</th>
                            <th>礼包ID</th>
                            <th>游戏归属用户ID</th>
                            <th>游戏ID</th>
                            <th>游戏名字</th>
                            <th>礼包名称</th>
                            <th>礼包价值</th>
                            <th>礼包内容</th>
                            <th>使用说明</th>
                            <th>有效期限</th>
                            <th>过期时间</th>
                            <th>礼包码数量</th>
                            <th>礼包码数剩余数量</th>
                            <th>礼包状态</th>
                            <th>礼包添加时间</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list gameGift.data as d>
                        <tr>
                            <td>${(d.id)!}</td>
                            <td>${(d.uniqueId)!}</td>
                            <td>${(d.gameUserid)!}</td>
                            <td>${(d.gameId)!}</td>
                            <td>${(d.gameName)!}</td>
                            <td>${(d.giftName)!}</td>
                            <td>${(d.giftWorth)!}</td>
                            <td>${(d.giftContent)!}</td>
                            <td>${(d.giftUseDesc)!}</td>
                            <td>${(d.giftExpiration)!}</td>
                            <td>${(d.expirationTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                            <td>${(d.giftNum)!}</td>
                            <td>${(d.giftSurplus)!}</td>
                            <td>
                                <#if d.giftStatus == '0'>
                                    <span>0下架</span>
                                </#if>
                                <#if d.giftStatus == '1'>
                                    <span>1上架</span>
                                </#if>
                            </td>
                            <td>${(d.addTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                            <td><a class="layui-btn layui-btn-sm" lay-href="/gameGift/update?id=${(d.id)!}"
                                   lay-id="${(d.id)!}">修改</a>
                                <a href="javascript:;" onclick="doDel('/gameGift/del?id=${(d.id)!}','删除')"
                                   class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    <@pager count="${(gameGift.total)!}" limit="${(gameGift.size)!}" curr="${(gameGift.current)!}" create="/gameGift/edit" />
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

    function addRow() {
        var t = document.getElementById("t1");
        var row = t.insertRow(t.rows.length);
        var cell1 = row.insertCell(0);
        cell1.innerHTML = document.getElementById("t2").value;
        var cell2 = row.insertCell(1);
        cell2.innerHTML = document.getElementById("t3").value;
    }
</script>

</body>
</html>