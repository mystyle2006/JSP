package com.inho.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inho.dao.BoardDao;
import com.inho.dto.BoardDto;

public class BoardEditCommand implements BoardCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = dao.edit(id, name, title, content);
		
		request.setAttribute("id", result);
	}
	
}
