<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> <b>회원 가입</b> </h1>
 
 <form action="userconfirm.jsp">
 
 <table border="1">
   <tr>
     <td>아이디</td>
     <td><input type="text" name="c_id"></td>
   </tr>
   <tr>
     <td>비밀번호</td>
     <td><input type="text" name="c_password"></td>
   </tr>
   <tr>
     <td>이름</td>
     <td><input type="text" name="c_name"></td>
   </tr>
   <tr>
     <td>전화번호</td>
     <td><input type="text" name="c_phone"></td>
   </tr>
   <tr>
     
     <td><input type="submit" value="회원등록"></td>
   </tr>
 </table>
 
 </form>
</body>
</html>