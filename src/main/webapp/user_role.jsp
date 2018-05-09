<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/29
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户赋角色</title>
</head>
<body>
<div id="dialog-update-user-role"></div>
<div id="dialog-oss-up"></div>
<div id="p" class="easyui-panel" title="用户角色管理"
     style="width:100%;padding:0px;"
     data-options="iconCls:'icon-save',closable:true,
                collapsible:true,minimizable:true,maximizable:true">

</div>
<table id="dg-user-role">
    <div id="tb">
        <div class="easyui-linkbutton" onclick="updateUserrole()" data-options="iconCls:'icon-edit',plain:true">用户赋角色</div>
        <div class="easyui-linkbutton" onclick="ossUp()" data-options="iconCls:'icon-edit',plain:true">上传图片</div>
    </div>
</table>
<script>
    $(function(){
        $('#dg-user-role').datagrid({
            url:"<%=request.getContextPath()%>/userController/selectUserList.do",
            fitColumns:true,//自动适应
            striped:true,//斑马线
            ctrlSelect:true,//可以选多行,singleSelect:true只能选一行
            pagination:true,
            pagePosition:"bottom",//分页位置
            pageNumber:1,//初始化页码
            pageSize:10,//每页条数
            pageList:[5,10,15],
            loadMsg:"数据加载中....",
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'name',title:'名称',width:100},
                {field:'loginname',title:'登录名',width:100},
                {field:'pwd',title:'密码',width:100},
            ]]

        });
    })
    //修改
    function updateUserrole(){
        var ids=$("#dg-user-role").datagrid("getSelections");
        if(ids.length!=1){
            $.messager.alert('警告','请选择要修改的一条数据');
        }else{
            $("#dialog-update-user-role").dialog({
                title: '修改用户角色',
                width: 300,
                height: 200,
                closed: false,
                cache: false,
                href: "<%=request.getContextPath()%>/updateUserRole.jsp?id="+ids[0].id,
                modal: true,
                toolbar:[{
                    text:'保存',
                    iconCls:'icon-edit',
                    handler:function(){
                        $.ajax({
                            url:"<%=request.getContextPath()%>/roleController/updateUserRole.do?userId="+ids[0].id,
                            data:$("#update-form-user-role").serialize(),
                            type:"post",
                            success:function(){
                                $("#dialog-update-user-role").dialog("close");
                                $("#dg-user-role").datagrid("reload");
                            },
                            error:function(){
                                $.messager.alert('警告','报错');
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#dialog-update-user-role").dialog("close");
                    }
                }]

            })
        }

    }
    function ossUp(){
        $("#dialog-oss-up").dialog({
            title: '上传图片',
            width: 300,
            height: 200,
            closed: false,
            cache: false,
            href: "<%=request.getContextPath()%>/ossUp.jsp",
            modal: true,
            toolbar:[{
                text:'取消',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#dialog-oss-up").dialog("close");
                }
            }]

        })
    }
</script>
</body>
</html>
