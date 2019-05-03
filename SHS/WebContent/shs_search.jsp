<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--jstl 라이브러리를 사용하기 위한 선언문 -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생검색</title>
<link rel="stylesheet" href="css/common.css?v=1">
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
		.name {
			color: dodgerblue;
		}
		.search_wrap {
			margin-bottom:15px;
			width:100%;
			height:40px;
			position:relative;
		}
		.input_search {
			height:100%;
			padding:0 10px;
			border:2.5px solid mediumpurple;
			outline:none;
			color:#515151;
			font-size:20px;
			width:100%;
			border-radius:50px;
		}
		.search_btn {
			display:inline-flex;
			width:40px;
			height:100%;
			background-color:mediumpurple;
			position:absolute;
			top:0;
			right:0;
			border-radius:50%;
			align-items: center;
			justify-content:center;
		}
		.search_btn:hover {
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
		}
		.search_btn > i {
			font-size:20px;
			color:white;
		}
		.search_result {
			padding-left:10px;
			color:gray;
			font-size:15px;
		}
		.err_msg {
			color: tomato;
			margin-top: -15px;
			display: none;
			padding-left:10px;
		}
		.point {
			color: dodgerblue;
		}
		.cnt {
			color: tomato;
		}
		
	</style>
</head>
<body>
		<%@include file="include/header.jsp" %>
		<div class="shs_manager">--학생검색-</div>
			
			<div class="in_content">
				<div class="search_wrap">
					<input type="text" placeholder="검색할 이름을 입력해주세요." id="input_search" class="input_search" maxlength="4">
					<a href="#" class="search_btn"><i class="fas fa-search"></i></a>
				</div>
				<span class="err_msg"></span>
			</div>
			
					
		
		
		<div class = "in_content">
			<table>
				<tr class="table_title">
					<th>ID</th>
					<th>NAME</th>
					<th>Tel.</th>
					<th></th>
					<th></th>
				</tr>
				<c:if test="${shslist.size() == 0}">
				 	<tr class="table_data">
				 		<td colspan = "5">조회가 된 학생이 없습니다.
				 	</tr>
				</c:if>
				
				<div class="in_content">
			<span class="search_result">
				검색결과: 총 ?건
			</span>
		</div>
		
		<div class="in_content">
			<c:if test="${search_cnt > 0}">
			 	<span class="search_result">
			 		"<span class="point">${name}</span>으로 검색한 결과 <span class="cnt">총 ${search_cnt}건 검색됨</span>
			 	</span>
			</c:if>
		</div>
			<c:forEach items="${shslist}" var="mDto"> <!--${shslest}= EL태그에 담긴 shslest를 mDto로 담는다. -->
				<tr class="table_data">
					<td>${mDto.sid}</td>
					<td>${mDto.sname}</td>
					<td>${mDto.sphone}</td>
					<td><a href="#" class="uBtn">수정</a></td>
					<td><a href="#" class="dBtn">삭제</a></td>
				</tr>
			</c:forEach>
		</table>

		<div class="div_index">
			<a href="index" class="btn_index btn3">뒤로가기</a>
		</div>

	</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(function() {
			
		$(".search_btn").click(function() {
			var name = $.trim($('#input_search').val());
			
			var regEmpty = /\s/g;
			// 숫자 못들어오게 체크
			var regNum = /[~0-9]/g;

			if (name == '' || name.length == 0) {
				$('.err_msg').css('display', 'block').css('color', 'tomato').text('필수 정보입니다.');
				return false;
			} else if (regNum.test(name)) {
				$('.err_msg').css('display', 'block').css('color', 'tomato').text('문자만 입력해주세요.');
				return false;
			} else if (name.match(regEmpty)) {
				$('.err_msg').css('display', 'block').css('color', 'tomato').text('공백없이 작성 하세요.');
				return false;
			} else if (name.length > 4 || name.length < 2 ) {
				$('.err_msg').css('display', 'block').css('color', 'tomato').text('2~4글자로만 작성해주세요');
				return false;
			}
				location.href="searchPlay.shs?name=" + name;
		});
	});
	</script>
</body>
</html>