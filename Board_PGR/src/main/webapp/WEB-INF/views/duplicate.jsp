<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	function useId(){
		var id = opener.document.getElementsByName("registId")[0];
		var pw = opener.document.getElementsByName("registPassword")[0];
		var pwCheck = opener.document.getElementsByName("registPasswordCheck")[0];
		var name = opener.document.getElementsByName("registName")[0];
		var phone = opener.document.getElementsByName("registPhone")[0];
		var img = opener.document.getElementsByName("imgFile")[0];
		id.setAttribute("readonly","readonly");
		pw.removeAttribute("readonly");
		pwCheck.removeAttribute("readonly");
		name.removeAttribute("readonly");
		phone.removeAttribute("readonly");
		img.removeAttribute("disabled");
		img.removeAttribute("readonly");
		self.close();
	}

</script>
<style type="text/css">
	#container{
		margin: 50px auto;
		width: 350px;
		height: 200px;
	}
</style>
</head>
<body>
	<div id="container">
		<table class="table table-bordered">
			<tr>
				<th class="table-success">아이디</th>
				<td>
					<input class="form-control form-control-sm" type="text" id="checkId" name="checkId" value="${registId}" readonly="readonly">
				</td>
			</tr>
			<tr>
		</table>
		<div>
			<c:choose>
				<c:when test="${idIsc eq true}">
					<p style="color: blue; font-weight:bold; font-size: 0.8em; text-align: center;">사용할 수 있는 아이디입니다.</p>
				</c:when>
				<c:otherwise>
					<p style="color: red; font-weight:bold; font-size: 0.8em; text-align: center;">사용할 수 없는 아이디입니다.</p>
				</c:otherwise>
			</c:choose>
		</div>
		<div style="text-align: center;">
			<c:if test="${idIsc eq true}">
				<button class="btn btn-success" onclick="useId()">확인</button>
			</c:if>
			<button class="btn btn-danger" onclick="self.close()">취소</button>
		</div>				
	</div>
</body>
</html>