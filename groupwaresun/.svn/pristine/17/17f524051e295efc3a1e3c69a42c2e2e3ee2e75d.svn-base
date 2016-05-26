<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../common/head.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			설정관리 <small>팀관리</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">설정관리</a></li>
			<li class="active">팀관리</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">

			<div class="col-xs-12">
				<form class="navbar-form navbar-right" action="role" role="search"
					method="get">
					<select class="form-control" name="search_sel" id="search_sel">
						<option value="team_name">팀명</option>
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
							<th>팀번호</th>
							<th>팀명</th>
							<th>인원수</th>
							<th>수정/삭제</th>
						</tr>
						<tr>
							<td>1</td>
							<td>개발팀</td>
							<td>3명</td>
							<td>
								<button type="submit" class="btn btn-info"
									onclick="openModal();">수정</button>
								<button type="submit" class="btn btn-danger">삭제</button>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>디자인팀</td>
							<td>5명</td>
							<td>
								<button type="submit" class="btn btn-info"
									onclick="openModal();">수정</button>
								<button type="submit" class="btn btn-danger">삭제</button>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>영업팀</td>
							<td>10명</td>
							<td>
								<button type="submit" class="btn btn-info"
									onclick="openModal();">수정</button>
								<button type="submit" class="btn btn-danger">삭제</button>
							</td>
						</tr>
						<tr>
							<td>4</td>
							<td>인사팀</td>
							<td>150명</td>
							<td>
								<button type="submit" class="btn btn-info"
									onclick="openModal();">수정</button>
								<button type="submit" class="btn btn-danger">삭제</button>
							</td>
						</tr>
					</table>
				</div>

				<button type="button" class="btn btn-success btn-md"
					onclick="openModal('regist',0,'');">등록</button>
				<nav class='paging-number text-center'></nav>
			</div>
			<!--  paging start-->
			<nav class='paging-number text-center'>
				<ul class='pagination'>
					<li class='disabled'><a href='#' aria-label='First'> <span
							aria-hidden='true'>&lsaquo;</span></a></li>
					<li class='disabled'><a href='#' aria-label='Previous'> <span
							aria-hidden='true'>&laquo;</span></a></li>
					<li class="active"><a>1</a></li>
					<li><a>2</a></li>
					<li><a>3</a></li>
					<li><a>4</a></li>
					<li><a>5</a></li>
					<li class='disabled'><a href='#' aria-label='Next'> <span
							aria-hidden='true'>&rsaquo;</span></a></li>
					<li class='disabled'><a href='#' aria-label='End'> <span
							aria-hidden='true'>&raquo;</span></a></li>
				</ul>
			</nav>
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
			type="hidden" name="modal_team_no" id="modal_team_no" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">팀 등록</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="regist_team_name"></label> <input type="text"
						name="team_name" id="team_name" class="form-control"
						placeholder="팀명" />
				</div>
			</div>
			<div class="modal-footer" id="modal_footer">
				<button type="button" class="btn btn-success" id="regist_button"
					onclick="teamRegist();">등록</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp" />