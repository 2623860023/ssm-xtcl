<%@ page import="sun.misc.Request" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/5/7
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
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
<body>
                <div  class="easyui-linkbutton" onclick="addwindC()" data-options="iconCls:'icon-add',plain:true">新增</div>
                <table id="dguser"></table>
                <div id="dialog_add"></div>
</body>

<script>
    //header("Access-Control-Allow-Origin: *"); // 跨域处理
    $(function(){
        $('#dguser').datagrid({

            url: "http://localhost:8088/admin/selectUser",
            async: false,
            type : "GET",
            dataType : "jsonp", // 返回的数据类型，设置为JSONP方式
            jsonp : 'callback', //指定一个查询参数名称来覆盖默认的 jsonp 回调参数名 callback
            fitColumns:true,
            striped:true,
            ctrlSelect:true,
             method:"post",
            loadMsg:"数据库加载中。。。。。。。。。。。。。。。。。。",
            pagination:true,
            pagePosition:"bottom",
            pageNumber:1,
            pageSize:3,
            pageList:[1,3,5,7,10],

            columns:[[
                {field:'userid',title:'编号',width:80},
                {field:'phone',title:'手机号',width:60},
                {field:'loginname',title:'登录名',width:60},
                {field:'password',title:'密码',width:60},
                {field:'username',title:'真实姓名',width:60},
                {field:'biaoid',title:'性别',width:60,
                    formatter: function(value,row,index){
                        if(value==1){
                            var sex="男";
                        }else if(value==2){
                            var sex="女";
                        }
                        return sex;
                    }
                },
                {field:"button",title:'操作',width:100,
                    formatter: function(value,row,index){
                        return "<input type='button'  class='icon-edit' onclick='shanchu(\""+row.userid+"\")' value='删除'><input type='button'  class='icon-edit' onclick='xiugai(\""+row.userid+"\")' value='修改'>";
                    }
                }
            ]]
        });
    })

    function shanchu(userid){

        var msg = "您真的确定要删除吗？\n\n请确认！";
        if (confirm(msg)==true){

            $.ajax({
                url: "http://localhost:8088/admin/deleteUser",
                type:"post",
                data:{"id":userid},
               // dataType:"text",
                async:false,
                success:function(){
                    $("#dguser").datagrid("reload");
                },
                error:function(){
                    //alert("删除出错!");
                    $("#dguser").datagrid("reload");
                }
            })
            return true;
        }else{
            return false;
        }
    }


            function addwindC(){
                $("#dialog_add").dialog({
                    title: '新增用户',
                    width: 400,
                    height: 550,
                    closed: false,
                    cache: false,
                    href:"<%=request.getContextPath()%>/useradd.jsp",
                    modal: true ,

                    toolbar:[{
                        text:'保存',
                        iconCls:'icon-edit',
                        handler:function(){

                            $.ajax({
                                url:"http://localhost:8088/admin/addUser",
                                async: false,
                                type : "GET",
                                dataType : "jsonp", // 返回的数据类型，设置为JSONP方式
                                jsonp : 'callback', //指定一个查询参数名称来覆盖默认的 jsonp 回调参数名 callback
                               // type:"post",
                                data:$("#addUser").serialize(),
                                success:function(){
                                    $("#dialog_add").dialog("close");
                                    $("#dguser").datagrid("reload");
                                },error:function(){
                                    //$.messager.alert('警告','报错');
                                    $("#dguser").datagrid("reload");
                                }
                            })
                        }
                    },{
                        text:'取消',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $("#dialog_addshop").dialog("close");
                        }
                    }]
                })
            }


</script>
</html>
