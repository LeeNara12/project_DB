package Lv2.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lv1.list.ListVO;


@WebServlet("/map")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String map = request.getParameter("map");
		if("login".equals(map)) {
			
			String ename = request.getParameter("ename").toUpperCase();
			int empno = Integer.parseInt(request.getParameter("empno"));
			//getParameter는 String으로 받음
			String tf = request.getParameter("bool");
			
			
			if(tf==null) {
				ListVO vo = new ListVO();
				vo.setEname(ename);
				vo.setEmpno(empno);
				loginDAO login_dao = new loginDAO();
				HashMap hm= login_dao.login(vo);
				boolean result= (boolean) hm.get("result");
				String str1 = (String) hm.get("str1");
				if(result==true) {
					request.setAttribute("result", result);
					request.setAttribute("str1", str1);
					RequestDispatcher rdp = request.getRequestDispatcher("login.jsp");
					rdp.forward(request,response);
				}else {
					request.setAttribute("result", result);
					request.setAttribute("str1", str1);
					RequestDispatcher rdp = request.getRequestDispatcher("login.jsp");
					rdp.forward(request,response);
				}
			}else if("true".equals(tf)) {
				
				RequestDispatcher rdp = request.getRequestDispatcher("list.jsp");
				rdp.forward(request,response);
				
			}else if("false".equals(tf)) {
				
				RequestDispatcher rdp = request.getRequestDispatcher("login.jsp");
				rdp.forward(request,response);
				
			}
		}
	}
	

}
