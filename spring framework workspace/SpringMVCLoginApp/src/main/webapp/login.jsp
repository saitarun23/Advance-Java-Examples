<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page with hardcoding</h2>
<form action="checkLogin" method="post">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<input type="submit" value="SignIn"/>
<input type="reset" value="reset"/>
</form>
<hr/>
<h2>Login Page From Db</h2>
<form action="signin" method="post">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<input type="submit" value="SignIn"/>
<input type="reset" value="reset"/>
<a href="signup.jsp">SignUp!</a>
</form>
</body>
</html>