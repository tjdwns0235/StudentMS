package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("11111111111111");
		String url = "shs_insert.jsp";
		
//		7.ActionForward ��ü�� ���� ��
//		forward �ν��Ͻ��� Ȱ���Ͽ�
//		forward �ν��Ͻ��� path������ "shs_insert.jsp"��
//		forward �ν��Ͻ��� isRedirect������ false���� ����
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
//		8.path�� isRedirect���� ��� �ִ� forward��
//		return�� ����Ͽ� ȣ���Ѱ�(FrontController)���� ����
		
		return forward ;
	}
	
}
