<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>子渠道修改</title>
    <#include "../common/common_header.ftl" />
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改渠道</div>
                <div class="layui-card-body">

                    <div class="layui-form">
                        <input type="text" name="id" value="${(subchannel.id)!}" hidden/>

                    <#--    <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">主渠道id</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="channelId" value="${(subchannel.channelId)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>-->
                        <div class="layui-form-item">
                            <label class="layui-form-label">主渠道</label>
                            <div class="layui-input-inline">
                                <select name="channelId" class="layui-input">
                                    <option value=""></option>
                                        <#if subchannel.channelId ??>
                                            <#list channelList as a>
                                             <option value="${(a.id)!}" ${(a.id==subchannel.channelId)?string("selected","")}>${(a.name)!}
                                             </option>
                                            </#list>
                                        <#else>
                                            <#list channelList as a>
                                                <option value="${(a.id)!}">${(a.name)!}</option>
                                            </#list>
                                        </#if>
                                </select>
                            </div>
                        </div>





                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">子渠道名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${(subchannel.name)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">子渠道链接</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="downloadUrl" value="${(subchannel.downloadUrl)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">结算方式</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="stype" value="${(subchannel.stype)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">扣量比例</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="discount" value="${(subchannel.discount)!}" class="layui-input"/>
                                </div>
                            </div>
                        </div>

                        <@save url="/subchannel/updateSave" />
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