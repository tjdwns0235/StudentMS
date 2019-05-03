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


	//FrontController 패턴
	//앞단에서 Controller 역할을 하는 Servlet 1개만
	//생성 후 생성된 1개의 Servlet이 request와 response를 
	//모두 처리하고, 실제 동작하는 Action부분만 Class로 
	//여러개 생성해서 사용하는 법
	//기존에 동작마다 Servlet을 생성하던 방식에 비해 효율성이 매우 Up 됨
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	// doGet(), doPost() 모두 service()로 통해서 작동하게
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글깨짐 방지(Post방식): 가장 위에 적어야 함.
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;
		ActionForward forward = null; //Action에서 보낸  forward
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		//uri에서 ctx를 빼면 내가 원하는 소스만 뽑을 수 있다.
		System.out.println("uri ===>" + uri);
		System.out.println("ctx==>" + ctx);
		System.out.println("cmd===>" +command);
		
		System.out.println("페이지이동 ===>" + command);
		
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
		
		
		
		
		//공통 분기 작업
		if (forward != null) {
			if (forward.isRedirect()) {
				//page 전환시 redirect 방식
				response.sendRedirect(forward.getPath());
			}else {
				//page 전환시 forward방식
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}
