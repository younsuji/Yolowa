<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
  function call(){
	  //location.href="ShowID.jsp?aa=aaa&bb=aaaaa";
	  myfrm.action="ShowID.jsp";
	  myfrm.submit();
	  
  }
  function call2(){
	  //location.href="ShowPassword.jsp";
	  myfrm.action="ShowPassword.jsp";
	  myfrm.submit();
  }

</script>
</head>
<body>

<form action="" name="myfrm">
<table border="1">
   <tr>
     <td>이름</td>
     <td><input type="text" name="c_name"></td>
   </tr>
   <tr>
     <td>전화번호</td>
     <td><input type="text" name="c_phone"></td>
   </tr>
   
   <tr>
     
     <td><input type="button"  onclick="call()"   value="ID 찾기"></td>
     <td><input type="button"  onclick="call2()"  value="비밀번호 찾기"></td>
   </tr>
 </table>
 
 </form>
</body>
</html>