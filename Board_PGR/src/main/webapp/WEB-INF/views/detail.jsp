<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	
	<div id="container">
		<button class="btn btn-info" onclick="location.href='./boardMain.do'" style="text-align: left; margin: 0 0 10px 10px;">목록</button>
		<table class="table table-hover" style="text-align: center;">
			<thead class="table-success">
				<tr>
					<th>연번</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${num}</td>
					<td>${boardDto.name}</td>
					<td>${boardDto.title}</td>
					<td>
						<fmt:parseDate var="date" value="${boardDto.createat}" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일"/>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea class="form-control" rows="10" cols="50" readonly="readonly">${boardDto.content}</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: center;">
			<c:if test="${boardDto.id eq loginDto.id}">
				<button class="btn btn-warning" onclick="detailDelete(${boardDto.seq})">삭제</button>
				<button class="btn btn-success" onclick="location.href='./modifyBoard.do?seq=${boardDto.seq}'">수정화면</button>
			</c:if>
		</div>
	</div>
	
	
	
</body>
<%@ include file="./footer.jsp" %>
</html>