<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>代理人列表</title>
    <#include "./common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body layui-form">

                    <div class="layui-col-md12">
                        <form class="layui-form" id="dataForm" action="/banner/list" method="post">
                            <input type="text" id="pageCurr" name="current" value="${(banner.current)!}"  hidden/>
                            <input type="text" name="size" value="10"  hidden/>
                            <#--<div class="layui-form-item">
                                <label class="layui-form-label">名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${(name)!}" autocomplete="off" class="layui-input" />
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>-->
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">游戏/资讯</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="type"  value="1" title="游戏">
                                    <input type="radio" name="type"  value="2" title="咨询">
                                </div>
                                <input type="submit" class="layui-btn" value="搜索" />
                            </div>

                            <div class="layui-form-item">
                            <#--'0默认首页banner,1.加速插件,2福利,3.爆款,4.二次元对应着module表id,10001朋友圈, 10002充值,10003开服表,10004海外游戏,'-->
                                <label for="" class="layui-form-label">所属模块</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="moduleId"  value="0" title="首页">

                                    <#--<input type="radio" name="moduleId"  value="1" title="加速插件">
                                    <input type="radio" name="moduleId"  value="2" title="福利">
                                    <input type="radio" name="moduleId"  value="3" title="爆款">
                                    <input type="radio" name="moduleId"  value="4" title="二次元">-->

                                    <#if moduleList ??>
                                        <#list moduleList as m>
                                            <input type="radio" name="moduleId" value="${(m.id)!}" title="${(m.name)!}">
                                        </#list>
                                    </#if>

                                    <input type="radio" name="moduleId"  value="10001" title="朋友圈">
                                    <input type="radio" name="moduleId"  value="10002" title="充值">
                                    <input type="radio" name="moduleId"  value="10003" title="开服表">
                                    <input type="radio" name="moduleId"  value="10004" title="海外游戏">
                                </div>
                            </div>
                        </form>
                    </div>


                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>图片地址</th>
                            <th>关联的资讯/游戏id</th>
                            <th>所属模块</th>
                            <th>类型:资讯/游戏</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list banner.data as b>
                            <tr>
                                <td>${(b.id)!}</td>
                                <td><img src=${(b.imageUrl)!}></td>
                                <td>${(b.consultionId)!}</td>
                                <td>
                                    <#if b.moduleId==0>首页
                                    <#elseif b.moduleId==1>加速插件
                                    <#elseif b.moduleId==2>福利
                                    <#elseif b.moduleId==3>爆款
                                    <#elseif b.moduleId==4>二次元

                                    <#elseif b.moduleId==10001>朋友圈
                                    <#elseif b.moduleId==10002>充值
                                    <#elseif b.moduleId==10003>开服表
                                    <#elseif b.moduleId==10004>海外游戏
                                    <#else>
                                    </#if>
                                </td>
                                <td>
                                    <#if b.type==1>游戏
                                    <#elseif b.type==2>资讯
                                    <#elseif b.type==3>活动
                                    </#if>
                                </td>
                                <td>
                                    <a lay-href="/banner/update?id=${(b.id)!}" lay-id="${(b.id)!}" class="layui-btn layui-btn-sm">修改</a>
                                    <a href="javascript:;" onclick="doDel('/banner/del?id=${(b.id)!}','删除')" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>共${(banner.total)!}条
                    <@pager count="${(banner.total)!}" limit="${(banner.size)!}" curr="${(banner.current)!}" create="/banner/edit" />
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

</body>
</html>