<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.html"/>
	<title>Join Page</title>
</head>
<body>

<!-- Navigation -->
<jsp:include page="navi.jsp"/>

<!-- Navigation -->
<!-- Container -->
<div class="container paddingtop1">
	<h1>Sign in</h1>
	<hr />
	<form action="join_ok.jsp" class="joinForm" method="POST" name="join_form">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputID">Choose your username</label>
	      <input type="text" class="form-control" id="inputID" placeholder="ID" name="id">
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputPassword4">Create a Password</label>
	      <input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="pw">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputPassword5">Confirm your Password</label>
	      <input type="password" class="form-control" id="inputPassword5" placeholder="Password" name="confirm_pw">
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputName">Name</label>
	      <input type="text" class="form-control" id="inputName" placeholder="Name" name="name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Address</label>
	    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="adres">
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-2">
	      <label for="inputCity">City</label>
	      <input type="text" class="form-control" id="inputCity" name="city">
	    </div>
	    <div class="form-group col-md-2">
	      <label for="inputState">State</label>
	      <select id="inputState" class="form-control" name="state">
	        <option selected value="A">A</option>
	        <option value="B">B</option>
	        <option value="C">C</option>
	        <option value="D">D</option>
	        <option value="F">F</option>
	      </select>
	    </div>
	  </div>
	  <div class="text-center">
	  	<button type="button" class="btn btn-info" onclick="infoConfirm()">Sign in</button>
	  	<input type="reset" class="btn btn-info" value="Reset" onclick="javascript:window.location='login.jsp'">
	  </div>
	</form>
</div>

</body>
</html>