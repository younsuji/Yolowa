<%@page import="com.yolowa.model.CustomerDTO"%>
<%@page import="com.yolowa.model.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
CustomerDAO cdao = new CustomerDAO();
String c_name = request.getParameter("c_name");
String c_phone = request.getParameter("c_phone");
String c_password = "존재하지 않는 회원정보입니다.";

CustomerDTO cdto = cdao.selectByC_namephone(c_name, c_phone);
if(cdto!=null) c_password = cdto.getC_password();
%>
 
<h1> 고객님의 비밀번호 : <%=c_password %></h1>
</body>
</html>