<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 화면</title>
<style type="text/css">
	#profile{
		margin-top: 100px;
		padding: 15px 50px 50px;
	    border: 2px solid #333;
	    border-radius: 100px 10px 10px 10px;
	    background: #fff;
	    width: 90%;
	    height: 450px;
	    text-align: center;
	}
	p{
		font-size: 22px;
	    font-weight: 500;
	    color: #999;
	}
	h3{
		margin-bottom: 30px;
	    font-size: 45px;
	    font-weight: 700;
	}
</style>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		
		<div id="profile">
			<div style="width: 400px; height: 400px; display: inline-flex; text-align: center;">
				<c:choose>
					<c:when test="${userDto.photo_storedname eq null}">
						<img style="margin-top: 20px; width: 390px; height: 390px;" alt="${userDto.name}" src="./img/xxxx.png">
					</c:when>
					<c:otherwise>
						<img style="margin-top: 20px; width: 390px; height: 390px;;" alt="${userDto.name}" src="./uploads/${userDto.photo_storedname}">
					</c:otherwise>
				</c:choose>
			</div>
			<div style="width: 400px; height: 400px; display: inline-block;">
				<table class="table" style="margin: 50px;">
					<tr>
						<th><img src="./img/id.png"></th>
						<td>${userDto.id}</td>
					</tr>
					<tr>
						<th><img src="./img/name.png"></th>
						<td>${userDto.name}</td>
					</tr>
					<tr>
						<th><img src="./img/phone.png"></th>
						<td>${userDto.phone}</td>
					</tr>
					
						<c:choose>
							<c:when test="${userDto.enable eq 'Y'}">
								<tr>
									<th><img src="./img/good.png"></th>
									<td>가입 승인 완료</td>
								</tr>
								<tr>	
									<td colspan="2" style="text-align: center;">
										<button class="btn btn-danger" onclick="location.href='./deleteUser.do?UserCheck=${userDto.id}'">회원 삭제</button>
									</td>
								</tr>	
							</c:when>
							<c:when test="${userDto.enable eq 'N'}">
							<tr>
								<th><img src="./img/delete.png"></th>
								<td>회원 탈퇴</td>
							</tr>	
							</c:when>
							<c:when test="${userDto.enable eq 'D'}">
								<tr>
									<th><img src="./img/wait.png"></th>
									<td>가입 승인 대기</td>
								</tr>
								<tr>	
									<td colspan="2" style="text-align: center;">
										<button class="btn btn-success" onclick="location.href='./approvalUser.do?UserCheck=${userDto.id}">가입 승인</button>
										<button class="btn btn-warning" onclick="location.href='./refusalUser.do?UserCheck=${userDto.id}'">가입 거부</button>
									</td>
								</tr>	
							</c:when>
							<c:otherwise>
								<th><img src="./img/delete.png"></th>
								<td>가입 승인 거부</td>
							</c:otherwise>
						</c:choose>
					
					
				</table>
			
<%-- 				<p>${userDto.id}</p> --%>
<%-- 				<h3>${userDto.name}</h3> --%>
<%-- 				<p style="margin: 10px 0 50px;font-size: 20px;font-weight: 400; line-height: 1.3; color: #2e2e2e;">${userDto.phone}</p> --%>
			</div>
		</div>	
	</div>
	
</body>
<%@ include file="./footer.jsp" %>
</html>