package com.swm.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.swm.dao.bankdao;
import com.swm.model.banklist;

import lzy.DateBase;

public class bankdaoimp implements bankdao{
	DateBase sw=new DateBase("sw","root","root");
	
	
	@Override
	public String delete(String IDNum) {
		String end="";
		String sql="delete from banklist where IDNum=?";
		sw.link(sql);
		try {
			sw.getOrder().setString(1,IDNum);
			if(sw.getOrder().executeUpdate()>0){
				end="删除成功";
			}else{
				end="删除失败";
			}
			sw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return end;
	}

	@Override
	public String insert() {
		String end="";
		String sql="insert into banklist()values(?,?)";
		return end;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public banklist select(String IDNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<banklist> select() {
		ArrayList<banklist> end=new ArrayList<banklist>();
		String sql="select * from banklist";
		try {
			sw.link(sql);
			sw.getOrder();
			sw.ask();
			while(sw.getResult().next()){
				banklist b1=new banklist();
				b1.setBankName(sw.getResult().getString("BankName"));
				b1.setIDNum(sw.getResult().getString("IDNum"));
				b1.setMoney(sw.getResult().getString("Money"));
				b1.setStaffName(sw.getResult().getString("StaffName"));
				b1.setUnit(sw.getResult().getString("Unit"));
				end.add(b1);
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

}
