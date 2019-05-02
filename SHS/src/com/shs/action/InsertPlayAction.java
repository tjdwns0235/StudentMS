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
		
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		MemberDAO mDao = MemberDAO.gerInstance();
		MemberDTO mDto = new MemberDTO(sname, sage, smajor, sphone);
		int result = mDao.memInsert(mDto);
		
		if (result > 0) {
			url = "welcome.jsp";
		} else {
			url = "insert.shs";
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true); //sendRedirect ¹æ½Ä
		
		return forward ;
	}

}
