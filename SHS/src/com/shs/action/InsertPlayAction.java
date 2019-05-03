package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class InsertPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		
		//(7) jsp > FrontController > InsertPlayAction으로 request를 사용하여 전송한 input태그들의 value를 꺼내서
		// sname, sage, smajor, sphone 변수에 각각 담음
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		//Model Start
		// (8) MemberDAO 객체 빌림
		MemberDAO mDao = MemberDAO.getInstance();
		//(9) MemberDTO 객체 생성과 동시에 (이름,나이, 전공, 번호)값을 초기화
		MemberDTO mDto = new MemberDTO(sname, sage, smajor, sphone);
		// (10) MemberDAO 클래스의 memInsert()함수를 실행 매개변수로 (이름, 나이, 전공, 번호)가 담긴mDto를 전송
		int result = mDao.memInsert(mDto);
//		(16) MemberDAO의 memInsert()메서드에서 보낸 return값을 result 변수에 담음
		
//		(17) result > 0 : 등록 성공
//		else :등록 실패
//		등록 성공시 이동하는 페이지를 welcome페이지로 설정
//		등록 실패시 이동하는 페이지를 학생등록페이지로 이동
		if (result > 0) {
			url = "welcome.jsp";
		} else {
			url = "insert.shs";
		}
//		(18) ActionForward 객체를 생성 후 forward 인스턴스를 활용하여
//		forward 인스턴스의 path변수에 "welcome.shs"를 forward 인스턴스의 isResirect에 true값을 각각 담음
//		값이 변하는건 redirect 변하지 않는건 forward
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true); //sendRedirect 방식
		//8.path와 isRedirect값을 담고 있는 forward를
//		return를 사용하여 호출한곳(FrontController)으로 전송
		return forward ;
	}

}
