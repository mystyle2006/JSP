<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration enumeration = session.getAttributeNames();
	int i = 0;
	while(enumeration.hasMoreElements()){
		String sName = enumeration.nextElement().toString();
		String sValue = session.getValue(sName).toString();
		
		if(sValue.equals("abc")) i++;
	}
	
	if(i==0) out.println("Removed the session");
%>
</body>
</html>