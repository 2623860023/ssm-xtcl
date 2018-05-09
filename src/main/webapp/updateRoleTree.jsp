<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/29
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色赋权限</title>
</head>
<body>
<div class="easyui-tree" id="role_tree"></div>
<script>
    $(function(){
        var id=<%=request.getParameter("id")%>;
        $.ajax({
            url:"<%=request.getContextPath()%>/treeController/queryRoleTree.do",
            data:{"roleId":id},
            type:"post",
            dataType:"json",
            success:function(data){
                $("#role_tree").tree({
                    method:"post",
                    checkbox:true,
                    parentField:'pid',//实体类定义的pid一致
                    data:data
                })
            },error:function(){
            }
        })
    })
</script>
</body>
</html>
