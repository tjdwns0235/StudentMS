		
//		function nameCheck() {
//			var name = $.trim($('#input_name').val());
//			// 공백 문자 체크
//			var regEmpty = /\s/g;
//			// 숫자 못들어오게 체크
//			var regNum = /[~0-9]/g;
//
//			if (name == '' || name.length == 0) {
//				$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato').text('필수 정보입니다.');
//				return false;
//			} else if (regNum.test(name)) {
//				$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato').text('문자만 입력해주세요.');
//				return false;
//			} else if (name.match(regEmpty)) {
//				$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato').text('공백없이 작성 하세요.');
//				return false;
//			} else if (name.length > 4 || name.length < 2 ) {
//				$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato').text('2~4글자로만 작성해주세요');
//				return false;
//			} else {
//				$('err_msg').eq(0).css('display', 'block').css('color', 'dodgerblue').text('멋진이름이네요.');
//			    return true;
//			}
//		}
	
		function ageCheck() {
			var age = $.trim($('#input_age').val());
			
			if (age == '' || age.length == 0) {
				$('.err_msg').eq(1).css('display', 'block').css('color', 'tomato').text('필수정보입니다.');
				return false;
			} else if (isNaN(age)) {
				$('.err_msg').eq(1).css('display', 'block').css('color', 'tomato').text('숫자만 입력해주세요.');
				return false;
			} else if (age > 99 || age < 19 ) {
				$('.err_msg').eq(1).css('display', 'block').css('color', 'tomato').text('19~99세까지만 입력해주세요.');
				return false;
			} else {
				$('.err_msg').eq(1).css('display', 'block').css('color', 'dodgerblue').text('등록가능 합니다');
				return true;
			}
		}
		
		function majorCheck() {
			var major = $.trim($('#input_major').val());
			// 공백 문자 체크
			var regEmpty = /\s/g;
			// 숫자 못들어오게 체크
			var regNum = /[~0-9]/g;
			
			if (major.length == 0) {
				$('.err_msg').eq(2).css('display', 'none').css('color', 'tomato').text('올바른 값을 입력해주세요.');
				return true;
			} else if (regNum.test(major)) {
				$('.err_msg').eq(2).css('display', 'block').css('color', 'tomato').text('문자만 입력해주세요.');
				return false;
			} else if (major.match(regEmpty)) {
				$('.err_msg').eq(2).css('display', 'block').css('color', 'tomato').text('공백없이 작성 하세요.');
				return false;
			} else {
				$('.err_msg').eq(2).css('display', 'block').css('color', 'dodgerblue').text('올바르게 입력된 전공입니다.');
				return true;
			}
			
		}
		
		function phoneCheck() {
			var phone = $.trim($('#input_phone').val());
			// 공백 문자 체크
			var regEmpty = /\s/g;
			// 숫자 못들어오게 체크
			var regNum = /[~0-9]/g;
			var phoneReg = RegExp(/^[0-9]{8,11}$/);
			
			if (phone == '' || phone.length == 0) {
				$('.err_msg').eq(3).css('display', 'block').css('color', 'tomato').text('필수정보입니다.');
				return false;
			} else if (isNaN(phone)) {
				$('.err_msg').eq(3).css('display', 'block').css('color', 'tomato').text('숫자만 입력해주세요.');
				return false;
			} else if (!phoneReg.test(phone)) {
				$('.err_msg').eq(3).css('display', 'block').css('color', 'tomato').text('올바른 값을 입력해주세요.');
				return false;
			} else {
				$('.err_msg').eq(3).css('display', 'block').css('color', 'dodgerblue').text('사용가능한 번호입니다.');
				return true;
			}
		}
		