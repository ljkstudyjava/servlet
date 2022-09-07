<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/7
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<HEAD>
    <TITLE> ZTREE DEMO - url</TITLE>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="zTree_v3-master/css/demo.css" type="text/css">
    <link rel="stylesheet" href="zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="zTree_v3-master/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="zTree_v3-master/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="zTree_v3-master/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="zTree_v3-master/js/jquery.ztree.exedit.js"></script>
    <SCRIPT type="text/javascript">
        <!--
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        var zNodes = ${menuList}

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
        //-->
    </SCRIPT>
</HEAD>

<BODY>

<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>
</BODY>
</html>
