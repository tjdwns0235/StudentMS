<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
		@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');
		* {font-family: 'Nanum Gothic', sans-serif; box-sizing: border-box;}
		body,ul {margin:0; padding: 0;}
		a {color: inherit; text-decoration: none;}
		ul {list-style: none;}

		.content {
			width: 390px;
			height: 600px;
			border:2px solid black;
			margin: 50px auto 0;
			background-color: #d8e9ef;
			border-radius: 5px; 
		}
		.shs_manager {
			padding-top: 40px;
			padding-bottom: 70px;
			text-align: center;
			color:#454552;
			font-size: 20px;
		}
		.container {
			height:340px;
			display: flex;
			flex-direction: column;
			justify-content: space-evenly;
			text-align: center;
			align-items: center;
		}
		.back_Btn {
			bottom: 0px;
			
		}
		.introduce {
			border: 1px solid black;
			width: 320px;
			height: 49px;
			background: white;
			text-align: center;	
			/* margin: 0 auto; */
		}
		.introduce strong {
			color: mediumseagreen;
		}
		.back_Btn {
			width: 110px;
			height: 45px;
			background-color:salmon; 
			line-height: 45px;
			border-radius: 6px;
			color: white;	
		}
		.foot {
			border: 1px solid black;
			width: 320px;
			height: 90px;
			background: white;
			text-align: center;
			align-items: center;
		}
		.img img {
			width: 70px;
			height: 50px;
			float: left;
		}
	</style>
</head>
<body>
	<div class="content">
		<%@include file="include/header.jsp" %>
		
		<div class="shs_manager">--만든이--</div>

		<div class="container">
			<span class="introduce">
				<strong>StudentMS</strong>는 교육생을 관리(등록,수정,제적,출석,검색)해주는 웹 프로그램입니다.
			</span>

			
			<span class="foot">
				<span class="img"><img src="images/img_lights.jpg"></span>
					<span>
					(주)노틸러스시스템즈<br>
						Developer:KMSJ<br>
						E-Mail:sungjoon0235@naver.com<br>
						ⓒ2019 nth Systems
					</span>
			</span>
			<a href="index.shs" class="back_Btn">뒤로가기</a>
		</div>

</body>
</html>