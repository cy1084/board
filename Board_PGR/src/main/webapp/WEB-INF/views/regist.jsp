<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.0/dist/sweetalert2.all.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.0/dist/sweetalert2.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript" src="./js/user.js"></script>
<style type="text/css">
#container{
		margin: 50px auto;
		width: 1100px;
		height: 800px;
}
form{
	width: 600px;
	margin: auto;
}

th{
    width: 150px;
    font-weight: 400;
    font-size: small;
}
</style>
</head>
<body>

	<div id="container">
		<form action="./registUser.do" method="post" enctype="multipart/form-data" onsubmit="return registUser(event)">
			<h3 style="padding: 10px;">회원가입</h3>
			<table class="table table-bordered" style="border-radius: 3px 3px 3px 3px;">
				<tr>
					<th class="table-success">아이디<p style="font-size: small; color: orange; display: inline;"> *</p></th>
					<td>
						<input class="form-control form-control-sm" style="display: inline; width: 70%;" type="text" id="registId" name="registId" placeholder="아이디">
						<button type="button" class="btn btn-outline-dark btn-sm" style="float: right; margin-right: 20px;" onclick="duplicate()">중복확인</button>
					</td>
				</tr>
				<tr>
					<th class="table-success">비밀번호<p style="font-size: small; color: orange; display: inline;"> *</p></th>
					<td>
						<input class="form-control form-control-sm" type="password" id="registPassword" name="registPassword" placeholder="비밀번호" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th class="table-success">비밀번호확인<p style="font-size: small; color: orange; display: inline;"> *</p></th>
					<td>
						<input class="form-control form-control-sm" type="password" id="registPasswordCheck" name="registPasswordCheck" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th class="table-success">프로필 사진</th>
					<td>
						<input class="form-control form-control-sm" type="file" id="imgFile" name="imgFile" readonly="readonly" disabled="disabled" >
					</td>
				</tr>
				<tr>
					<th class="table-success">이름<p style="font-size: small; color: orange; display: inline;"> *</p></th>
					<td>
						<input class="form-control form-control-sm"  type="text" id="registName" name="registName" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th class="table-success">전화번호<p style="font-size: small; color: orange; display: inline;"> *</p></th>
					<td>
						<input class="form-control form-control-sm" type="text" id="registPhone" name="registPhone" readonly="readonly">
					</td>
				</tr>
			</table>
			<div style="text-align: center;">
				<input type="submit" class="btn btn-success" value="등록">
			</div>
		</form>
	</div>
	
</body>
</html>