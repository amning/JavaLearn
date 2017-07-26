<%@ page import="com.page.PageParam" %><%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/7/24
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--[if lt IE 9]>
<html class="ie ie8" lang="zh-CN">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="zh-CN">
<!--<![endif]--><head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width">
  <title>全网代理IP-高匿HTTP代理IP服务器供应商</title>
  <meta name="keywords" content="代理IP,ip代理,免费代理IP,代理ip软件,ip代理软件,国外代理ip,可用代理IP,最新代理IP,全网代理,HTTP代理IP,动态代理ip,VPN" />
  <meta name="description" content="全网代理IP专业提供高匿HTTP代理、HTTPS代理、私密代理、独享代理、VPN、拨号VPS服务器，IP时时更新，提供API接口和自动换IP代理软件。" />
  <link rel="icon" href="http://www.goubanjia.com/theme/goubanjia/favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="http://www.goubanjia.com/theme/goubanjia/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="http://www.goubanjia.com/theme/goubanjia/css/index.min.css?v=1.2"><link rel="stylesheet" type="text/css" href="http://www.goubanjia.com/theme/goubanjia/css/dialog.min.css">
</head>
<body>

<div style="background: #0074a2; height: 35px; line-height: 35px; width: 100%; font-size: 12px; font-weight: 900;">
<%--  <div class="wrap">
    <div style="float: left;">
      <a style="color: #fff;text-decoration: none;padding: 0 6px;" title="全网代理IP" href="#">全网代理IP</a>
      <a style="color: #fff;text-decoration: none;padding: 0 6px;" target="_blank" title="拨号VPS服务器" href="http://www.goubanjia.com/buy/vps.shtml">拨号服务器（拨号VPS）</a>
    </div>--%>
 <jsp:include page="head.jsp"></jsp:include>
</div>

<!-- start website header -->
<div id="page-header" class="wrap header" style="margin-top: 0px;">
  <header id="masthead" class="site-header" role="banner">
    <!-- start hgroup header -->
    <div class="hgroup">
      <h1 class="site-title">
        <a class="home-link" href="http://www.goubanjia.com/" title="全网代理IP" rel="home">全网代理IP</a>
      </h1>
      <h2 class="site-description" id="site-description">最便宜、最稳定、实时更新、API接口、IP代理软件</h2>
    </div>
    <!-- start social header -->
  <%--  <div class="site-social" style="width: auto;">
      今日本站已扫描代理总数: <strong>259340</strong><span class="message">（1分钟前更新）</span><br>
      30分钟内检测可用代理数: <strong style="cursor: pointer;" onclick="window.open('http://www.goubanjia.com/info/index.shtml','_blank')">6348</strong><span class="message">（1分钟前更新）</span>
    </div>--%>
    <!-- start image header -->
    <div class="clear"></div>
  </header>
</div>
<!-- end website header -->
<!-- start website menu -->
<div id="primary-nav">
  <div class="wrap nav">
    <div id="site-navigation" class="main-navigation" role="navigation">
      <h3 class="menu-toggle">Menu</h3>
      <a class="assistive-text" href="#content" title="Skip to content">Skip to content</a>
      <ul class="nav-menu">
        <li id="menu_index" class="menu-item menu-item-type-custom menu-item-object-custom ">
          <a href="/index" title="返回网站首页">首页</a>
        </li>
     <%--   <li id="menu_free" class="menu-item menu-item-type-post_type menu-item-object-custom ">
          <a href="http://www.goubanjia.com/free/index.shtml" title="免费代理IP,15分钟更新一次">免费代理</a>
        </li>
        <li id="menu_buyNormal" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
          <a href="http://www.goubanjia.com/buy/index.shtml" style="color:#3AFF76;" title="购买普通代理IP基础版">购买基础版</a>
        </li>
        <li id="menu_buyHigh" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
          <a href="http://www.goubanjia.com/buy/high.shtml" style="color:#3AFF76;" title="购买普通代理IP高级版">购买高级版</a>
        </li>
        <li id="menu_buy" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
          <a href="http://www.goubanjia.com/buy/dynamic.shtml" style="color:#3AFF76;" title="购买短效动态代理IP（私密代理IP）">购买动态IP</a>
        </li>
        <li id="menu_buyVps" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
          <a href="http://www.goubanjia.com/buy/vps.shtml" style="color:#3AFF76;" title="购买ADSL拨号VPS服务器">购买拨号VPS</a>
        </li>--%>
        <li id="menu_fetch" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
           <a href="http://www.goubanjia.com/fetch/index.shtml" title="提取IP到文本文件">提取IP</a>
         </li><%--
         <li id="menu_api" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
           <a href="http://www.goubanjia.com/api/create.shtml" title="创建API接口，访问接口可直接提取IP">API接口</a>
         </li>
         <li id="menu_download" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
           <a href="http://www.goubanjia.com/download/index.shtml" title="代理IP软件下载，支持验证、自动换IP">软件下载</a>
         </li>
         <li id="menu_user" class="menu-item menu-item-type-post_type menu-item-object-custom">
           <a href="http://www.goubanjia.com/user/index.shtml" style="color: #F3FF3A;">用户中心</a>
         </li>
         <li id="menu_qq" style="margin-right: 10px;" class="menu-item menu-item-type-taxonomy menu-item-object-custom right"><i class="qq-icon" style="cursor: pointer;" onclick="window.open('http://jq.qq.com/?_wv=1027&k=VFVEFs','_blank')"></i>QQ群：66782959 </li>--%>
      </ul>
    </div>
  </div>
