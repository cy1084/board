<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>

</head>
<%@ include file="./header.jsp" %>
<body>

	<div id="container">
		<div style="padding: 10px; float: right;">
				<c:if test="${loginDto.auth eq 'ADMIN'}">
					<button type="button" class="btn btn-warning" onclick="multiDelete(event)">글삭제</button>
				</c:if>
				<button class="btn btn-success" onclick="location.href='./insertBoard.do'">새글작성</button>	
			</div>
		<form action="./deleteBoard.do" method="post">
			<table class="table table-hover" style="text-align: center;">
				<thead class="table-success">
					<tr>
						<c:if test="${loginDto.auth eq 'ADMIN'}">
							<th>
								<input type="checkbox" id="allCheck" onclick="allChk(this.checked)">
							</th>	
						</c:if>
						<th>연번</th>
						<th>작성자</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(boardList) eq 0}">
						<tr>
							<td colspan="5" style="color: #8b8b8b;">게시글이 없습니다.</td>
						</tr>
					</c:if>
					<c:set var="length" value="${fn:length(boardList)}"/>
					<c:forEach var="list" items="${boardList}" varStatus="vs">
						<tr>
							<c:if test="${loginDto.auth eq 'ADMIN'}">
								<td>
									<input type="checkbox" id="check" name="check" value="${list.seq}"> 
								</td>
							</c:if>
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
			
		</form>
		
		<div style="font-size: 20px; display: ruby-text; text-align: center; margin-top: 30px;">
			
			<ul class="pagination">				
			
				<fmt:parseNumber var="num00" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num11" integerOnly="true" value="${(page.page-1) / page.countPage}" />
			
				<c:if test="${page.page > 1}">
					<c:choose>
						<c:when test="${page.stagePage - page.countPage < 0}">
							<li class="page-item">
								<a class="page-link" href="./boardMain.do?page=1">&lt;</a>
							</li>	
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="./boardMain.do?page=${page.stagePage - page.countPage}">&lt;</a>
							</li>	
						</c:otherwise>
					</c:choose>
				</c:if>
									
			
				<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
					<li class="page-item ${i==page.page?'active':''}">
						<a class="page-link" href="./boardMain.do?page=${i}">${i}</a>
					</li>
				</c:forEach>
				
				<fmt:parseNumber var="num1" integerOnly="true" value="${(page.totalPage-1) / page.countPage}" />
				<fmt:parseNumber var="num2" integerOnly="true" value="${(page.page-1) / page.countPage}" />
					
				<c:if test="${num1 > num2}">
					<li class="page-item">
						<a class="page-link" href="./boardMain.do?page=${page.stagePage+page.countPage}">&gt;</a>
					</li>
				</c:if>
				
				
			</ul>		
		</div>
		
		
	</div>

	

</body>
<%@ include file="./footer.jsp" %>
</html>