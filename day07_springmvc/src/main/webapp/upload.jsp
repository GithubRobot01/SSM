<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        名称:<input type="text" name="username"><br/>
        文件1:<input type="file" name="uploadFile"><br/>
        文件2:<input type="file" name="uploadFile"><br/>
        文件3:<input type="file" name="uploadFile"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