</div>
<!-- end website menu -->

<script type="text/javascript">
    document.getElementById('menu_index').setAttribute("class", "menu-item menu-item-type-custom menu-item-object-custom current-menu-item");
    document.getElementById('menu_index').setAttribute("href", "#");
</script><!-- start content -->
<div class="wrap fullwidth">
  <div id="content" style="width: auto;">
    <div id="post-2" class="post-2 page type-page status-publish hentry">
      <div class="entry entry-content">
        <blockquote style="font-style:normal;">
          <p style='font-size: 14px;'><b>你们的代理IP是怎么获取到的？</b></p>
          <p>① 全网代理IP使用5台4核ECS服务器，运行分布式IP与端口扫描系统，每天扫描IP量几十万条，今日已经扫描 <strong style="color:red;">259340</strong> 条。</p>
          <p>② 我们不间断的运行着IP验证系统，精确地检测每一个代理IP的匿名度、响应时间、数据传输速度、地域、运营商，每秒钟都在验证，保证网站的IP都是高度可用的。</p>
          <p>③ 我们提供了极其丰富的代理筛选和API接口，每次提取的IP不相同，只为更便捷地提取、更便捷的开发。</p>
          <p>④ 我们提供了Java数据爬虫的jar包，省去您写代码的时间，点击下载Jar包（<a style="color: #FF0000;" href="http://www.goubanjia.com/download/proxyc-1.8.3.jar" target="_blank">JDK1.7版</a>），查看帮助文档请 <a href="http://www.goubanjia.com/article/7.shtml" target="_blank">点击查看帮助</a>。</p>
        </blockquote>
      </div>

      <div class="clear"></div>

      <div class="entry entry-content">
        <h4 class="entry-title">最新 20 个可用免费高速HTTP代理IP（2017-07-24 15:43:09 更新）</h4>
        <!-- start list -->
        <div id="list">
          <table class="table">
            <thead>
            <tr>
              <th>IP:PORT</th>
              <th>IP归属地</th>
              <th>运营商</th>
              <th>验证时间</th>
            </tr>
            </thead>
          <tbody>
          <%--  <c:forEach items="&{pageParam}" var="item">
              <tr>
                <td>${item.ip} : ${item.port}</td>
                <td>${item.country} ${item.province} ${item.city}</td>
                <td>${item.isp}</td>
                <td>${item.findTime}</td>
              </tr>
            </c:forEach>--%>
          </tbody>
          </table>
          <p class="message">注意：表中响应速度是中国测速服务器的测试数据，仅供参考。响应速度根据你机器所在的地理位置不同而有差异。</p>

          <div class="wp-pagenavi">
            <span>第</span>
        <%--    <%
              PageParam pageParam = (PageParam) request.getAttribute("pageParam");
              int currPage = pageParam.getCurrPage();
              int totage = pageParam.getTotalPage();
              for (int i = 1;i<=totage;i++){
                  if(i==currPage){
            %><span class="current"><%=currPage%></span><%
                  }else {
              %><a href="/index><%=i %>.jsp"/><%

                  }
              }
            %>--%>
            <span>页</span>
          </div>
        </div>

        <!-- end list -->

        <div class="center">
		<span class="smallbutton">
			<a target="_blank" href="http://www.goubanjia.com/buy/">购买更多稳定代理</a>
		</span>
          <span class="smallbutton">
			<a target="_blank" href="http://www.goubanjia.com/info/">IP实时分布统计</a>
		</span>
        </div></div>

    </div>
  </div>

  <div class="clear"></div>

  <div id="footer">
    <div class="copyright">
		<span class="footerleft">友情链接：
		</span>
      <div class="clear"></div>
    </div>
    <div class="copyright" style="display: none;">
      <span class="footerleft">Copyright &copy; 2016</span>
      <span class="footerright">All rights reserved</span>
      <div class="clear"></div>
    </div>
  </div>
</div>
<!-- end content -->

<script type="text/javascript">
    <!--
    eval(function(p,a,c,k,e,d){e=function(c){return c.toString(36)};if(!''.replace(/^/,String)){while(c--){d[c.toString(a)]=k[c]||c.toString(a)}k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1};while(c--){if(k[c]){p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c])}}return p}('s p(6,5){6=6||0.1;5=5||t;2 c=0;2 f=0;2 d=0;2 9=0;2 b=0;2 a=0;k(3.h){c=3.h.n||0;f=3.h.m||0}k(3.e){d=3.e.n||0;9=3.e.m||0}2 b=8.v||0;2 a=8.u||0;2 i=4.7(c,4.7(d,b));2 j=4.7(f,4.7(9,a));2 g=1+6;8.q(4.o(i/g),4.o(j/g));k(i>0||j>0){2 l="p("+6+", "+5+")";8.r(l,5)}}',32,32,'||var|document|Math|stime|acceleration|max|window|y2|y3|x3|x1|x2|body|y1|speeding|documentElement|x|y|if|run|scrollTop|scrollLeft|floor|gotoTop|scrollTo|setTimeout|function|10|scrollY|scrollX'.split('|'),0,{}))
    //-->
