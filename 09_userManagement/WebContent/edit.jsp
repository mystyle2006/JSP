<%@page import="com.inho.userManagement.userDTO"%>
<%@page import="com.inho.userManagement.userDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<%
	String id = (String)session.getAttribute("id");
	userDAO dao = userDAO.getInstance();
	userDTO dto = dao.getUser(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.html"/>
	<title>Edit Page</title>
</head>
<body>
<!-- Navigation -->
<jsp:include page="navi.jsp"/>

<!-- Navigation -->
<!-- Container -->
<div class="container paddingtop1">
	<h1>Sign in</h1>
	<hr />
	<form action="edit_ok.jsp" name="edit_form" class="joinForm" method="POST">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputID">Username</label> 
	      : <%= id %>
	    </div>
	  </div>
	  <div class="form-row">
	  	<div class="form-group col-md-6">
	      <label for="inputPassword4">Password</label>
	      <input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="pw">
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputName">Name</label>
	      <input type="text" class="form-control" id="inputName" placeholder="Name" name="name" value="<%= dto.getName() %>">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Address</label>
	    <input type="text" class="form-control" id="inputAddress" name="adres" value="<%= dto.getAdres() %>">
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-2">
	      <label for="inputCity">City</label>
	      <input type="text" class="form-control" id="inputCity" name="city" value="<%= dto.getCity() %>">
	    </div>
	    <div class="form-group col-md-2">
	      <label for="inputState">State</label>
	      <select id="inputState" class="form-control" name="state">
	        <option <%= ((dto.getState().equals("A"))?"selected='selected'":"") %>>A</option>
	        <option <%= ((dto.getState().equals("B"))?"selected='selected'":"") %>>B</option>
	        <option <%= ((dto.getState().equals("C"))?"selected='selected'":"") %>>C</option>
	        <option <%= ((dto.getState().equals("D"))?"selected='selected'":"") %>>D</option>
	        <option <%= ((dto.getState().equals("F"))?"selected='selected'":"") %>>F</option>
	      </select>
	    </div>
	  </div>
	  <div class="text-center">
	  	<button type="button" class="btn btn-info" onclick="updateInfoConfirm()">Edit</button>
	  	<button type="button" class="btn btn-info" onclick="window.history.back()">Back</button>
	  </div>
	</form>
</div>

</body>
</html>