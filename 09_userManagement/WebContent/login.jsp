<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.html"/>
	<title>Login Page</title>
</head>
<body>

<!-- Navigation -->
<jsp:include page="navi.jsp"/>

<!-- Navigation -->
<!-- Container -->
<div class="container paddingtop1">
	<h1 >Login</h1>
	<hr />
	<form action="login_ok.jsp" class="joinForm" method="POST" name="login_form">
		<div class="form-group">
			<label for="inputID">Username</label>
			<input type="text" class="form-control" id="inputID" aria-describedby="idHelp" placeholder="Enter Id" name="id" value="<%=((session.getAttribute("id") != null)?session.getAttribute("id"):"")%>">
			<small id="idHelp" class="form-text text-muted">We'll never share your id with anyone else.</small>
		</div>
		<div class="form-group">
		  <label for="inputPassword">Password</label>
		  <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="pw">
		</div>
		
		<div class="text-right">
			<button type="button" onclick="loginConfirm()" class="btn btn-info">Log in</button>
			<button type="button" class="btn btn-info" onclick="location.href='join.jsp'">Join</button>
		</div>
	</form>
</div>

</body>
</html>