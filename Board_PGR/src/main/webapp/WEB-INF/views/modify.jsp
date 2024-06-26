<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	
	<div id=container>
		<button class="btn btn-info" onclick="location.href='./boardMain.do'" style="text-align: left; margin: 0 0 10px 10px;">목록</button>
		<form action="./modifyBoard.do" method="post">
			<input type="hidden" name="seq" value="${boardDto.seq}">
			<table class="table table-hover" style="text-align: center;">
				<tr>
					<th class="table-success">아이디</th>
					<td>
						<input class="form-control" type="text" name="${loginDto.id}" value="${loginDto.id}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th class="table-success">제목</th>
					<td>
						<input class="form-control" type="text" name="title" value="${boardDto.title}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th class="table-success">내용</th>
					<td>
						<textarea class="form-control" id="modifyContent" name="content" rows="10" cols="50">${boardDto.content}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="btn btn-success" type="submit" value="수정">
						<button class="btn btn-warning" type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
		
	</div>
	
	
	

</body>
<%@ include file="./footer.jsp" %>
</html>