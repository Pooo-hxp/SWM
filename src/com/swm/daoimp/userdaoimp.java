package com.swm.daoimp;

import java.util.ArrayList;

import com.swm.dao.userdao;
import com.swm.model.user;

import lzy.DateBase;

public class userdaoimp implements userdao{
    DateBase sw=new DateBase("sw","root","root");

	@Override
	public String delete(String StaffNum) {
		String end="";
		String sql="delete from user where StaffNum=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			if(sw.getOrder().executeUpdate()>0){
				end="删除成功";
			}else{
				end="删除失败";
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public String insert(String StaffNum, String PassWord, String RoleID) {
		String end="";
		String sql="insert into user(StaffNum,PassWord,RoleID)values(?,?,?)";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.getOrder().setString(2,PassWord);
			sw.getOrder().setString(3,RoleID);
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
	public String update(String StaffNum,String PassWord) {
		String end="";
		String sql="update user set PassWord=? where StaffNum=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,PassWord);
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
	public String select(String StaffNum,String PassWord) {
		String end="";
		String sql="select * from user where StaffNum=? and PassWord=?";
		try {
			sw.link(sql);
			sw.getOrder().setString(1,StaffNum);
			sw.getOrder().setString(2,PassWord);
			sw.ask();
			if(sw.getResult().next()){
				end="查找成功";
			}else{
				end="查找失败";
			}
			sw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}

	@Override
	public ArrayList<user> select() {
		ArrayList<user> end=new ArrayList<user>();
		String sql="select * form user";
		try {
			sw.link(sql);
			sw.getOrder();
			sw.ask();
			sw.getResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return end;
	}
    
    
}
