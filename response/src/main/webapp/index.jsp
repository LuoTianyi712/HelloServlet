<%--
  Created by IntelliJ IDEA.
  User: LiuFeiyu
  Date: 2021/1/18
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<html>
<body>
<h2>hello world</h2>
<h3>response</h3>

<%--这里提交的路径需要寻找到项目的路径--%>
<%--{pageContext.request.contextPath}代表当前项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">

    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit">

</form>


</body>
</html>
