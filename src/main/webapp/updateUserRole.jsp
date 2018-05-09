<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/29
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="update-form-user-role">
    <input type="hidden" name="userId" id="userId"/>
</form>
<script>
    //获取用户id
    var id=<%=request.getParameter("id")%>;
    $("#userId").val(id);
    $(function(){
        $.ajax({
            url:"<%=request.getContextPath()%>/roleController/selectRoleList.do",
            type:"post",
            dataType:"json",
            success:function(result){
                console.log(result);
                var htm="";
                var text="";
                $.ajax({
                    url:"<%=request.getContextPath()%>/roleController/queryRoleByUserId.do",
                    data:{"userId":id},
                    type:"post",
                    dataType:"json",
                    success:function(data){
                        console.log(data);
                        for (var i = 0; i < result.length; i++) {
                            var count=0;
                            for (var j = 0; j < data.length; j++) {
                                if(result[i].id==data[j].id){
                                    htm+="<input type='radio' checked name='roleId' value='"+result[i].id+"'/>"+result[i].name;
                                    count=1;
                                    break;
                                }
                            }
                            if(count!=1){
                                //console.log(result[i].id);
                                htm+="<input type='radio' name='roleId' value='"+result[i].id+"'/>"+result[i].name;
                            }
                        }

                        $("#update-form-user-role").html(htm);
                    },error:function(){
                        alert("报错");
                    }

                })
            },error:function(){
                alert("报错");
            }

        })
    })

</script>
</body>
</html>
