<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생수정</title>
<link rel="stylesheet" href="css/common.css?v=1">
<style type="text/css">
		.content {
			width: 390px;
			height: 600px;
			border:2px solid black;
			margin: 50px auto 0;
			background-color: #eee;
			border-radius: 5px; 
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
			padding-bottom: 
		}
		.shs_manager {
			padding-top: 20px;
			padding-bottom: 20px;
			text-align: center;
			color:#454552;
			font-size: 20px;
		}
		.btn_index {
			padding: 10px 12px;
			color: white;
			background-color: yellowgreen;
			width:140px;
			display: inline-block;
			border-radius: 10px;
			font-size: 17px;
			border:0;
			cursor:pointer;
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
			background-color: salmon;
		}
		.btn3 {
			background-color: salmon;
		}
		.in_content {
			text-align: right;
		}
		.div_input {
			padding:3px 20px;
		} 
		.div_input > label {
			float: left;
			line-height: 40px;
		}
		.shs_input {
			width: 270px;
			display: inline-block;
			height:40px;
			font-size: 16px;
			color:#515151;
			outline: none;
			border:1px solid #aaa;
			padding: 0 10px;
		}
		.btn_wrap {
			display: flex;
			padding: 15px 0;
			justify-content: space-evenly;
		}
		hr {
			margin: 2px 0px;
			border: 1px dashed #515151;
		}
		#input_id {
			background: lightyellow;
			border: 1px solid #aaa!important;
		}

	</style>
</head>
<body>
	<%@include file="include/header.jsp" %>
			<div class="shs_manager">--학사수정--</div>

			<form action="updatePlay.shs" id="frm_insert" name="frm_insert" method="POST">
				<div class="in_content">
					<hr>
					<div class="div_input">
						<label for="input_id">아이디:</label>
						<input type="text" id="input_id" name="input_id" class="shs_input" placeholder="ID" readonly="readonly"><br>
					</div>
					<hr>

					<div class="div_input">
						<label for="input_name">이름:</label>
						<input type="text" id="input_name" name="input_name" class="shs_input" placeholder="NAME"><br>
					</div>

					<div class="div_input">
						<label for="input_age">나이:</label>
						<input type="text" id="input_age" name="input_age" class="shs_input" placeholder="AGE"><br>
					</div>

					<div class="div_input">
						<label for="input_major">전공:</label>
						<input type="text" id="input_major" name="input_major" class="shs_input" placeholder="ID"><br>
					</div>

					<div class="div_input">
						<label for="input_phone">전화번호:</label>
						<input type="text" id="input_phone" name="input_phone" class="shs_input" placeholder="PHONE"><br>
					</div>
				</div>
				<div class="div_index btn_wrap">
					<a href="index.shs" class="btn_index btn3">취소</a>
	<!-- 				<a href="#" class="btn_index btn1">수정</a> -->
				<button type="submit" class="btn_index btn1">수정</button>_
				</div>
			</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
		$(function(){
			$('.shs_input').focus(function(){
				$(this).css('border', '1px solid dodgerblue');
			});
			$('.shs_input').blur(function(){
				$(this).css('border', '1px solid #aaa');
			});

		});
</script>
</html>