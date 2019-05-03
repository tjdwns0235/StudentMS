package com.shs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

/**
 * Servlet implementation class SHSInsert
 */
@WebServlet("/SHSInsert")
public class SHSInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET: �л���� ������ ���");
		response.sendRedirect("shs_insert.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST:DB�� �л� ȸ�� ���!");
		// Post��� �ѱ� ���� ����
		request.setCharacterEncoding("UTF-8");
		
		String sname = request.getParameter("input_name");
		
		int sage = Integer.parseInt(request.getParameter("input_age"));
		
		String smajor = request.getParameter("input_major");
		String sphone = request.getParameter("input_phone");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = new MemberDTO(sname, sage, smajor, sphone);
		
		int result = mDao.memInsert(mDto);
		
		if (result > 0) {
			response.sendRedirect("welcome");
		} else {
			response.sendRedirect("SHSInsert");
		}
		
		System.out.println(sname + "," +  sage + "," +  smajor + "," + sphone);
	}

}
