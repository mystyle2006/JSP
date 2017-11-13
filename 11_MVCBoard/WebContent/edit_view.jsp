<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<title>Write List</title>
</head>
<body>
<div class="container">
	<div class="row">
		<h1 class="display-3">Edit</h1>
	</div>
	<div class="row">
		<div class="col">
			<form action="edit.do?id=${param.id}" name="edit_form" method="POST">
				<div class="form-group">
    				<label for="name">Name</label>
   					<input type="text" class="form-control" id="name" placeholder="Please put your name" name="name" value="${param.name}">
  				</div>
  				<div class="form-group">
    				<label for="title">Title</label>
   					<input type="text" class="form-control" id="title" placeholder="Please put a title" name="title" value="${param.title}">
  				</div>
  				<div class="form-group">
				    <label for="content">Content</label>
			    	<textarea class="form-control" id="content" placeholder="Please put a content" name="content" rows="3">${param.content}</textarea>
				</div>
				<div class="text-right">
					<input type="button" class="btn btn-success" onclick="document.edit_form.submit()" value="Edit">
					<input type="button" class="btn btn-secondary" onclick="window.location = 'content_view.do?id=${param.id}'" value="Back">
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