package com.inho.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inho.dao.BoardDao;

public class BoardDeleteCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		String id = request.getParameter("id");
		System.out.println(id);
		dao.delete(id);
	}
}
