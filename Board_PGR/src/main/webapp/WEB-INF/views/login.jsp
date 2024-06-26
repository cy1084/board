<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.0/dist/sweetalert2.all.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.0/dist/sweetalert2.min.css" rel="stylesheet">
<script type="text/javascript">
function loginCheck(event){
	
	event.preventDefault();
	var id = document.getElementById("id").value;
	var pw = document.getElementById("password").value;
	
	if(id.trim() == ""){
		
		Swal.fire({
		  icon: "error",
		  title: "아이디를 입력해주세요.",
		});
		
		return;
	} 
	
	if(pw.trim() == ""){
		
		Swal.fire({
		  icon: "error",
		  title: "비밀번호를 입력해주세요.",
		});
		
		return;
	}
	
	document.forms[0].submit();

}
	
</script>
<style type="text/css">
#container{
		margin: 50px auto;
		width: 1100px;
		height: 800px;
}

input[type=text]{
	width:100%;
	height: 10px;
	padding: 18px 12px;
	border: solid 1px #e0e0e0;
	background-color: white;
	font-size: 15px;
	font-weight: 700;
	border-radius: 6px 6px 0 0 ;
}

input[type=password]{
	width:100%;
	height: 10px;
	padding: 18px 12px;
	border: solid 1px #e0e0e0;
	background-color: white;
	font-size: 15px;
	font-weight: 700;
	border-radius: 0 0 6px 6px;
}

input:hover{
	border: 1px solid orange;
	cursor: pointer;
}

input[type=submit]{
	border: 1px solid #e0e0e0; 
	width: 108%;
	margin: 20px auto;
	background-color: #09aa5c;
	color: white;
	font-weight: bold;
	font-size: 15px;
	text-align: center;
	padding: 12px 12px;
	border-radius: 6px 6px 6px 6px;
}

a{
	text-decoration: none;
	text-align: right;
	color: inherit;
	color: #737272;
}
</style>
</head>
<body>
	<form action="./loginServlet.do" method="post" onsubmit="return loginCheck(event)">
		<div id="container" style="margin-top: 100px;">
			<div style="text-align: center; color: #09aa5c; font-weight: bold; margin-bottom: 20px;">
				<h1>GOODEE</h1>
				<span style="font-size: 2.5em;">A C A D E M Y</span>
			</div>
			
		
			<table style="margin: 50px auto;">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id" value="ADMIN"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="password" name="password" value="ADMIN"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="padding: 0;">
						<ul>
							<li style="text-align: right; list-style: none;">
								<a href="./registUser.do">회원가입</a>
							</li>
						</ul>
					</td>
				</tr>
			</table>
			
		</div>
	</form>
	
</body>
</html>