<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>상품을 등록해주세요.</h1>
		<form method="post" action="/backend/AddProduct" id="addproduct">
			<div class="form-group">
				<label for="pname">상품명:</label>
				<input type="text" id="pname" name="pname" class="form-control">
			</div>
			<div class="form-group">
				<label for="price">상품가격:</label>
				<input type="text" id="price" name="price" class="form-control">
			</div>
			<div class="form-group">
				<label for="description">상품설명:</label>
				<input type="text" id="description" name="description"
					class="form-control">
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="저장">
				<input type="reset" class="btn btn-secondary" value="취소">
			</div>
		</form>
	</div>
</body>
<script>
	$("#addproduct").on("submit", function(e) {
		if (!validation()) {
			alert("다시 입력해주세요.");
			e.preventDefault();
		}
	})
	function validation() {
		return $("#pname").val() && $("#price").val() && $("#description").val();
	}
</script>
</html>