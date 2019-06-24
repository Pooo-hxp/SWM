package com.swm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swm.daoimp.StaffInfodaoimp;
import com.swm.daoimp.changedaoimp;


@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePassServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum=request.getParameter("StaffNum");
		System.out.println(StaffNum);
		String ChangeName=request.getParameter("ChangeName");
		System.out.println(ChangeName);
		String DeptName=request.getParameter("DeptName");
		String ChangeFont=request.getParameter("ChangeFont");
		
		StaffInfodaoimp s1=new StaffInfodaoimp();
		String end=s1.update(StaffNum, ChangeName);
		
		changedaoimp c1=new changedaoimp();
		String end1=c1.update(StaffNum,"审核完成");
		
		request.getRequestDispatcher("Person-Updata.html").forward(request, response);
	}

}
