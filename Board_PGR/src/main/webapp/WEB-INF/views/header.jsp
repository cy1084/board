<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.0/dist/sweetalert2.all.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.0/dist/sweetalert2.min.css" rel="stylesheet">

<script type="text/javascript" src="./js/board.js"></script>
<script type="text/javascript" src="./js/user.js"></script>
<style type="text/css">

#container{
	margin: 50px auto;
	width: 1100px;
	height: 800px;
}

header{
	width: 100%;
	height: 300px;
	background: url("https://www.hybus.net/img/sub/sv05.jpg") no-repeat center top;
}
	
header p{
    font-size: 36px;
    font-weight: bold;
    color: #fff;
    text-align: center;
}

header span{
	display: block;
    font-size: 16px;
    font-weight: 500;
    color: #fff;
    text-align: center;
    position: relative;
}

#info{
	float: right;
	display: block;
    font-size: 16px;
    font-weight: 500;
    color: #fff;
    text-align: center;
    position: relative;
	margin-right: 20px;
}

footer{
	line-height: 20px;
	background-color: #4d4d4d;
	text-align: center;
	font-weight: 300;
	color: white;
    height: auto;
    padding: 20px;
}

a{
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	
	<header>
		
		<nav class="navbar navbar-expand-sm navbar navbar-dark bg-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="javascript:void(0)" >HELLO</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="mynavbar" style="text-align: center;">
		      <ul class="navbar-nav me-auto">
		        <li class="nav-item">
		          <a class="nav-link" href="#">HI</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">BYE</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">GOOD</a>
		        </li>
		      </ul>
		      <form class="d-flex">
		        <input class="form-control me-2" type="text" placeholder="Search">
		        <button class="btn btn-outline-light text-white" type="button">Search</button>
		      </form>
		    </div>
		  </div>
		</nav>
	
		<div style="margin: 50px auto;">
			<p>GOODEE</p>
			<span>GOOOOOOOOOOOOOOOOOOOOOOD</span>
			
	
			<div id="info">
				<c:if test="${loginDto.auth eq 'ADMIN'}">
					<span id="currentTime" style="padding-top: 0px;"></span>
					<span style="padding: 2px;">관리자(${loginDto.id})</span>
					<div>
						<button type="button" class="btn btn-info" onclick="location.href='./userManagement.do'">회원관리</button>
						<button type="button" class="btn btn-danger" onclick="location.href='./logoutServlet.do'">로그아웃</button>
					</div>
					
				</c:if>
				
				<c:if test="${loginDto.auth  eq 'USER'}">
					<span id="currentTime" style="padding-top: 0px;"></span>
					<span style="padding: 2px;">
						${loginDto.name}님(${loginDto.id}) 환영합니다. 
					</span>
					<div>
						<button type="button" class="btn btn-info" onclick="location.href='./getMyBoard.do'">내글조회</button>
						<button type="button" class="btn btn-danger" onclick="location.href='./logoutServlet.do'">로그아웃</button>
					</div>
				</c:if>
			</div>
		</div>
	</header>
	
	
	

</body>
</html>