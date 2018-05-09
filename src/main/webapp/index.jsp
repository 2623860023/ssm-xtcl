<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/27
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <!-- 这是jquery的核心包  -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- 这是easyui的核心包  -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
    <!--  分页中文转换-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <!-- jqeuy默认的css样式 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">
</head>
<body  class="easyui-layout">

<div data-options="region:'north',title:'',split:true" style="height:150px;" >
</div>
<div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">
    <div id="aa" data-options="fit:true" class="easyui-accordion" style="width:300px;height:200px;">
        <div title="权限管理" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
            <div id="tt" class="easyui-tree">
            </div>
        </div>
        <div title="系统配置" data-options="iconCls:'icon-reload'" style="padding:10px;">
        </div>
        <div title="测试模块">
        </div>
    </div>
</div>
<div  data-options="region:'center',title:''">
    <div id="tabs" class="easyui-tabs" data-options="fit:true">
        <div title="首页" style="padding:20px;">

        </div>
    </div>
</div>
<script>
    $("#tt").tree({
        url:"<%=request.getContextPath()%>/treeController/selectTreeList.do",
        method:"post",
        //checkbox:true,
        parentField:'pid',//和实体类一致
        onSelect:function(node){
            if(node.url !=null || node.url !=""){
                // add a new tab panel
                var flag=$("#tabs").tabs('exists',node.text);
                if(flag){
                    $("#tabs").tabs('select',node.text);
                }else{
                    $('#tabs').tabs('add',{
                        title:node.text,
                        href:"<%=request.getContextPath()%>/"+node.url,
                        closable:true,
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){

                            }
                        }]
                    })
                }
            }
        }
    })
</script>
</body>
</html>
