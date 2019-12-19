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
                <div class="layui-card-header">新增评论</div>
                <div class="layui-card-body">
                    <div class="layui-form">

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">评论的用户id</label>
                            <div class="layui-input-inline">
                                <input type="text" name="fromUid" value="${(fromUid)!}" class="layui-input"/>
                            </div>

                            <label for="" class="layui-form-label">目标的用户id</label>
                            <div class="layui-input-inline">
                                <input type="text" name="toUid" value="${(toUid)!}" class="layui-input"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">评论类型</label>
                            <div class="layui-input-inline" style="width: 800px">
                                <input type="radio" name="topicType" id="topicType" value="1" title="1游戏" checked>
                                <input type="radio" name="topicType" id="topicType" value="2" title="2文章">
                                <input type="radio" name="topicType" id="topicType" value="3" title="3提问">
                                <input type="radio" name="topicType" id="topicType" value="4" title="4资讯">
                                <input type="radio" name="topicType" id="topicType" value="5" title="5朋友圈">
                                <input type="radio" name="topicType" id="topicType" value="6" title="6回复">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">评论主题id</label>
                            <div class="layui-input-inline">
                                <input type="text" name="topicId" value="${(topicId)!}" class="layui-input"/>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <label for="" class="layui-form-label">内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="content" value="${(content)!}" class="layui-input" style="width: 800px"/>
                            </div>
                        </div>

                        <@save url="/comment/dosave" />
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