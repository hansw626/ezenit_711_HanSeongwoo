<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/logForm.css" />
<title>EZEN RENTAL CAR</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<section>
			<div class="log_container">
				<h1>EZEN RETAL CAR</h1>
				<div class="login_box">
					<form method="POST" action="login">
						<div>
							<i class="fa-solid fa-circle-user"></i> 
							<input type="text" name="id" placeholder="ID" />
						</div>
						<div>
							<i class="fa-solid fa-lock"></i> 
							<input type="password" name="password" placeholder="Password" />
						</div>
						<input type="submit" class="login_btn" value="로그인" /> 
						<input type="button" class="join_btn" value="회원가입"
							onclick="location.href='join.jsp'" /> 
						<input type="button"class="forgetAcc" value="비밀번호 찾기"
							onclick="location.href='forget.jsp'" />
					</form>
				</div>
			</div>
		</section>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>

