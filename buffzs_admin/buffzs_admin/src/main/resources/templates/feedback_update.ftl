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
                        <input type="text" name="id" value="${(feedback.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">反馈类别名称</label>
                                <div class="layui-input-inline">
                                    <select name="feedbackType" class="layui-input">
                                        <option value="" ></option>
                                        <#list feedbackType as f>
                                            <option value="${(f.id)!}" ${((feedback.feedbackType)==(f.id))?string("selected","")}>${(f.name)!}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">反馈内容</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="content" value="${(feedback.content)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">邮箱或者qq</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="contact" value="${(feedback.contact)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                        </div>
                        <@save url="/feedback/updateSave" />
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