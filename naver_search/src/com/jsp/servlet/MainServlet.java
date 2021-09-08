package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day0802.GugudanForWeb;

@WebServlet("/gugudan")
public class MainServlet extends HttpServlet {
	// 주소줄로 요청하는것은 Get 이다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GugudanForWeb gugudan = new GugudanForWeb();
		
		// 입력
		gugudan.setDan(Integer.parseInt(request.getParameter("dan")));
		gugudan.setGop(Integer.parseInt(request.getParameter("gop")));
		
		// 처리
		gugudan.processGugudan();
		
		// 출력
		response.setContentType("text/plain; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.print(gugudan.getResult());
		
	}

}
