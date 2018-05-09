<%--
  Created by IntelliJ IDEA.
  User: zlh
  Date: 2018/4/30
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/roleController/addOss.do" method="post" enctype="multipart/form-data">
    <input type="file" name="fileName" >
    <input type="submit" value="上传">
</form>
</body>
</html>
