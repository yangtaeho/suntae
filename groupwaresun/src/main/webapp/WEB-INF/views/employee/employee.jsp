<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../common/head.jsp" />
<script type="text/javascript">
	function employeeRegist(){
		location.href="employeeRegistUI";
	}
	
	function employeeUpdateUI(employee_no,employee_id){
		$("#employee_no").val(employee_no);
		$("#employee_id").val(employee_id);
		$("#employee_change_form").submit();
	}
	
	function employeeDelete(employee_no,employee_id){
		var url = "employeeDelete";
		var message = "삭제";
		var data = "employee_no="+employee_no+"&employee_id="+employee_id;
		if(confirm("정말 삭제하시겠습니까?")){
			ajaxProcess(url, data, message);
		}	
	}
	
	function ajaxProcess(url, data, message) {
		$.ajax({
			url : url,
			dataType : "json",
			type : "post",
			data : data,
			success : function(data) {
				if (data.result == "success") {
					alert("정상적으로 " + message + "하였습니다.");
					location.reload();
				} else if (data.result == "fail") {
					alert("중복되는 권한명이 존재합니다.다시 입력해주세요.");
				} else {
					alert("서버오류. 담당자에게 문의 주시기 바랍니다.");
				}
			},
			error : function(request, status, error) {
				alert(message + "에 실패하였습니다.");
			}
		});
	}	
</script>
<form action="employeeUpdateUI" method="post"  id="employee_change_form" name="employee_change_form">
	<input type="hidden" name="employee_no" id="employee_no">
	<input type="hidden" name="employee_id" id="employee_id">
</form>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			직원관리 <small>직원관리</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="index"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">직원관리</a></li>
			<li class="active">직원관리</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">

			<div class="col-xs-12">
				<form class="navbar-form navbar-right" action="employee"
					role="search" method="get">
					<select class="form-control" name="search_sel" id="search_sel">
						<option value="employee_name">직원명</option>
						<option value="employee_id">아이디</option>
					</select>

					<div class="form-group">
						<input type="text" name="search_txt" class="form-control"
							placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
			</div>

			<div class="col-xs-12">
				<hr>
				<div class="panel panel-info">
					<!-- Table -->
					<table class="table">
						<tr class="warning">
							<th>직원번호</th>
							<th>이름</th>
 							<th>아이디</th>
							<th>부서명</th>
					  <!--<th>팀명</th>-->
							<th>직급</th>
							<th>휴대폰</th>
							<th>이메일</th>
							<th>수정/삭제</th>
						</tr>
						<c:if test="${fn:length(employeeList) == 0}">
							<td colspan="4" align="center"><b>해당하는 데이터가 존재하지 않습니다.</b></td>
						</c:if>
						<c:if test="${fn:length(employeeList) > 0}">
							<c:forEach items="${employeeList }" var="employeeList">
								<tr>
									<td>${employeeList.employee_no}</td>
									<td>${employeeList.employee_name}</td>
									<td>${employeeList.employee_id}</td>
									<td>${employeeList.department.department_name}</td>
									<!--<td>${employeeList.team.team_name}</td>-->
									<td>${employeeList.position[0].position_name}</td>
									<td>${employeeList.employee_hp}</td>
									<td>${employeeList.employee_email}</td>
									<td>
										<button type="button" class="btn btn-info" onclick="employeeUpdateUI(${employeeList.employee_no},'${employeeList.employee_id }')">수정</button>
										<button type="button" class="btn btn-danger" onclick="employeeDelete(${employeeList.employee_no},'${employeeList.employee_id}')">삭제</button>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>

				<button type="button" class="btn btn-success btn-md" onclick="employeeRegist();">등록</button>
				<nav class='paging-number text-center'></nav>
			</div>
			${paging.page }
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page="../common/footer.jsp" />