<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../common/head.jsp" />
<script type="text/javascript">

	function employee_statusRegist() {
		var mode = $("#modal_mode").val();
		var employee_status_name = $("#regist_employee_status_name").val();
		var message = $("#regist_button").text();
		var employee_status_no = $("#modal_employee_status_no").val();
		var url = "";
		var data = "";
		if (mode == "regist") {
			url = "employee_statusRegist";
			data = "employee_status_name=" + employee_status_name;
		} else if (mode == "update") {
			url = "employee_statusUpdate";
			data = "employee_status_no="+employee_status_no+"&employee_status_name=" + employee_status_name;
		} else {
			alert("등록 및 수정에 이상이 있습니다.");
			return false;
		}
		if (employee_status_name.length > 1) {
			ajaxProcess(url, data, message);
		} else {
			alert("직원상태명을 적어주세요.");
			return false;
		}

	}
	
	function employee_statusDelete(employee_status_no){
		var url = "employee_statusDelete/"+employee_status_no;
		var message = "삭제";
		var data = "";
		if(confirm("정말 삭제하시겠습니까?")){
			ajaxProcess(url, data, message);
		}
	}

	function openModal(mode, employee_status_no, employee_status_name) {
		var mode = mode;
		var buttonText = "";
		var modalMode = "";
		$("#regist_employee_status_name").val('');
		if (mode == "regist") {
			buttonText = "등록";
			modalMode = "regist";
		} else if (mode == "update") {
			buttonText = "수정";
			modalMode = "update";
		}
		$("#regist_employee_status_name").val(employee_status_name);
		$("#regist_button").text(buttonText);
		$("#modal_employee_status_no").val(employee_status_no);
		$("#modal_mode").val(modalMode);
		$("#myModal").modal('show');
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
					alert("중복되는 직원상태명이 존재합니다.다시 입력해주세요.");
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
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			설정관리 <small>직원상태관리</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">설정관리</a></li>
			<li class="active">직원상태관리</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">

			<div class="col-xs-12">
				<form class="navbar-form navbar-right" action="employee_status" role="search"
					method="get">
					<select class="form-control" name="search_sel" id="search_sel">
						<option value="employee_status_name">직원상태명</option>
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
							<th>직원상태번호</th>
							<th>직원상태명</th>
							<th>인원수</th>
							<th>수정/삭제</th>
						</tr>
						<c:if test="${fn:length(employee_statusList)==0}">
							<td colspan="4" align="center"><b>해당하는 데이터가 없습니다.</b></td>
						</c:if>
						<c:if test="${fn:length(employee_statusList) > 0}">
							<c:forEach items="${employee_statusList}" var="employee_statusList" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${employee_statusList.employee_status_name}</td>
									<td>3명</td>
									<td>
										<button type="submit" class="btn btn-info"
											onclick="openModal('update',${employee_statusList.employee_status_no},'${employee_statusList.employee_status_name}');">수정</button>
										<button type="submit" class="btn btn-danger"
											onclick="employee_statusDelete(${employee_statusList.employee_status_no})">삭제</button>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>

				<button type="button" class="btn btn-success btn-md"
					onclick="openModal('regist',0,'');">등록</button>
				<nav class='paging-number text-center'></nav>
			</div>
			<!--  paging start-->
			${paging.page }
			<!--  paging end -->
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<input type="hidden" name="modal_mode" id="modal_mode" /> <input
			type="hidden" name="modal_employee_status_no" id="modal_employee_status_no" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">직원상태 등록</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="regist_employee_status_name"></label> <input type="text"
						name="regist_employee_status_name" id="regist_employee_status_name" class="form-control"
						placeholder="직원상태명" />
				</div>
			</div>
			<div class="modal-footer" id="modal_footer">
				<button type="button" class="btn btn-success" id="regist_button"
					onclick="employee_statusRegist();">등록</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp" />