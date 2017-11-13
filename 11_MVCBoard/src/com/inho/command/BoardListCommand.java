package com.inho.command;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inho.dao.BoardDao;
import com.inho.dto.BoardDto;

public class BoardListCommand implements BoardCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
	
}
