package com.swm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.swm.daoimp.StaffInfodaoimp;
import com.swm.daoimp.changedaoimp;
import com.swm.model.StaffInfo;
import com.swm.model.change;

@WebServlet("/changeServlet")
public class changeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public changeServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum=(String)request.getSession().getAttribute("StaffNum");
		StaffInfodaoimp s1=new StaffInfodaoimp();
		StaffInfo end=s1.select(StaffNum);
		String DeptName=end.getDeptName();
		change end1=new change();
		end1.setStaffNum(StaffNum);
		end1.setDeptName(DeptName);;
		
		PrintWriter out = response.getWriter();
        Gson gson=new Gson();
        String end2=gson.toJson(end1);
        out.write(end2);
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StaffNum=request.getParameter("StaffNum");
		String DeptName=request.getParameter("DeptName");
		String ChangeName=request.getParameter("ChangeName");
		String Change=request.getParameter("Change");
		changedaoimp c1=new changedaoimp();
		String end=c1.insert(StaffNum, DeptName, ChangeName, Change);
		request.getRequestDispatcher("Staff.html").forward(request, response);
	}

}
