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

System.out.println(c_name+" "+c_phone);
String c_id="ID가 존재하지 않습니다.";

CustomerDTO cdto = cdao.selectByC_namephone(c_name, c_phone);
if(cdto!=null) c_id = cdto.getC_id();
%>
 
<h1> 고객님의 아이디 : <%=c_id %></h1>
 
 
 
</body>
</html>