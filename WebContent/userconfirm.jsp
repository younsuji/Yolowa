<%@page import="com.yolowa.model.CustomerDTO"%>
<%@page import="com.yolowa.model.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
CustomerDAO cdao = new CustomerDAO();
String c_id = request.getParameter("c_id");
String c_password = request.getParameter("c_password");
String c_name = request.getParameter("c_name");
String c_phone = request.getParameter("c_phone");

CustomerDTO cdto = new CustomerDTO(c_id, c_password, c_name, c_phone, 100000);
cdao.insertCustomer(cdto);


%>
<h1>  <%=c_name %>   환영합니다......</h1>

</body>
</html>