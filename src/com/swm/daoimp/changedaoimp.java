package com.swm.daoimp;

import java.util.ArrayList;

import com.swm.dao.changedao;
import com.swm.model.change;

import lzy.DateBase;

public class changedaoimp implements changedao{
	DateBase sw=new DateBase("sw","root","root");
	
	@Override
	public String delete(String StaffNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(String StaffNum,String DeptName,String ChangeName, String ChangeFont) {
		String end ="";
		String sql="insert into changetable(StaffNum,DeptName,ChangeName,ChangeFont,State)values(?,?,?,?,?)";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.getOrder().setString(2,DeptName);
			sw.getOrder().setString(3,ChangeName);
			sw.getOrder().setString(4,ChangeFont);
			sw.getOrder().setString(5,"待审核");
			if(sw.getOrder().executeUpdate()>0){
				end="插入成功";
			}else{
				end="插入失败";
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public String update(String StaffNum,String State) {
		String end="";
		String sql="update changetable set State=? where StaffNum=? ";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,State);
			sw.getOrder().setString(2,StaffNum);
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
	public change select(String StaffNum) {
		change end=new change();
		String sql="select * from changetable where StaffNum=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.ask();
			if(sw.getResult().next()){
				end.setStaffNum(StaffNum);
				end.setDeptName(sw.getResult().getString("DeptName"));
				end.setChangeName(sw.getResult().getString("ChangeName"));
				end.setChangeFont(sw.getResult().getString("ChangeFont"));
				end.setState(sw.getResult().getString("State"));
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public ArrayList<change> select() {
		ArrayList<change> end=new ArrayList<change>();
		String sql="select * from changetable";	
		try {
			sw.link(sql);
			sw.getOrder();
			sw.ask();
			while (sw.getResult().next()) {
			   change c1=new change();
               c1.setStaffNum(sw.getResult().getString("StaffNum"));
               c1.setDeptName(sw.getResult().getString("DeptName"));
               c1.setChangeName(sw.getResult().getString("ChangeName"));
               c1.setChangeFont(sw.getResult().getString("ChangeFont"));
               c1.setState(sw.getResult().getString("State"));
			   end.add(c1);
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

}
