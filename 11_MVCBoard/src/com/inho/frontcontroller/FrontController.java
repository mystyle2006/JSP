package com.inho.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inho.command.BoardCommand;
import com.inho.command.BoardDeleteCommand;
import com.inho.command.BoardEditCommand;
import com.inho.command.BoardListCommand;
import com.inho.command.BoardViewCommand;
import com.inho.command.BoardWriteCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGET");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPOST");
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BoardCommand command = null;
		
		//To get a name of page
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/content_view.do")) {
			//System.out.println("Content_View.do");
			command = new BoardViewCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			viewPage = "content_view.do?id=" + request.getAttribute("id");
		} else if(com.equals("/list.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/edit.do")) {
			command = new BoardEditCommand();
			command.execute(request, response);
			viewPage = "content_view.do?id=" + request.getAttribute("id");
		} else if(com.equals("/delete.do")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			
		} else if(com.equals("/reply.do")) {
			
		}
		
		//Forwarding to a selected page.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		//return;
	}
}
