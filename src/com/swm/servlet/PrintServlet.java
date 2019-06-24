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
import com.swm.daoimp.StaffInfodaoimp;
import com.swm.model.CheckInfo;
import com.swm.model.StaffInfo;

@WebServlet("/PrintServlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrintServlet() {

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
		String StaffNum=(String)request.getSession().getAttribute("StaffNum");
		StaffInfodaoimp s1=new StaffInfodaoimp();
		StaffInfo end=s1.select(StaffNum);
		
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String end1=gson.toJson(end);
		out.write(end1);
		out.close();
	}

}
