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
                <div class="layui-card-header">修改资讯</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(consultion.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">标题</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="title"  value="${(consultion.title)!}"
                                           lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">资讯类型</label>
                                <div class="layui-input-inline" style="width: auto">
                                    <input type="radio" name="type" id="type" value="1" title="咨讯" ${(consultion.type=='1')?string("checked","")}>
                                    <input type="radio" name="type" id="type" value="2" title="攻略" ${(consultion.type=='2')?string("checked","")}>
                                    <input type="radio" name="type" id="type" value="3" title="原创" ${(consultion.type=='3')?string("checked","")}>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">游戏名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" value="${(consultion.gameName)!}"  id="gameName" class="layui-input"/>
                                    <input type="submit" class="layui-btn" value="搜索" id="btn"/>
                                </div>

                                <div class="layui-input-inline">
                                    <select id="gameId" lay-filter="gameId" lay-verify="" lay-search="" name="gameId">
                                        <option value="${(consultion.gameId)!}">${(consultion.gameName)!}</option>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">tag</label>
                                <div class="layui-input-inline" style="width: auto">
                                    <input type="radio" name="tag" id="tag" value="1" title="公告" ${(consultion.tag==1)?string("checked","")}>
                                    <input type="radio" name="tag" id="tag" value="2" title="新闻" ${(consultion.tag==2)?string("checked","")}>
                                    <input type="radio" name="tag" id="tag" value="3" title="新手" ${(consultion.tag==3)?string("checked","")}>
                                    <input type="radio" name="tag" id="tag" value="4" title="高阶" ${(consultion.tag==4)?string("checked","")}>
                                    <input type="radio" name="tag" id="tag" value="5" title="评测" ${(consultion.tag==5)?string("checked","")}>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">资讯内容</label>
                                <div class="layui-form-text" style="width:1000px;padding:5px;">
                                <textarea placeholder="请输入内容" class="layui-textarea" id="content" style="display: none" name="content" lay-verify="content" >
                                    <#if consultion.content ??>${(consultion.content)}</#if>
                                </textarea>
                                </div>
                            </div>

                        </div>
                        <@save url="/consultion/updateSave" />
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

        layui.use(['form','layer','jquery'],function(){
            var form = layui.form,
                    layer = parent.layer === undefined ? layui.layer : parent.layer,
                    $ = layui.jquery;
            $(document).on('click', '#btn', function () {
                var name = document.getElementById("gameName").value;
                $("#gameId").empty();
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
<#--富文本-->
    <script>


        layui.use(['form', 'layedit', 'laydate', 'jquery'], function(){
            var form = layui.form,
                    layer = layui.layer,
                    layedit = layui.layedit,
                    $ = layui.jquery,
                    laydate = layui.laydate;

            layedit.set({
                uploadImage: {
                    url: '/upload/richText?status=consultion'
                    ,type: 'post' //默认post
                }
            });

            var index  = layedit.build('content',{
                tool: ['strong', 'italic', 'del', '|', 'left', 'center', 'right', 'link', 'unlink', 'face'
                    ,'image'
                ]//设置需要的控件
                ,height: 400   // 设置高度
            }); //建立编辑器

            form.verify({
                content:function () {
                    layedit.sync(index)
                }
            });

            //  layedit.getContent(index);

        })
    </script>
</div>
</body>
</html>