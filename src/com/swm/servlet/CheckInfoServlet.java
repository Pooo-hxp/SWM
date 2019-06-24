package com.swm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.swm.daoimp.CheckInfodaoimp;
import com.swm.model.CheckInfo;

@WebServlet("/CheckInfoServlet")
public class CheckInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckInfoServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum=(String)request.getSession().getAttribute("StaffNum");
		CheckInfodaoimp c1=new CheckInfodaoimp();
		CheckInfo end=c1.select(StaffNum);
		
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String end1=gson.toJson(end);
		out.write(end1);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
