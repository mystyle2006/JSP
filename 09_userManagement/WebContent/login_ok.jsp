<%@page import="com.inho.userManagement.userDTO"%>
<%@page import="com.inho.userManagement.userDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	userDAO dao = userDAO.getInstance();
	int checkNum = dao.userCheck(id, pw);
	if(checkNum == -1){
%>
		<script language="javascript">
			alert("no username existed");
			history.go(-1);
		</script>
<%
	} else if(checkNum == 0){
%>
		<script language="javascript">
			alert("Wrong password");
			history.go(-1);
		</script>
<%
	} else {
		userDTO dto = dao.getUser(id);
		
		String name = dto.getName();
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("loginStatus", "true");
		response.sendRedirect("index.jsp");
	}
%>