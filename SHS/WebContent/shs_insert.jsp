<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록</title>
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
			border:none;
			cursor: pointer;
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
			backfround-color:white;
		}
		.btn_wrap {
			display: flex;
			padding: 15px 0;
			justify-content: space-evenly;
		}
		.err_msg {
			color: tomato;
			font-size: 14px;
			display: block;
			text-align:left;
			padding-left:80px;
		}

	</style>
</head>
<body>
	<div class="content">
	<%@include file="include/header.jsp" %>
			<div class="shs_manager">--학사등록--</div>

			<form action="insertPlay.shs" id="frm_insert" name="frm_insert" method="POST">
				<div class="in_content">
					<div class="div_input">
						<label for="input_name">이름:</label>
						<input type="text" id="input_name" name="input_name" class="shs_input" placeholder="NAME"><br>
						<span class="err_msg"></span>
					</div>

					<div class="div_input">
						<label for="input_age">나이:</label>
						<input type="text" id="input_age" name="input_age" class="shs_input" placeholder="AGE"><br>
						<span class="err_msg"></span>
					</div>

					<div class="div_input">
						<label for="input_major">전공:</label>
						<input type="text" id="input_major" name="input_major" class="shs_input" placeholder="MAJOR"><br>
						<span class="err_msg"></span>
					</div>

					<div class="div_input">
						<label for="input_phone">Phone:</label>
						<input type="text" id="input_phone" name="input_phone" class="shs_input" placeholder="PHONE"><br>
						<span class="err_msg"></span>
					</div>
				</div>
				<div class="div_index btn_wrap">
					<a href="index.shs" class="btn_index btn3">취소</a>
				<!-- 	<a href="#" class="btn_index btn1 submitBtn">등록</a> -->
				<!--(1) button 클릭시 JQurey의 click() 이벤트 발생
						JQurey click()이벤트 function()으로 이동  -->
				<button type="submit" class="btn_index btn1 submitBtn">등록</button>
				</div>
			</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
		$(function(){
			// input태그 포커스 => border 효과
			$('.shs_input').focus(function(){
				$(this).css('border', '1px solid dodgerblue');
			});
			$('.shs_input').blur(function(){
				$(this).css('border', '1px solid #aaa');
			});
			
			//KeyUp()을 활용한 유효성 체크 (input 값)
			/* $('#input_name').keyup(function(){
				nameCheck();
			}); */
			$('#input_age').keyup(function(){
				ageCheck();
			});
			
			$('#input_major').keyup(function(){
				majorCheck();
			});
			$('#input_phone').keyup(function(){
				phoneCheck();
			});
			// 등록버튼 클릭시 form태그 안에 있는 input태그의 값을 Servlet으로 전송
			$('.submitBtn').click(function(){
				// (2) 유효성체크 시작!
				
				/* if (!nameCheck()) {
					$('#input_name').focus();
					return false;
				}
				if (!ageCheck()) {
					$('#input_age').focus();
					return false;
				}
				if (!majorCheck()) {
					$('#input_major').focus();
					return false;
				}
				if (!phoneCheck()) {
					$('#input_phone').focus();
					return false;
				} */
				// ----유효성 체크 완료 ----
				// ----유효한 값만 있음 ----
				
				// form 태그의 action주소로method방식을 통하여 데이터를 전송
				
				//(3) 유효성체크 완료: 모두 유효한 값으로 판독
				// #frm_insert 속성을 가진 form태그를 submit()함
				// * submit 동작
				// Method = POST
				// Action = "insertPlay.shs"
				//form 태그 안에 있는 input태그들의 value(이름, 나이, 전공 , 전공, 번호)를 POST방식으로 insertPlay.shs(FrontController)로 전송
				//Action:SHSInsert(Servlet)
				//Method: POST 방식
				$('#frm_insert').submit();
			});
			
		});
		
</script>
</html>