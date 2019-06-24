package com.swm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swm.daoimp.Msgdaoimp;
import com.swm.daoimp.StaffInfodaoimp;


@WebServlet("/MsgAdd")
public class MsgAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MsgAdd() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum=(String) request.getSession().getAttribute("StaffNum");
		StaffInfodaoimp s1=new StaffInfodaoimp();
		String StaffName=s1.select(StaffNum).getStaffName();
		String Txt=request.getParameter("Txt");
		String DateTime=request.getParameter("DateTime");
		Msgdaoimp m1=new Msgdaoimp();
		m1.insert(StaffNum, StaffName, Txt, DateTime);
		
		if(StaffNum.equals("666666")){
			request.getRequestDispatcher("Personnel.html").forward(request, response);
		}else if(StaffNum.equals("888888")){
			request.getRequestDispatcher("Financedongtai.html").forward(request, response);
		}else{
			request.getRequestDispatcher("Staff.html").forward(request, response);
		}
		
	}

}
