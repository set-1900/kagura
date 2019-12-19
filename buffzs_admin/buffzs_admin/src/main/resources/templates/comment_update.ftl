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
                <div class="layui-card-header">修改评论</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(comment.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">评论的用户id</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="fromUid"  value="${(comment.fromUid)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">目标的用户id</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="toUid"  value="${(comment.toUid)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">点赞数</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="laud"  value="${(comment.laud)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">评论类型</label>
                                <div class="layui-input-inline" style="width: 800px">
                                    <input type="radio" name="topicType" id="topicType" value="1" title="1游戏"   ${(comment.topicType==1)?string("checked","")}>
                                    <input type="radio" name="topicType" id="topicType" value="2" title="2文章"   ${(comment.topicType==2)?string("checked","")}>
                                    <input type="radio" name="topicType" id="topicType" value="3" title="3提问"   ${(comment.topicType==3)?string("checked","")}>
                                    <input type="radio" name="topicType" id="topicType" value="4" title="4资讯"   ${(comment.topicType==4)?string("checked","")}>
                                    <input type="radio" name="topicType" id="topicType" value="5" title="5朋友圈" ${(comment.topicType==5)?string("checked","")}>
                                    <input type="radio" name="topicType" id="topicType" value="6" title="6回复"   ${(comment.topicType==6)?string("checked","")}>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">内容</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="content"  value="${(comment.content)!}"
                                           lay-verify="required" class="layui-input" style="width: 800px" />
                                </div>
                            </div>


                        </div>
                        <@save url="/comment/updateSave" />
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