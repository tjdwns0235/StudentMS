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
		
		//(7) jsp > FrontController > InsertPlayAction���� request�� ����Ͽ� ������ input�±׵��� value�� ������
		// sname, sage, smajor, sphone ������ ���� ����
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		//Model Start
		// (8) MemberDAO ��ü ����
		MemberDAO mDao = MemberDAO.getInstance();
		//(9) MemberDTO ��ü ������ ���ÿ� (�̸�,����, ����, ��ȣ)���� �ʱ�ȭ
		MemberDTO mDto = new MemberDTO(sname, sage, smajor, sphone);
		// (10) MemberDAO Ŭ������ memInsert()�Լ��� ���� �Ű������� (�̸�, ����, ����, ��ȣ)�� ���mDto�� ����
		int result = mDao.memInsert(mDto);
//		(16) MemberDAO�� memInsert()�޼��忡�� ���� return���� result ������ ����
		
//		(17) result > 0 : ��� ����
//		else :��� ����
//		��� ������ �̵��ϴ� �������� welcome�������� ����
//		��� ���н� �̵��ϴ� �������� �л������������ �̵�
		if (result > 0) {
			url = "welcome.jsp";
		} else {
			url = "insert.shs";
		}
//		(18) ActionForward ��ü�� ���� �� forward �ν��Ͻ��� Ȱ���Ͽ�
//		forward �ν��Ͻ��� path������ "welcome.shs"�� forward �ν��Ͻ��� isResirect�� true���� ���� ����
//		���� ���ϴ°� redirect ������ �ʴ°� forward
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true); //sendRedirect ���
		//8.path�� isRedirect���� ��� �ִ� forward��
//		return�� ����Ͽ� ȣ���Ѱ�(FrontController)���� ����
		return forward ;
	}

}
