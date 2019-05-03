package com.shs.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class SearchPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_search.jsp";
		
		String name = request.getParameter("name");
//		System.out.println(name);
		
		MemberDAO mDao = MemberDAO.gerInstance();
		List<MemberDTO> list = mDao.memSearch(name);
		
		int search_cnt = list.size();
		request.setAttribute("name", name);
		request.setAttribute("cnt", search_cnt);
		request.setAttribute("search_cnt", search_cnt);
		
		request.setAttribute("shslist", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);//forward방식으로 보내줌
		
		return forward;
	}

}
