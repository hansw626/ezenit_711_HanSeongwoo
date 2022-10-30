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
					<form method="POST" action="join">
						<div>
							<i class="fa-solid fa-circle-user"></i>
							<input type="text" name="id" placeholder="ID" />
						</div>
						<div>
							<i class="fa-solid fa-lock"></i> 
							<input type="password" name="password" placeholder="Password" />
						</div>
						<div>
							<i class="fa-solid fa-id-badge"></i> 
							<input type="text" name="name" placeholder="Name" />
						</div>
						<div>
							<i class="fa-solid fa-id-card"></i> 
							<input type="text" name="license" placeholder="license ex)00-00-000000-00" />
						</div>
						<div>
							<i class="fa-solid fa-mobile"></i> 
							<input type="text" name="phone" placeholder="Phone ex)010-0000-0000" />
						</div>
						<div>
							<i class="fa-solid fa-person-shelter"></i> 
							<input type="text" name="address" placeholder="Address" />
						</div>
						<input type="submit" class="join_btn" value="회원가입" />
					</form>
				</div>
			</div>
		</section>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>

