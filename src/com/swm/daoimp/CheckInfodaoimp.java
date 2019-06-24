package com.swm.daoimp;

import java.util.ArrayList;

import com.swm.dao.CheckInfodao;
import com.swm.model.CheckInfo;

import lzy.DateBase;

public class CheckInfodaoimp implements CheckInfodao{
	DateBase sw=new DateBase("sw","root","root");
	
	@Override
	public String delete(String StaffNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(String StaffNum, String Sleep, String OverTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String StaffNum, String Sleep, String OverTime, String Payroll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckInfo select(String StaffNum) {
		CheckInfo end=new CheckInfo();
		String sql="select * from checkinfo where StaffNum=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.ask();
			if(sw.getResult().next()){
				end.setPayroll(sw.getResult().getString("Payroll"));
				end.setOverTime(sw.getResult().getString("OverTime"));
				end.setSleep(sw.getResult().getString("Sleep"));
				end.setMoney(sw.getResult().getString("Money"));
				end.setStaffNum(StaffNum);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public ArrayList<CheckInfo> select() {
		ArrayList<CheckInfo> end=new ArrayList<CheckInfo>();
		String sql="select * from checkinfo";
		try {
			sw.link(sql);
			sw.getOrder();
			sw.ask();
			while (sw.getResult().next()) {
				CheckInfo c1=new CheckInfo();
				c1.setPayroll(sw.getResult().getString("Payroll"));
				c1.setOverTime(sw.getResult().getString("OverTime"));
				c1.setSleep(sw.getResult().getString("Sleep"));
				c1.setMoney(sw.getResult().getString("Money"));
				c1.setStaffNum(sw.getResult().getString("StaffNum"));
				end.add(c1);
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}
	
}
