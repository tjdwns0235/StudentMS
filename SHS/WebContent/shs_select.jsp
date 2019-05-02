<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--jstl 라이브러리를 사용하기 위한 선언문 -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생조회</title>
<link rel="stylesheet" href="css/common.css">
<style type="text/css">
		.content {
			width: 390px;
			height: 600px;
			border:2px solid black;
			margin: 50px auto 0;
			background-color: #d8e9ef;
			border-radius: 5px; 
		}
		.shs_manager {
			padding-top: 20px;
			padding-bottom: 70px;
			text-align: center;
			color:#454552;
			font-size: 20px;
		}
		.btn_index {
			padding: 15px 12px;
			background-color:yellowgreen;
			color: white;
			width:120px;
			display: inline-block;
			border-radius: 10px;
			font-size: 17px;
		}
		.div_index {
			padding-bottom: 30px;
			text-align: center;
		}
		.btn_index:hover {
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
		}
		.btn2 {
			background-color: darkorange;
		}
		.btn3 {
			background-color:salmon;
		}
		.in_content {
			width: 330px;
			margin: 0 auto;
		}
		table {
			font-size: 17px;
			border-collapse: collapse;
			width: 330px;
			margin-bottom: 20px;
		}
		.table_title {
			background-color: yellowgreen;
			height: 25px;
			border:0;
		}
		.table_data {
			background-color: white;
			height: 25px;
			font-size: 17px; 
		}
		.table_data:hover {
			background-color: lightyellow;
		}
		th{padding: 5px;}
		td {text-align: center; padding: 3px 0;}
		tr {border-bottom: 1px dashed #bbbbbb;}
		.uBtn {color: dodgerblue;}
		.dBtn {color: tomato;}
	</style>
</head>
<body>
		<%@include file="include/header.jsp" %>
		<div class="shs_manager">--출석부-</div>
		<div class="in_content">
			<table>
				<tr class="table_title">
					<th>ID</th>
					<th>NAME</th>
					<th>Tel.</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${shslest}" var="mDto"> <!--${shslest}= EL태그에 담긴 shslest를 mDto로 담는다. -->
					<tr class="table_data">
						<td>${mDto.sid}</td>
						<td>${mDto.sname}</td>
						<td>${mDto.sphone}</td>
						<td><a href="#" class="uBtn">수정</a></td>
						<td><a href="#" class="dBtn">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="div_index">
			<a href="index" class="btn_index btn3">뒤로가기</a>
		</div>

	</div>
</body>
</html>