</script>

<a href="http://www.goubanjia.com/article/index.shtml" class="knowledge" title="代理知识库"></a>
<a href="#" onclick="gotoTop();return false;" class="totop" title="点我飞回顶部"></a>

<!-- start credits -->
<div class="credits">
  <br><br>
  <p>声明：本站资源仅限用来计算机技术学习及大数据抓取、爬虫等合法行为，利用本站资源从事任何违反中国法律法规的行为，由此引起的一切后果与本站无关。</p>
  <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253707717'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/stat.php%3Fid%3D1253707717%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
  <br><br>
  <script type="text/javascript">var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F2e4ebee39b2c69a3920a396b87bbb8cc' type='text/javascript'%3E%3C/script%3E"));</script>
  <script>
      (function(){
          var bp = document.createElement('script');
          var curProtocol = window.location.protocol.split(':')[0];
          if (curProtocol === 'https') {
              bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
          }
          else {
              bp.src = 'http://push.zhanzhang.baidu.com/push.js';
          }
          var s = document.getElementsByTagName("script")[0];
          s.parentNode.insertBefore(bp, s);
      })();
  </script>
</div>
<!-- end credits -->

<script type="text/javascript">
    <!--
    function getIEVer() {
        var ua = navigator.userAgent;
        var b = ua.indexOf("MSIE ");
        if (b < 0) {
            return 0;
        }
        return parseFloat(ua.substring(b + 5, ua.indexOf(";", b)));
    }
    var ua = navigator.userAgent.toLowerCase();
    var info = {
        ie: /msie/.test(ua) && !/opera/.test(ua),
        op: /opera/.test(ua),
        sa: /version.*safari/.test(ua),
        ch: /chrome/.test(ua),
        ff: /gecko/.test(ua) && !/webkit/.test(ua)
    };
    if(info.ie && getIEVer()<9){
        $('.home-link').css({'font-size': '28px'});
        $('.site-description').css({'color': '#aaa'});
        $('#page-header').css({'margin-bottom': '8px'});

        $('#user_email').val('邮箱地址').css('color', '#aaa').css('line-height', '50px').bind('click', function(){
            var val = $(this).val();
            if('邮箱地址' == val){
                $(this).val('').css('color', '#666');
                $('#passwd-p').html('<input value="" style="color: #666; line-height: 50px;" autocomplete="on" id="user_password" name="password" placeholder="请输入密码" rel="tooltip-focus" required="required" size="30" title="密码长度不得小于六位。" type="password">');
            }else{}
        });
        var input = $('<input value="密码" style="color: #aaa; line-height: 50px;" autocomplete="on" id="user_password" name="password" placeholder="请输入密码" rel="tooltip-focus" required="required" size="30" title="密码长度不得小于六位。" type="text">');
        $('#passwd-p').empty().append(input);

    }
    if(info.ie && getIEVer()<8){

        $('.menu-item').css({'float': 'left'});
        $('.ie7mt').css({'height':'25px'});
        $('.assistive-text').remove();
        $('#menu_qq').css('float', 'right');
        $('.home-link').css({'font-size': '28px'});
        $('.site-description').css({'color': '#aaa'});
        $('#page-header').css({'margin-bottom': '40px', 'position':'relative', 'top':'40px'});
        $('#primary-nav').css({'position':'relative', 'clear':'both'});
        $('.ip *').css({'float': 'left'});
        $('#user_email').val('邮箱地址').css('color', '#aaa').css('line-height', '50px').bind('click', function(){
            var val = $(this).val();
            if('邮箱地址' == val){
                $(this).val('').css('color', '#666');
                $('#passwd-p').html('<input value="" style="color: #666; line-height: 50px;" autocomplete="on" id="user_password" name="password" placeholder="请输入密码" rel="tooltip-focus" required="required" size="30" title="密码长度不得小于六位。" type="password">');
            }else{}
        });
        var input = $('<input value="密码" style="color: #aaa; line-height: 50px;" autocomplete="on" id="user_password" name="password" placeholder="请输入密码" rel="tooltip-focus" required="required" size="30" title="密码长度不得小于六位。" type="text">');
        $('#passwd-p').empty().append(input);

    }
    //-->
</script><script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="http://www.goubanjia.com/theme/goubanjia/javascript/dialog.min.js"></script>
<script type="text/javascript" src="http://www.goubanjia.com/theme/goubanjia/javascript/common.js?v=1.0"></script>
<script type="text/javascript" src="http://www.goubanjia.com/theme/goubanjia/javascript/pde.js?v=1.0"></script>
<script type="text/javascript">X.D='http://www.goubanjia.com/';</script>
</body>
</html>