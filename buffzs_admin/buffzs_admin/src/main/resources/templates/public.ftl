<#macro pager count="" limit="2" curr="1" create="">
    <div>
        <div class="layui-inline">
            <#if create?? && create!="" && role?? && role=="admin">
                <a lay-href="${create!}" class="layui-btn layui-btn-sm">新增</a>
            </#if>
            <a href="javascript:;" class="layui-btn refresh layui-btn-sm">刷新</a>
        </div>
        <div id="table_page" class="layui-inline"></div>
    </div>

    <script>
        layui.config({
            base: '/static/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use('index');

        layui.use(["laypage", "form"], function () {
            var laypage = layui.laypage;
            var form = layui.form;
            form.render();
            laypage.render({
                elem: "table_page",
                count: ${count!},
                curr: ${curr!},
                limit: ${limit!},
                jump: function (data, first) {
                    if (!first) {
                        $("#pageCurr").val(data.curr);
                        $("#dataForm").trigger("submit");
                    }
                }

            })
        })
        $(".refresh").click(function () {
            parent.refresh();
        })
    </script>
</#macro>

<#macro save url="">
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="save">保存</button>
    </div>
    <script>
        layui.use(["form","layer"], function () {
            var form = layui.form;
            var layer = layui.layer;
            form.render();
            form.on("submit(save)", function (data) {
                $.post("${url!}", data.field, function (data) {
                    layer.msg(data.message);
                    setTimeout(function () {
                        afterSubmit();
                    },1000)
                })
            })
        });
    </script>
</#macro>

<script>
    function doDel(url, msg) {
        layer.confirm("确认"+msg+"吗？", {btn:['确定', '取消']}, function (index) {
            layer.close(index);
            $.get(url, function(data){
                layer.msg(data.message);
                setTimeout(function () {
                    parent.refresh();
                }, 1000)
            })
        })
    }
</script>