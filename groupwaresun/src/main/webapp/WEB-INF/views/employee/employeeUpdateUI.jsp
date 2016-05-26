<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../common/head.jsp" />
<script type="text/javascript">
	function checkEmployee(){
		
		var employeeUpdateFormData = $("#employeeUpdateForm").serializeArray();
		var formCheck = true;
		var url = "employeeUpdate";
		var message = "수정";
	      jQuery.each(employeeUpdateFormData, function(i, formData){
	  
	    	  var formDataName = formData.name;
	    	  var formDataValue = formData.value;
			  var formCheckResult = formValidationCheck(formDataName,formDataValue);
			  if(!formCheckResult){
				  formCheck = false;
				  return false;
			  }
	         if(formData.value.length<1){
	        	 var inputName = $("#"+formData.name).prev().text();
	        	 alert(inputName+"을(를) 입력해주세요");
	        	 $("#"+formDataName).focus();
	        	 formCheck = false;
	        	 return false;
	         }
			
	        });	
	      //true
	     if(formCheck){
	    	 ajaxProcess(url, employeeUpdateFormData,message);
	     }else{
	    	 
	     }
	}
	
	function cancelEmployeeUpdate(){
		location.href="employee";
	}
	 function formValidationCheck(formDataName,formDataValue){
 		 if((formDataName == "employee_id") && formDataValue<4){
	   		  alert("아이디를 3글자 이상 적어주세요");
	   		 $("#"+formDataName).focus();
	   		  return false;
			 }
		 if((formDataName == "employee_pw") && formDataValue.length<4 && formDataValue.length<13){
			 alert("비밀번호를 4~12자 사이로 적어주세요");
      		 $("#"+formDataName).focus();
      		  return false;
      	  }
 		 if((formDataName == "employee_name") && formDataValue<3 && formDataValue.length>13){
	   		  alert("이름을 3자~13자 사이로 적어주세요");
	   		 $("#"+formDataName).focus();
	   		  return false;
		 }		
 		 if((formDataName == "employee_hp") && formDataValue<10 && formDataValue.length>11){
	   		  alert("휴대폰 번호를 10자~11자 사이로 적어주세요");
	   		 $("#"+formDataName).focus();
	   		  return false;
		 }				 
		 return true;
	 }
	 
		function ajaxProcess(url, data,message) {
			$.ajax({
				url : url,
				dataType : "json",
				type : "post",
				data : data,
				success : function(data) {
					if (data.result == "success") {
						alert("정상적으로 "+ message + "하였습니다.");
						location.href ="employee";
					} else if (data.result == "fail") {
                         var inputName = $("#"+data.reason).prev().text();
                         alert("중복된"+inputName+"가 있습니다.");
                         $("#"+data.reason).focus();
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
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      직원관리
      <small>직원등록</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
      <li><a href="#">직원관리</a></li>
      <li class="active">직원등록</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">
    <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->
        <div class="box box-primary">
          <div class="box-header with-border">
          <h3 class="box-title">관리자모드 직원수정</h3>
          </div>
          <!-- /.box-header -->
          <!-- form start -->
          <form role="form" name="employeeUpdateForm" id="employeeUpdateForm">
          <input type="hidden" class="form-control" id="employee_no" name="employee_no"  value="${employee.employee_no }">
            <div class="box-body">
              <div class="form-group">
                <label for="employee_id">아이디</label>
                <input type="text" class="form-control" id="employee_id" name="employee_id" placeholder="아이디" value="${employee.employee_id }" readonly="readonly">
              </div>
              <div class="form-group">
                <label for="employee_name">이름</label>
                <input type="text" class="form-control" id="employee_name" name="employee_name" placeholder="이름" value="${employee.employee_name }" readonly="readonly">
              </div>
              <div class="form-group">
                <label for="employee_hp">휴대폰</label>
                <input type="text" class="form-control" id="employee_hp" name="employee_hp" placeholder="휴대폰"  size="11" value="${employee.employee_hp }">
              </div>
              <div class="form-group">
                <label for="employee_email">이메일</label>
                <input type="email" class="form-control" id="employee_email" name="employee_email" placeholder="이메일" value="${employee.employee_email }">
              </div>     
              <!-- 권한 -->
              <div class="form-group">
                <label for="role_no">권한</label>
                <select class="form-control" name="role_no" id="role_no">
				<c:forEach items="${roleList}" var="roleList">
					<option value="${roleList.role_no}"  ${roleList.role_no eq employee.role.role_no?'selected':''}>${roleList.role_name}</option>
				</c:forEach>
                </select>
              </div> 
              <!-- 직원상태 -->
              <div class="form-group">
                <label for="employee_status_no">직원상태</label>
                <select class="form-control" name="employee_status_no" id="employee_status_no">
				<c:forEach items="${employee_statusList}" var="employee_statusList">
					<option value="${employee_statusList.employee_status_no}" ${employee_statusList.employee_status_no eq employee.employee_status.employee_status_no?'selected':''}>${employee_statusList.employee_status_name}</option>
				</c:forEach>
                </select>
              </div> 
              <!-- 부서 -->
              <div class="form-group">
                <label for="department_no">부서</label>
                <select class="form-control" name="department_no" id="department_no">
				<c:forEach items="${departmentList}" var="departmentList">
					<option value="${departmentList.department_no}" ${departmentList.department_no eq employee.department.department_no?'selected':''}>${departmentList.department_name}</option>
				</c:forEach>
                </select>
              </div> 
              <!-- 팀 -->
              <div class="form-group">
                <label for="team_no">팀</label>
                <select class="form-control" name="team_no" id="team_no">
				<c:forEach items="${teamList}" var="teamList">
					<option value="${teamList.team_no}" ${teamList.team_no eq employee.team.team_no?'selected':''}>${teamList.team_name}</option>
				</c:forEach>
                </select>
              </div>                        
              <!-- 직급 -->
              <div class="form-group">
                <label for="position_no">직급</label>
                <select class="form-control" name="position_no" id="position_no">
				<c:forEach items="${positionList}" var="positionList">
					<option value="${positionList.position_no}" ${positionList.position_no eq employee.position[0].position_no?'selected':''}>${positionList.position_name}</option>
				</c:forEach>
                </select>
              </div>     
              <!--  계정 활성화 -->   
              <div class="form-group">
                <label for="position_no">활성여부</label>
                <select class="form-control" name="employee_activity_no" id="employee_activity_no">
					<option value="1" ${employee.employee_activity_no eq 1 ? 'selected':''}>활성</option>
					<option value="2" ${employee.employee_activity_no eq 2 ? 'selected':''}>비활성</option>
                </select>
              </div>    	                            
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
              <button type="reset" class="btn btn-default" onclick="cancelEmployeeUpdate();">취소</button>
              <button type="button" class="btn btn-success pull-right" onclick="checkEmployee();">수정</button>
            </div>
          </form>
        </div>
        <!-- /.box -->
        <!-- /input-group -->
      </div>
      <!-- /.box-body -->
    </div>
    <!-- /.box -->
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page="../common/footer.jsp" />