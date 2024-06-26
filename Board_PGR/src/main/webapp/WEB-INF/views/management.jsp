<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<form>
			<div style="margin: 0 10px 10px; float: right;">
				<select class="form-select" onchange="enableChange(this.value)">
					<option id="all" value="all" selected="selected">전체</option>
					<option id="approval" value="approval">승인 완료</option>
					<option id="wait" value="wait">승인 대기</option>
					<option id="refusal" value="refusal">승인 거부</option>
					<option id="delete" value="delete">회원 탈퇴</option>
				</select>
<!-- 				<button type="button" oncha onclick="location.href="></button> -->
				<button class="btn btn-success" onclick="approvalUser(event)">승인</button>
				<button class="btn btn-warning" onclick="refusalUser(event)">거부</button>
				<button class="btn btn-danger" onclick="deleteUser(event)">삭제</button>
			</div>
			<table class="table table-hover" style="text-align: center;">
				<thead class="table-success">
					<tr>
						<th>
							<input type="checkbox" id="userAllCheck" name="userAllCheck" onclick="userAllChk(this.checked)">
						</th>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>가입상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userList}" varStatus="vs">
						<tr>
							<td>
								<input type="checkbox" id="UserCheck" name="UserCheck" value="${user.id}">					
							</td>
							<td>${vs.count}</td>
							<td>
								<a href="./userDeatil.do?id=${user.id}">${user.id}</a>
							</td>
							<td>${user.name}</td>
							<td>${user.phone}</td>
							<c:choose>
									<c:when test="${user.enable eq 'Y'}">
										<td>회원 가입 승인</td>
									</c:when>
									<c:when test="${user.enable eq 'N'}">
										<td>회원 탈퇴</td>
									</c:when>
									<c:when test="${user.enable eq 'D'}">
										<td>회원 가입 대기</td>
									</c:when>
									<c:otherwise>
										<td>회원 가입 거부</td>
									</c:otherwise>
							</c:choose>
							
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		
		
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>