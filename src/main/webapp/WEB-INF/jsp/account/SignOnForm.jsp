<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>SignOnForm</title>
</head>
<body>
<h2>Here is SignOnForm.jsp</h2>

	<form action='<c:url value="/shop/signon.do"/>' method="POST">
	              <div class="form-label-group">
	                <input type="text" id="inputUserId" name="userId" class="form-control" placeholder="ID" required autofocus>
	                <label for="inputUserId">Your ID</label>
	              </div>
	              <div class="form-label-group">
	                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="PASSWORD" required>
	                <label for="inputPassword">Your Password</label>
	              </div>
	              <div class="form-label-group">
	                <button class="btn btn-lg btn-warning btn-block text-uppercase" type="submit">Sign in</button>
	              </div>
	              <hr class="my-4">
	              <div class="form-label-group">
	              	<a href='<c:url value="/shop/newAccount.do"/>' class="btn btn-lg btn-warning btn-block text-uppercase">
		              		New Account
	              	</a>
	              </div>
	</form>
</body>
</html>