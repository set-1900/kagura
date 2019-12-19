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
                <div class="layui-card-header">修改版本</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <input type="text" name="id" value="${(version.id)!}" hidden/>
                        <div class="layui-form-item">
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">文件名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name"  value="${(version.name)!}" lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">版本代码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="code"  value="${(version.code)!}" lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">版本号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="version"  value="${(version.version)!}" lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">更新内容说明1</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="about1"  value="${(version.about1)!}" lay-verify="required" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">更新内容说明2</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="about2"  value="${(version.about2)!}" lay-verify="" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">更新内容说明3</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="about3"  value="${(version.about3)!}" lay-verify="" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">更新内容说明4</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="about4"  value="${(version.about4)!}" lay-verify="" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">更新内容说明5</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="about5"  value="${(version.about5)!}" lay-verify="" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">下载地址</label>
                                <button type="button" class="layui-btn" id="test1">
                                    <i class="layui-icon">&#xe67c;</i>上传apk文件
                                </button>
                                <div class="layui-input-inline">
                                    <div class="layui-upload-list">
                                        <p id="demoText"></p>
                                    </div>
                                </div>
                                <div class="layui-input-inline">
                                    <input id="downurl" type="text" name="downurl" value="${(version.downurl)!}" hidden/>
                                </div>
                            </div>

                            <script>
                                layui.use('upload', function () {
                                    var upload = layui.upload;

                                    //执行实例
                                    var uploadInst = upload.render({
                                        elem: '#test1' //绑定元素
                                        , url: '/upload/file' //上传接口
                                        , accept: 'file'
                                        , done: function (res) {
                                            //如果上传失败
                                            if (res.code > 0) {
                                                return layer.msg('上传失败');
                                            }
                                            //上传成功
                                            //打印后台传回的地址: 把地址放入一个隐藏的input中, 和表单一起提交到后台, 此处略..
                                            /*   console.log(res.data.src);*/
                                            /* window.parent.uploadHeadImage(res.data.src);*/
                                            var demoText = $('#demoText');
                                            demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                                            var image = res.data;
                                            document.getElementById("downurl").setAttribute("value", image)
                                        }
                                        , error: function () {
                                            //演示失败状态，并实现重传
                                            var demoText = $('#demoText');
                                            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                                            demoText.find('.demo-reload').on('click', function () {
                                                uploadInst.upload();
                                            });
                                        }
                                    });
                                });
                            </script>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">是否跟新</label>
                                <div class="layui-input-inline" style="width: auto">
                                    <input type="radio" name="updateIfForce"  value="1" title="1强制更新,app启动时检查" ${(version.updateIfForce==1)?string("checked","")}>
                                    <input type="radio" name="updateIfForce"  value="0" title="0不需要强更,前端提示更新" ${(version.updateIfForce==0)?string("checked","")}>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">apk类型</label>
                                <div class="layui-input-inline" style="width: auto">
                                    <input type="radio" name="apkType"  value="1" title="buffzs" ${(version.apkType==1)?string("checked","")}>
                                    <input type="radio" name="apkType"  value="2" title="google plugin" ${(version.apkType==2)?string("checked","")}>
                                    <input type="radio" name="apkType"  value="3" title="game plugin" ${(version.apkType==3)?string("checked","")}>
                                </div>
                            </div>
                        </div>
                        <@save url="/version/updateSave" />
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