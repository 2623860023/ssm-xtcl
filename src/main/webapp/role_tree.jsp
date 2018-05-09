<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/29
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色赋权限</title>
</head>
<body>
<!-- 修改的div -->
<div id="dialog-update-role-tree"></div>
<div id="p" class="easyui-panel" title="角色权限管理"
     style="width:100%;padding:0px;"
     data-options="iconCls:'icon-save',closable:true,
                collapsible:true,minimizable:true,maximizable:true">

</div>
<table id="dg-role-tree">
    <div id="tb-role-tree">
        <div class="easyui-linkbutton" onclick="updateRoletree()"data-options="iconCls:'icon-edit',plain:true">角色赋权限</div>
    </div>
</table>
<script>
    $(function(){
        $('#dg-role-tree').datagrid({
            url:"<%=request.getContextPath()%>/roleController/selectRoleList.do",
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
            ]]

        });
    })
    //修改
    function updateRoletree(){
        var ids=$("#dg-role-tree").datagrid("getSelections");
        if(ids.length!=1){
            $.messager.alert('警告','请选择要修改的一条数据');
        }else{
            $("#dialog-update-role-tree").dialog({
                title: '角色赋权限',
                width: 300,
                height: 300,
                closed: false,
                cache: false,
                href: "<%=request.getContextPath()%>/updateRoleTree.jsp?id="+ids[0].id,
                modal: true,
                toolbar:[{
                    text:'保存',
                    iconCls:'icon-edit',
                    handler:function(){
                        //获取被选中的树的值
                        var node=$("#role_tree").tree("getChecked");
                        var idss ="";
                        for (var i = 0; i < node.length; i++) {
                            idss+=","+node[i].id;
                        }
                        idss=idss.substring(1);
                        $.ajax({
                            url:"<%=request.getContextPath()%>/treeController/updateTreeRelation.do?ids="+idss+"&roleId="+ids[0].id,
                            type:"post",
                            success:function(){
                                $("#dialog-update-role-tree").dialog("close");

                            },error:function(){
                                $.messager.alert('警告','报错');
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#dialog-update-role-tree").dialog("close");
                    }
                }]

            })
        }

    }
</script>
</body>
</html>
