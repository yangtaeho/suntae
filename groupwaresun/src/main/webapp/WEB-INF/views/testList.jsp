<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="testList">
		<select name="search_name" id="search_name">
			<option value="">선택하세요</option>
			<option value="test_name">이름</option>
		</select>
		<select name="search_no" id="search_no">
		<option value="">선택하세요</option>
			<option value="test_no">번호</option>
		</select>
		<input type="text" name="search_text">
		<input type="submit" value="전송">
	</form>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${testList}" var="testList">
				<tr>
					<td>${testList.test_no}</td>
					<td>${testList.test_name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
${pagingTest.getPage() }
</body>
</html>