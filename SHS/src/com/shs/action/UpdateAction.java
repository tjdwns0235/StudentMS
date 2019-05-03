package com.shs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_update.jsp";
		
		int id = Integer.parseInt(request.getParameter("id"));
			MemberDAO mDao = MemberDAO.getInstance();
			MemberDTO mDto = mDao.memInfo(id);
			request.setAttribute("memInfo", mDto);
			
			
			List<MemberDTO> list = mDao.memSelect();
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);// forward방식으로 보냄
		
		return forward;
	}

}
