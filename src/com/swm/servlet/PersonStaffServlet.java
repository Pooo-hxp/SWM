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
import com.swm.daoimp.StaffInfodaoimp;
import com.swm.model.StaffInfo;

@WebServlet("/PersonStaffServlet")
public class PersonStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PersonStaffServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffInfodaoimp s1=new StaffInfodaoimp();
		ArrayList<StaffInfo> end=s1.select();	
		
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
