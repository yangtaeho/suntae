<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Registration Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Groupware</title>
	<!-- Bootstrap 3.3.5 -->
	<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
	<!-- jQuery 2.1.4 -->
	<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script type="text/javascript">
		function registEmployee(){
			var formCheck = true;
			var employee_id = $("#employee_id").val();
			var employee_pw = $("#employee_pw").val();
			var url = "login_ok";
			var data = "employee_id="+employee_id+"&employee_pw="+employee_pw;
	 		 if(employee_id.length < 4){
		   		  alert("아이디를 3글자 이상 적어주세요");
		   		  $("#employee_id").focus();
		   		  formCheck = false;
		   		  return false;
			 }
	 		 if(employee_pw.length<4 && employee_pw.length >13){
		   		  alert("비밀번호를 4-13자 사이로 적어주세요");
		   		  $("#employee_pw").focus();
		   		  formCheck = false;
		   		  return false;
			 }	
	 		 if(formCheck){
	 			ajaxProcess(url,data,employee_id);
	 		 }
		}
		
		function ajaxProcess(url, data,message) {
			$.ajax({
				url : url,
				dataType : "json",
				type : "post",
				data : data,
				success : function(data) {
					if (data.result == "success") {
						alert("반갑습니다 "+message+"님");
						location.href ="index";
					} else if (data.result == "fail") {              
                         alert("아이디 혹은 비밀번호가 맞지 않습니다. 다시 확인해주세요.");
                         $("#member_id").focus();
					} else {
						alert("서버오류. 담당자에게 문의 주시기 바랍니다.");
					}
				},
				error : function(request, status, error) {
					alert(message+"에 실패하였습니다.");
				}
			});
		}		
	</script> 
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>Groupware</b>Sun</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Login</p>

					<form>	
						<fieldset>
							<legend>로그인</legend>
							<div class="form-group">
								<div class="col-md-12">
									<label for="employee_id" >아이디</label>
									<input type="text" class="form-control" id="employee_id" name="employee_id" placeholder="아이디">
								</div>
								<div class="col-md-12">
									<label for="employee_pw" >비밀번호</label>
									<input type="password" class="form-control" id="employee_pw" name="employee_pw" placeholder="비밀번호" size="13">
								</div>								
<!-- 								<div class="col-md-12">
									<label for="regist_submit"></label>
									<input type="button" name="regist_submit" id="regist_submit" class="form-control btn btn-info" value="회원가입">         
								</div> -->
								   
								<div class="col-md-12">
									<label for="login_submit"></label>
									<input type="button" name="login_submit" id="login_submit" class="form-control btn btn-success" value="로그인" onclick="registEmployee();">         
								</div>   	
								<div class="col-md-12">
									<label for="regist_reset"></label>
									<input type="reset" name="regist_reset" id="regist_reset" class="form-control btn btn-danger" value="취소">         
								</div>   															
							</div>
						</fieldset>				
					</form>


   
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->
</body>
</html>
