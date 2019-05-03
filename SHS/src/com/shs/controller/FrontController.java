package com.shs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.action.Action;
import com.shs.action.ActionForward;
import com.shs.action.IndexAction;
import com.shs.action.InsertAction;
import com.shs.action.InsertPlayAction;
import com.shs.action.IntroduceAction;
import com.shs.action.SearchAction;
import com.shs.action.SearchPlayAction;
import com.shs.action.WelcomeAction;


	//FrontController ����
	//�մܿ��� Controller ������ �ϴ� Servlet 1����
	//���� �� ������ 1���� Servlet�� request�� response�� 
	//��� ó���ϰ�, ���� �����ϴ� Action�κи� Class�� 
	//������ �����ؼ� ����ϴ� ��
	//������ ���۸��� Servlet�� �����ϴ� ��Ŀ� ���� ȿ������ �ſ� Up ��
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	// doGet(), doPost() ��� service()�� ���ؼ� �۵��ϰ�
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ۱��� ����(Post���): ���� ���� ����� ��.
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;
		ActionForward forward = null; //Action���� ����  forward
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		//uri���� ctx�� ���� ���� ���ϴ� �ҽ��� ���� �� �ִ�.
		System.out.println("uri ===>" + uri);
		System.out.println("ctx==>" + ctx);
		System.out.println("cmd===>" +command);
		
		System.out.println("�������̵� ===>" + command);
		
		if (command.equals("/index.shs")) {
			action = new IndexAction();
			forward = action.execute(request, response);
		} else if (command.equals("/insert.shs")) {
			action = new InsertAction();
			forward = action.execute(request, response);
		} else if (command.equals("/insertPlay.shs")) {
			action = new InsertPlayAction();
			forward = action.execute(request, response);
		} else if (command.equals("/welcome.shs")) {
			action = new WelcomeAction();
			forward = action.execute(request, response);
		} else if (command.equals("/search.shs")) {
			action = new SearchAction();
			forward = action.execute(request, response);
		} else if (command.equals("/searchPlay.shs")) {
			action = new SearchPlayAction();
			forward = action.execute(request, response);
		} else if (command.equals("/introduce.shs")) {
			action = new IntroduceAction();
			forward = action.execute(request, response);
		}
		
		
		
		
		//���� �б� �۾�
		if (forward != null) {
			if (forward.isRedirect()) {
				//page ��ȯ�� redirect ���
				response.sendRedirect(forward.getPath());
			}else {
				//page ��ȯ�� forward���
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}
