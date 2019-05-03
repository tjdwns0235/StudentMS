package com.shs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class SelectPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_select.jsp";
		
		//�л���� DB���� �����ͼ� View�� ����
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberDTO> list = mDao.memSelect();
		request.setAttribute("shslist", list);
		
		//�� �ο� ��
		int cnt = list.size();
		request.setAttribute("cnt", cnt);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);// forward������� ����
		
		return forward;
	}

}
