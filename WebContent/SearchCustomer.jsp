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
CustomerDTO cdto = cdao.selectByC_id("ss");

%>

<table border="1">
   <tr>
     <td>아이디</td>
     <td><input type="text" name="c_id" value="<%=cdto.getC_id()%>"></td>
   </tr>
   <tr>
     <td>비밀번호</td>
     <td><input type="text" name="c_password" value="<%=cdto.getC_id()%>"></td>
   </tr>
   <tr>
     <td>이름</td>
     <td><input type="text" name="c_name" value="<%=cdto.getC_id()%>"></td>
   </tr>
   <tr>
     <td>전화번호</td>
     <td><input type="text" name="c_phone" value="<%=cdto.getC_id()%>"></td>
   </tr>
 
 </table>
 
</body>
</html>