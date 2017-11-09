<%@page import="com.inho.userManagement.userDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="dto" class="com.inho.userManagement.userDTO" />
<jsp:setProperty name="dto" property="*" />

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	userDAO dao = userDAO.getInstance();
	int ri = dao.updateMember(dto);
	
	if(ri == 1){
%>
	<script language="javascript">
		alert("Edited successfully");
		document.location.href="index.jsp";
	</script>
<%
	} else {
%>
	<script language="javascript">
		alert("Failed successfully");
		history.go(-1);
	</script>
<%
	}
%>