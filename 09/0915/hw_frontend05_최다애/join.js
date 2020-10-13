$(document).ready(function() {
	
	var root = "/frontend_ajax";

//회원가입 페이지
	$("#signupBtn").on("click", function(){
		location.href = "http://localhost:8080/frontend_ajax/hw0915/signup.html";
	});

//유효성 검사
	$("#inputSubmit").on("click", function(){
		let userid = $("#inputUserid").val();
		console.log(userid);
		if(userid.length == 0) {
			alert("아이디 입력!!!");
			return;
		}
		let userpass = $("#inputPwd").val();
		if(userpass.length == 0) {
			alert("비밀번호 입력!!!");
			return;
		}
		let username = $("#inputUsername").val();
		if(username.length == 0) {
			alert("이름 입력!!!");
			return;
		}
		let userphone = $("#inputPhone").val();
		if(userphone.length == 0) {
			alert("핸드폰 번호 입력!!!");
			return;
		}
		let useremail = $("#inputEmail").val();
		if(useremail.length == 0) {
			alert("이메일 입력!!!");
			return;
		}
		let useraddr = $("#inputAddr").val();
		if(useraddr.length == 0) {
			alert("주소 입력!!!");
			return;
		}
		alert("회원가입이 완료되었습니다.");
	});

	$("#useridCheck").on("click", function(){
		$.ajax({
			url: "./userlist.xml",
			type: "get",
			success: function(data) {
				let userid = $("#inputUserid").val();
				let check = false;
				$(data).find('user').each(function() {
					if(userid.length == 0 || userid == $(this).attr("id")) {
						check = true;
						return false; // break;  * return true; continue
					}
				});
				if(check){
					alert("사용할 수 없는 아이디입니다.");
				}
				else{
					alert("사용할 수 있는 아이디입니다.");
				}
			}
		});
	});

//로그인 모달
	$("#loginModal").on("click", function(){
		$("#myModal").modal();
	});

//	로그인
	$("#loginBtn").click(function() {
		let userid = $("#loginUserid").val();
		if(userid.length == 0) {
			alert("아이디 입력!!!");
			return;
		}
		let userpass = $("#loginPwd").val();
		if(userpass.length == 0) {
			alert("비밀번호 입력!!!");
			return;
		}
		
		$.ajax({
			url: "./userlist.xml",
			type: "get",
			success: function(data) {
				let login = false;
				let username = '';
				let userphone = '';
				let useremail = '';
				let useraddr = '';
				$(data).find('user').each(function() {
					if(userid == $(this).attr("id") && userpass == $(this).find("password").text()) {
						username = $(this).find("username").text();
						userphone = $(this).find("phone").text();
						useremail = $(this).find("email").text();
						useraddr = $(this).find("address").text();
						login = true;
						return false; // break;  * return true; continue
					}
				});
				
				if(login) {
					$("#header_nav_confirmoff").css("display", "none");
					$("#header_nav_confirmon").css("display", "block");
					$("#profile").html("<b>" + userid + "</b>");
				} else {
					alert("아이디 또는 비밀번호 확인!!!");
				}
			}
		});
	});
	
	//로그아웃
	$("#logoutBtn").click(function() {
		$("#header_nav_confirmoff").css("display", "block");
		$("#header_nav_confirmon").css("display", "none");
	});
	

});