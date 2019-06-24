package com.swm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swm.daoimp.userdaoimp;


@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String StaffNum=request.getParameter("StaffNum");
            String PassWord=request.getParameter("PassWord");
            request.getSession().setAttribute("StaffNum",StaffNum);
            userdaoimp u1=new userdaoimp();
            String end=u1.select(StaffNum, PassWord);
            if(end.equals("查找成功")){
            	if(StaffNum.equals("666666")){
            		request.getRequestDispatcher("Personnel.html").forward(request, response);
            	}else if(StaffNum.equals("888888")){
            		request.getRequestDispatcher("Finance.html").forward(request, response);
            	}else{
            		request.getRequestDispatcher("Staff.html").forward(request, response);
            	}	
            }else{
            	request.getRequestDispatcher("File.html").forward(request, response);
            }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
