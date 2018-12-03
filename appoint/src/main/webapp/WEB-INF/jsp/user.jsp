<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/user/user-role">
        用户名称：<input type="text" name="user.name"/><br/><br/>
        角色：<input type="text" name="role.name"/><br/><br/>
        用户邮箱：<input type="text" name="user.email"/><br/><br/>
        用户年龄：<input type="text" name="user.age"/><br/><br/>
        注册时间：<input type="text" name="user.createTime"/><br/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
