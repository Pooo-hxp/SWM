package com.swm.daoimp;

import java.util.ArrayList;


import com.swm.dao.StaffInfodao;
import com.swm.model.StaffInfo;

import lzy.DateBase;

public class StaffInfodaoimp implements StaffInfodao{
    DateBase sw=new DateBase("sw", "root", "root");
	@Override
	public String delete(String StaffNum) {
		String end="";
		return end;
	}

	@Override
	public String insert(String StaffNum, String StaffName, String StaffSex, String StaffJob, String IDNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String StaffNum, String DeptName) {
		String end="";
		String sql="update staffinfo set DeptName=? where StaffNum=? ";
		try {
			sw.link(sql);
			sw.getOrder().setString(1, DeptName);
			sw.getOrder().setString(2, StaffNum);
			if(sw.getOrder().executeUpdate()>0){
				end="更新成功";
			}else{
				end="更新失败";
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public StaffInfo select(String StaffNum) {
		StaffInfo end=new StaffInfo();
		String sql="select * from staffinfo where StaffNum=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.ask();
			if(sw.getResult().next()){
				end.setStaffName(sw.getResult().getString("StaffName"));
				end.setStaffSex(sw.getResult().getString("StaffSex"));
				end.setStaffJob(sw.getResult().getString("StaffJob"));
				end.setIDNum(sw.getResult().getString("IDNum"));
				end.setDeptName(sw.getResult().getString("DeptName"));
				end.setStaffNum(StaffNum);
			}else{
				
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public ArrayList<StaffInfo> select() {
		ArrayList<StaffInfo> end=new ArrayList<StaffInfo>();
		String sql="select * from staffinfo where StaffNum!='666666' and StaffNum!='888888'";
		try {
			sw.link(sql);
			sw.getOrder();
			sw.ask();
			while (sw.getResult().next()) {
				StaffInfo s1=new StaffInfo();
				s1.setStaffName(sw.getResult().getString("StaffName"));
				s1.setStaffSex(sw.getResult().getString("StaffSex"));
				s1.setStaffJob(sw.getResult().getString("StaffJob"));
				s1.setIDNum(sw.getResult().getString("IDNum"));
				s1.setDeptName(sw.getResult().getString("DeptName"));
				s1.setDeptNum(sw.getResult().getString("DeptNum"));
				s1.setStaffNum(sw.getResult().getString("StaffNum"));
				end.add(s1);
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}
	
}
