package com.swm.daoimp;

import java.util.ArrayList;

import com.swm.dao.Msgdao;
import com.swm.model.Msg;

import lzy.DateBase;

public class Msgdaoimp implements Msgdao{
	DateBase sw= new DateBase("sw","root","root");
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(String StaffNum,String StaffName,String Txt,String DateTime) {
		String end="";
		String sql="insert into msg(StaffNum,StaffName,Txt,DateTime) values(?,?,?,?)";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.getOrder().setString(2,StaffName);
			sw.getOrder().setString(3,Txt);
			sw.getOrder().setString(4,DateTime);
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
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Msg>select(String StaffNum ,String StaffNum1){
		ArrayList<Msg> end=new ArrayList<Msg>();
		String sql="select * from msg where StaffNum=? or StaffNum=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.getOrder().setString(2,StaffNum1);
			sw.ask();
			while(sw.getResult().next()){
				Msg m1=new Msg();
				m1.setStaffNum(StaffNum);
				m1.setStaffName(sw.getResult().getString("StaffName"));
				m1.setTxt(sw.getResult().getString("Txt"));
				m1.setDateTime(sw.getResult().getString("DateTime"));
				end.add(m1);
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}
	
	public ArrayList<Msg>select1(String StaffNum ,String StaffNum1){
		ArrayList<Msg> end=new ArrayList<Msg>();
		String sql="select * from msg where StaffNum!=? and StaffNum!=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.getOrder().setString(2,StaffNum1);
			sw.ask();
			while(sw.getResult().next()){
				Msg m1=new Msg();
				m1.setStaffNum(StaffNum);
				m1.setStaffName(sw.getResult().getString("StaffName"));
				m1.setTxt(sw.getResult().getString("Txt"));
				m1.setDateTime(sw.getResult().getString("DateTime"));
				end.add(m1);
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}
	
}
