<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내글조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>

	<div id="container">
		<div style="padding: 10px; float: right;">
				<button class="btn btn-success" onclick="location.href='./insertBoard.do'">새글작성</button>	
		</div>
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
					<c:if test="${fn:length(myBoardList) eq 0}">
						<tr>
							<td colspan="5" style="color: #8b8b8b;">게시글이 없습니다.</td>
						</tr>
					</c:if>
					<c:set var="length" value="${fn:length(myBoardList)}"/>
					<c:forEach var="list" items="${myBoardList}" varStatus="vs">
						<tr>
							<td>
								${page.totalCount - (page.page-1)*page.countList - vs.index}
							</td>
							<td>${list.name}</td>
							<td>
								<a href="./detailBoard.do?seq=${list.seq}&num=${page.totalCount - (page.page-1)*page.countList - vs.index}">${list.title}</a>
							</td>
							<td>
								<fmt:parseDate var="date" value="${list.createat}" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
		<div style="font-size: 20px; display: ruby-text; text-align: center; margin-top: 30px;">
			
			<ul class="pagination">					
				<c:if test="${page.page > 1}">
					<c:choose>
						<c:when test="${page.stagePage - page.countPage < 0}">
							<li class="page-item">
								<a class="page-link" href="./getMyBoard.do?page=1">&lt;</a>
							</li>	
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="./getMyBoard.do?page=${page.stagePage - page.countPage}">&lt;</a>
							</li>	
						</c:otherwise>
					</c:choose>
				</c:if>
									
			
				<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
					<li class="page-item ${i==page.page?'active':''}">
						<a class="page-link" href="./getMyBoard.do?page=${i}">${i}</a>
					</li>
				</c:forEach>
				
				<fmt:parseNumber var="num1" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num2" integerOnly="true" value="${(page.page-1) / page.countPage}" />
					
				<c:if test="${num1 > num2}">
					<li class="page-item">
						<a class="page-link" href="./getMyBoard.do?page=${page.stagePage+page.countPage}">&gt;</a>
					</li>
				</c:if>
				
				
			</ul>		
		</div>
		
		
	</div>

</body>
<%@ include file="./footer.jsp" %>
</html>