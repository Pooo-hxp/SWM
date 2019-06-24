package com.swm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.swm.daoimp.Msgdaoimp;
import com.swm.model.Msg;

@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MsgServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum="666666";
		String StaffNum1="888888";
		Msgdaoimp m1=new Msgdaoimp();
		ArrayList<Msg> end=m1.select(StaffNum,StaffNum1);
		

		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String end1=gson.toJson(end);
		out.write(end1); 
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum="666666";
		String StaffNum1="888888";
		Msgdaoimp m1=new Msgdaoimp();
		ArrayList<Msg> end=m1.select1(StaffNum,StaffNum1);
		

		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String end1=gson.toJson(end);
		out.write(end1);
		out.close();
	}

}
