<%@page import="com.inho.userManagement.userDAO"%>
<%@page import="java.sql.Timestamp" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="dto" class="com.inho.userManagement.userDTO" />
<jsp:setProperty name="dto" property="*" />

<%
	dto.setcDate(new Timestamp(System.currentTimeMillis()));
	userDAO dao = userDAO.getInstance();
	if(dao.confirmId(dto.getId()) == userDAO.MEMBER_EXISTENT){
%>
	<script language="javascript">
		alert("Your username is existed");
		window.history.back(-1);
	</script>
<%
	} else {
		int ri = dao.insertMember(dto);
		
		if(ri == userDAO.MEMBER_JOIN_SUCCESS){
%>
	<script language="javascript">
		alert("Created!");
		document.location.href="login.jsp";
	</script>
<%
		} else {
%>
	<script language="javascript">
		alert("Failed!");
		document.location.href="join.jsp";
	</script>
<%
		}
	}
%>