<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />

<head>
    <meta charset="utf-8">
    <title>buffzs 后台管理系统</title>
    <#include "./common/common_header.ftl" />
    <script>
        // /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
    </script>
</head>

<body class="layui-layout-body">
<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
<#--                <li class="layui-nav-item layadmin-flexible" lay-unselect>-->
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="../../../../external.html?link=http://www.layui.com/admin/" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <#--<li class="layui-nav-item" lay-unselect>-->
                    <#--<a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">-->
                        <#--<i class="layui-icon layui-icon-notice"></i>-->

                        <#--<!-- 如果有新消息，则显示小圆点 &ndash;&gt;-->
                        <#--<span class="layui-badge-dot"></span>-->
                    <#--</a>-->
                <#--</li>-->
                <#--<li class="layui-nav-item layui-hide-xs" lay-unselect>-->
                    <#--<a href="javascript:;" layadmin-event="theme">-->
                        <#--<i class="layui-icon layui-icon-theme"></i>-->
                    <#--</a>-->
                <#--</li>-->
                <#--<li class="layui-nav-item layui-hide-xs" lay-unselect>-->
                    <#--<a href="javascript:;" layadmin-event="note">-->
                        <#--<i class="layui-icon layui-icon-note"></i>-->
                    <#--</a>-->
                <#--</li>-->
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>${username!}</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <#--<dd><a lay-href="set/user/info.html">基本资料</a></dd>-->
                        <#--<dd><a lay-href="set/user/password.html">修改密码</a></dd>-->
                        <#--<hr>-->
                        <dd  style="text-align: center;"><a href="/logout">退出</a></dd>
                    </dl>
                </li>
                <#--<li class="layui-nav-item layui-hide-xs" lay-unselect>-->
                    <#--<a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>-->
                <#--</li>-->
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>
        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="home/console.html">
                    <span>Buffzs_Admin</span>
                </div>
                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">

                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console" class="layui-this">
                                <a lay-href="/main">主页</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="agent" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="导航管理" lay-direction="2">
                            <i class="layui-icon layui-icon-user"></i>
                            <cite>导航管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/module/list?type=2&current=1&size=10">导航列表</a>
                            </dd>
                        </dl>
                        <#--<dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/navigation/list?type=2&current=1&size=10">中部导航列表</a>
                            </dd>
                        </dl>-->
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="游戏中心" lay-direction="2">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>游戏中心</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/game/list?current=1&size=10">游戏</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/gameServer/list?current=1&size=10">游戏区服管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/gameGenres/list?current=1&size=10">游戏类型管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/banner/list?current=1&size=10">横幅管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/label/list?current=1&size=10">游戏标签</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/hotIcon/list?current=1&size=10">游戏火热图标</a>
                            </dd>
                        </dl>
                        <#--<dl class="layui-nav-child">-->
                            <#--<dd data-name="list">-->
                                <#--<a lay-href="/plugin/list?current=1&size=10">游戏插件</a>-->
                            <#--</dd>-->
                        <#--</dl>-->
                    </li>

                    <li data-name="customer" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="内容管理" lay-direction="2">
                            <i class="layui-icon layui-icon-username"></i>
                            <cite>内容管理</cite>
                        </a>
                        <#--<dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/channel/list?current=1&size=10">渠道管理</a>
                            </dd>
                        </dl>-->
                    <#--<dl class="layui-nav-child">
                        <dd data-name="list">
                            <a lay-href="/customer/list?current=1&size=10">推荐管理</a>
                        </dd>
                    </dl>-->
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/consultion/list?current=1&size=10">资讯</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/tools/list?current=1&size=10">工具箱</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="礼包管理" lay-direction="2">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>礼包中心</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/gameGift/list?current=1&size=10">礼包管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/gameGiftCode/list?current=1&size=10">礼包码</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="用户管理" lay-direction="4">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>用户管理</cite>
                        </a>

                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/friendCircle/list?current=1&size=10">朋友圈</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/feedbackType/list?current=1&size=10">反馈类型</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/feedback/list?current=1&size=10">意见反馈</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/comment/list?current=1&size=10">评论管理</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="运营管理" lay-direction="4">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>运营管理</cite>
                        </a>

                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/channel/list?current=1&size=10">渠道管理</a>
                            </dd>
                        </dl>

                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/subchannel/list?current=1&size=10">子渠道管理</a>
                            </dd>
                        </dl>

                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/htmlTemplate/list?current=1&size=10">模板管理</a>
                            </dd>
                        </dl>

                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/promotionPage/list?current=1&size=10">推广页管理</a>
                            </dd>
                        </dl>

                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <#--<a lay-href="/apk/list?current=1&size=10">打包</a>-->
                                <a lay-href="/apk/edit">打包</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="用户统计" lay-direction="2">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>用户统计</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/user/list?current=1&size=10">用户列表</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/redirect/view?viewName=userLoginStatistics_list">用户统计</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/userLoginStatistics/keyword?current=1&size=10">关键字统计</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/userLoginStatistics/gameStatistics">游戏统计</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="充值中心" lay-direction="2">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>充值中心</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/vouchers/list?current=1&size=10">代金券管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/rechargeProportion/list?current=1&size=10">充值比例管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/userVouchers/list?current=1&size=10">用户领取代金券</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="order" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="系统设置" lay-direction="2">
                            <i class="layui-icon layui-icon-menu-fill"></i>
                            <cite>系统设置</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/version/list?current=1&size=10">版本管理</a>
                            </dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd data-name="list">
                                <a lay-href="/vpn/list?current=1&size=10">vpn管理</a>
                            </dd>
                        </dl>
                    </li>

                </ul>
            </div>
        </div>
        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>
        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="/main" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>
        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>
<script src="/static/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');

    function refresh() {
        $("a[layadmin-event=\"refresh\"]").trigger("click");
    }

    function closeTab(tabId) {
        var tabEle = $("#LAY_app_tabsheader li[lay-id='"+tabId+"']");
        tabEle.find(".layui-tab-close").trigger("click");
        refresh();
    }

    function msg(msg) {
        layer.msg(msg);
    }
</script>
</body>

</html>