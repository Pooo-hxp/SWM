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
import com.swm.daoimp.CheckInfodaoimp;
import com.swm.model.CheckInfo;

@WebServlet("/PersonCheckServlet")
public class PersonCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PersonCheckServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckInfodaoimp c1=new CheckInfodaoimp();
		ArrayList<CheckInfo> end=c1.select();
		
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String end1=gson.toJson(end);
		out.write(end1);
		out.close();
	}

}
