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
import com.shs.action.DeletePlayAction;
import com.shs.action.IndexAction;
import com.shs.action.InsertAction;
import com.shs.action.InsertPlayAction;
import com.shs.action.IntroduceAction;
import com.shs.action.SearchAction;
import com.shs.action.SearchPlayAction;
import com.shs.action.SelectPlayAction;
import com.shs.action.UpdateAction;
import com.shs.action.UpdatePlayAction;
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
		
		
		//4 uri�� ctx�� ���� ��θ� �����Ѵ�
		// uri = /SHS/insert.shs
		// ctx = /SHS
		// uri - ctx = /insert.shs
		//������ ��� = /insert.shs
		
		
		//(4) uri�� ctx�� ���� ��θ� �����Ѵ�
		// uri = /SHS/insertPlay.shs
		// ctx = /SHS
		// uri - ctx = /insertPlay.shs
		//������ ��� = /insertPlay.shs = command
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		//uri���� ctx�� ���� ���� ���ϴ� �ҽ��� ���� �� �ִ�.
		System.out.println("uri ===>" + uri);
		System.out.println("ctx==>" + ctx);
		System.out.println("cmd===>" +command);
		
		System.out.println("�������̵� ===>" + command);
		
		//5. if���� ���鼭 ������
//		url�ּ�(/insert.shs)�� ���� ���ǹ��� Ž��
		//(5) if���� ���鼭 ������
//		url�ּ�(/insertPlay.shs)�� ���� ���ǹ��� Ž��
		if (command.equals("/index.shs")) {
			action = new IndexAction();
			forward = action.execute(request, response);
		} else if (command.equals("/insert.shs")) {
//			6.InsertAction Ŭ���� ��ü ������ ������ action �ν��Ͻ��� ����Ͽ�
//			execute(request,response)�Լ��� ����
//			�Ű������� request�� response�� ����
			action = new InsertAction();
			//9.InsertAction Ŭ�������� ���� return��(forward)�� �������� forward�� ����
			forward = action.execute(request, response);
		} else if (command.equals("/insertPlay.shs")) {
			//6.InsertPlayAction Ŭ���� ��ü ������ ������ action �ν��Ͻ��� ����Ͽ�
//			execute(request,response)�Լ��� ����
//			�Ű������� request�� response�� ����
			//*���� jsp���� ���� input�±׵��� ���� request�� �������
			//*execute() �Լ��� ���� �� �� �Ű������� request�� ����������
			// InsertPlayAction Ŭ�������� input�±׵��� ���� ��� �� �� ����
			action = new InsertPlayAction();
			//(20).InsertPlayAction Ŭ�������� ���� return��(forward)�� �������� forward�� ����
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
		} else if (command.equals("/select.shs")) {
			action = new SelectPlayAction();
			forward = action.execute(request, response);
		} else if (command.equals("/update.shs")) {
			action = new UpdateAction();
			forward = action.execute(request, response);
		} else if (command.equals("/updatePlay.shs")) {
			action = new UpdatePlayAction();
			forward = action.execute(request, response);
		}else if (command.equals("/delete.shs")) {
			action = new DeletePlayAction();
			forward = action.execute(request, response);
		}
		
		
		//delete.shs?id="+ id
		
		//���� �б� �۾�
		//10. InsertAction���� ���� return�� forward�� ����Ͽ� ������ �̵� ��ο� ��� �����͸� ����
		// forward.getPath = "shs_insert.jsp"
		// forward.isRedirect() = false;
		//forward�� null�� �ƴϱ� ������ if���� ����
		
		//(21). InsertPlayAction���� ���� return�� forward�� ����Ͽ� ������ �̵� ��ο� ��� �����͸� ����
				// forward.getPath = "welcome.jsp"
				// forward.isRedirect() = true;
				//forward�� null�� �ƴϱ� ������ if���� ����
		if (forward != null) {
			//11. forward.isRedirect()�� false�̱⶧����
			  // if���� �������� �ʰ� else���� ����
			//(21). forward.isRedirect()�� true�̱⶧����
			  // if���� ����
			if (forward.isRedirect()) {
				//page ��ȯ�� redirect ���
				//(23).sendRedirect������� 'welcome.jsp' �������� �̵�
				response.sendRedirect(forward.getPath());
			}else {
				//page ��ȯ�� forward���
				//12.forward������� shs_insert.jsp �������� �̵�
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}
