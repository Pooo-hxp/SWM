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
import com.swm.daoimp.bankdaoimp;
import com.swm.model.banklist;

@WebServlet("/BankListServlet")
public class BankListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BankListServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bankdaoimp b1=new bankdaoimp();
		ArrayList<banklist> end=b1.select();
			
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String end1=gson.toJson(end);
		out.write(end1);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
