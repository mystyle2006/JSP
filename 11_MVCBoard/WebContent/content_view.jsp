<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<title>Content View</title>
</head>
<body>
<div class="container">
	<div class="row">
		<h1 class="display-3">View</h1>
	</div>
	<div class="row">
		<div class="col">
			<form action="edit_view.jsp" name="content_form" method="POST">
				<div class="form-group">
	   				<label for="name">Name</label>
	  				<div class="card">
					  <div class="card-body">
					    ${list.name}
					  </div>
					</div>
	 			</div>
				<div class="form-group">
	 				<label for="title">Title</label>
					<div class="card">
					  <div class="card-body">
					    ${list.title}
					  </div>
					</div>
				</div>
	 			<div class="form-group">
				    <label for="content">Content</label>
			    	<div class="card">
					  <div class="card-body">
					    ${list.content}
					  </div>
					</div>
				</div>
				
				<!-- Hidden data to send -->
				<input type="hidden" name="id" value="${list.id}">
				<input type="hidden" name="name" value="${list.name}">
				<input type="hidden" name="title" value="${list.title}">
				<input type="hidden" name="content" value="${list.content}">
				
				<div class="text-right">
					<input type="button" class="btn btn-success" onclick="document.content_form.submit()" value="Edit">
					<input type="button" class="btn btn-success" onclick="window.location='delete.do?id=${list.id}'" value="Delete">
					<input type="button" class="btn btn-secondary" onclick="window.location='list.do'" value="Back">
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>