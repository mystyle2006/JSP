package com.inho.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inho.dao.BoardDao;
import com.inho.dto.BoardDto;

public class BoardViewCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		String id = request.getParameter("id");
		
		//System.out.println(id);
		
		BoardDto dto = dao.selected(id);
		
		request.setAttribute("list", dto);
	}
}
